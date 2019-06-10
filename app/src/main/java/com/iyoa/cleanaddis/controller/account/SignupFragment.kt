package com.iyoa.cleanaddis.controller.account


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.Navigation

import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.data.user.User
import com.iyoa.cleanaddis.data.user.UserData
import com.iyoa.cleanaddis.retrofitDelilah.AccountService
import com.iyoa.cleanaddis.retrofitDelilah.AccountServiceImpl
import kotlinx.android.synthetic.main.fragment_signin.*
import kotlinx.android.synthetic.main.fragment_signup.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SignupFragment : Fragment() {
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var usernameEditText:EditText
    private lateinit var passwordEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var  accountService: AccountService
    private lateinit var date:Instant
    private lateinit var user:User



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_signup, container, false)
            view.findViewById<View>(R.id.check_imageview).setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_signup_to_account_setting)
                loadField()
                addUser()
            }
        // Inflate the layout for this fragment
        return view
    }

    fun loadField(){
        firstNameEditText = firstname_edittext
        lastNameEditText = lastname_edittxt
        emailEditText = email_edittext
        usernameEditText = username_editText
        passwordEditText = password_edittext
        phoneNumberEditText = phonenumber

    }


    fun addUser(){
        date = Instant.now()

        accountService = AccountServiceImpl().getAccountServiceImpl()
        val userData = UserData(usernameEditText.text.toString(),
            firstNameEditText.text.toString(),
            lastNameEditText.text.toString(),
            emailEditText.text.toString(),
            passwordEditText.text.toString(),
            phoneNumberEditText.text.toString(),
            "",1,0,Date.from(date),
            Date.from(date)
            )
        val call: Call<User> = accountService.addUser(userData)

        call.enqueue(object: Callback<User> {


            override fun onResponse(call: Call<User>, response: Response<User>) {

                user = response.body() as User
            }

            override fun onFailure(call: Call<User>, t:Throwable){
                Log.wtf("ArticleLine85",t.message)
            }

        })

    }


}
