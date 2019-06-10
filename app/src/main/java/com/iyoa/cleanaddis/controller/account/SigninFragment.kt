package com.iyoa.cleanaddis.controller.account


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.Navigation

import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.data.user.User
import com.iyoa.cleanaddis.retrofitDelilah.AccountService
import com.iyoa.cleanaddis.retrofitDelilah.AccountServiceImpl
import com.iyoa.cleanaddis.retrofitDelilah.ArticleServiceImpl
import kotlinx.android.synthetic.main.fragment_signin.*
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SigninFragment : Fragment() {

    private lateinit var  accountService: AccountService
    private lateinit var usernameEmailEditText: EditText
    private lateinit var  passwordEditText: EditText
    private lateinit var user:User
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_signin, container, false)

        view.findViewById<View>(R.id.account_signin_button).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_signin_to_account_setting)
        login()
        }
        // Inflate the layout for this fragment
        return view
    }
    fun loadFields(){
        usernameEmailEditText = username_email_edittext
        passwordEditText = password_edittext
        var usernameOrEmail = usernameEmailEditText.text
        var password = passwordEditText.text
    }

    fun getUser(){

        accountService = AccountServiceImpl().getAccountServiceImpl()
        val call: Call<User> = accountService.getUserByUsername(usernameEmailEditText.text.toString())

        call.enqueue(object: Callback<User> {


            override fun onResponse(call: Call<User>, response: Response<User>) {

                user = response.body() as User
            }

            override fun onFailure(call: Call<User>, t:Throwable){
                Log.wtf("ArticleLine85",t.message)
            }

        })

    }

    fun login(){
        getUser()
        val username = user.username
        val password = user.password
        if(usernameEmailEditText.text.toString()==username &&
                passwordEditText.text.toString()==password){
            saveSession(username,user.email,user.lastVisit)
        }

    }
    fun saveSession(username:String,email:String,lastActive: Date){
        val sharedPreference = activity?.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        with(sharedPreference!!.edit()){
            putString("username",username)
            putString("email",email)
            putString("date",lastActive.toString())
            commit()
        }
    }


}
