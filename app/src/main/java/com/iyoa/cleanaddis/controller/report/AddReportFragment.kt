package com.iyoa.cleanaddis.controller.report


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import androidx.navigation.Navigation

import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.data.news.Article
import kotlinx.android.synthetic.main.fragment_add_report.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AddReportFragment : Fragment() {

    private lateinit var addButton: ImageButton
    private lateinit var headerEditText: EditText
    private lateinit var textEditText : EditText
    private lateinit var categorySpinner: Spinner
    private lateinit var subcitySpinner: Spinner
    private lateinit var woredaSpinner:Spinner
    private lateinit var streetNameSpinner:Spinner



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_add_report, container, false)

        view.findViewById<View>(R.id.addreport_button).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_addreport_to_report_list)
            addReport()
        }
        return view
    }


    fun loadFields(){
        subcitySpinner = subcity_spinner
        woredaSpinner = woreda_spinner
        streetNameSpinner = woreda_spinner
        headerEditText = addreport_header_edittext
        textEditText = add_report_message
        categorySpinner = category_spinner
        addButton = addreport_button

        var subcity = subcitySpinner.selectedItem.toString()
        var woreda = woredaSpinner.selectedItem.toString()
        var streetName = streetNameSpinner.selectedItem.toString()
        var header = headerEditText.text
        var category = categorySpinner.selectedItem.toString()

        //TODO get the username
        //TODO get the email of the user by using the username


    }

    fun addReport(){
        loadFields()
        //TODO get the uuid of the report by adding it through the api
        //TODO using the uuid, create a Report object
        //TODO add the report object using viewModel


    }

    fun updateReport(){
        loadFields()
        //TODO Get the data of the report
        //TODO Check if the data exists in database
        //TODO Set the tables using the  data of the report
        //TODO Observe the change

    }

    fun deleteReport(){
        loadFields()
        //TODO get the uuid of the report by querying it through the api
        //TODO using the uuid, delete a Report object both on the api and room


    }

    fun loadReport(){
        loadFields()
        //TODO get reports  by using username from the api
        //TODO return the report
        //TODO observe the data change using viewmodel and livedata

    }


}
