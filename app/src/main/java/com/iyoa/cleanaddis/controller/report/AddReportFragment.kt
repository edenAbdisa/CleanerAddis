package com.iyoa.cleanaddis.controller.report


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation

import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.data.common.Address
import com.iyoa.cleanaddis.data.common.AddressData
import com.iyoa.cleanaddis.data.common.Media
import com.iyoa.cleanaddis.data.common.MediaData
import com.iyoa.cleanaddis.data.report.Report
import com.iyoa.cleanaddis.data.report.ReportData
import com.iyoa.cleanaddis.data.user.User
import com.iyoa.cleanaddis.retrofitDelilah.*
import com.iyoa.cleanaddis.retrofitEden.MediaService
import com.iyoa.cleanaddis.retrofitEden.MediaServiceImpl
import kotlinx.android.synthetic.main.fragment_add_report.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.lang.Exception
import java.time.Instant
import java.util.*

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
    private lateinit var  reportService: ReportService
    private lateinit var addressService: AddressService
    private lateinit var mediaService:MediaService
    private lateinit var impactRatingBar: RatingBar
    private lateinit var attachImageView: ImageView
    private lateinit var mCapturedImageURI:Uri

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_add_report, container, false)

        view.findViewById<View>(R.id.addreport_button).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_addreport_to_report_list)
            val user = getUserInfo()
            if(user!="") {
                addReport(user)
            }
        }
        view.findViewById<View>(R.id.attach_image_view).setOnClickListener{

            dispatchFileChooser()
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
        impactRatingBar = impact_rating_bar
        attachImageView = attach_image_view


        var subcity = subcitySpinner.selectedItem.toString()
        var woreda = woredaSpinner.selectedItem.toString()
        var streetName = streetNameSpinner.selectedItem.toString()
        var header = headerEditText.text
        var category = categorySpinner.selectedItem.toString()
        var impact = impactRatingBar.numStars

        //TODO get the username
        //TODO get the email of the user by using the username


    }

    fun dispatchFileChooser(){
        try{
            var fileStorageDir:File =  File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES),"Pictures"
            )
             mCapturedImageURI = Uri.fromFile(fileStorageDir)
             var captureIntent:Intent =  Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            captureIntent.putExtra(MediaStore.EXTRA_OUTPUT,mCapturedImageURI)
        }
        catch(ex:Exception){

        }

    }

    fun getUserInfo():String?{
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val username = sharedPref?.getString("username","")
        return username
    }
    fun addMedia(): Call<com.iyoa.cleanaddis.entity.posting.Media> {
        mediaService = MediaServiceImpl().getMediaServiceImpl()
        var media = MediaData(mCapturedImageURI.toString(),"IMAGE","REPORT",
            textEditText.text.toString())
        var savedMedia = mediaService.insertMedia(media)
        return savedMedia
    }

    fun addAddress(): Call<AddressData> {
        addressService = AddressServiceImpl().getAddressServiceImpl()
        val addressData = AddressData(subcitySpinner.selectedItem.toString(),
            woredaSpinner.selectedItem.toString(),woredaSpinner.selectedItem.toString())
       var savedAddress = addressService.addAddress(addressData)
        return savedAddress
    }

    fun addReport(user:String?){
        loadFields()
        reportService = ReportServiceImpl().getReportServiceImpl()
        var media:Media = addMedia() as Media
        var address:Address = addAddress() as Address

        val report = ReportData(user.toString(),textEditText.text.toString(),
            media.uuid,"WASTE", Date.from(Instant.now()),address.uuid,
            impactRatingBar.numStars)
        val call: Call<Report> = reportService.addReport(report)

        call.enqueue(object: Callback<Report> {


            override fun onResponse(call: Call<Report>, response: Response<Report>) {

                var response = response.body() as Report
            }

            override fun onFailure(call: Call<Report>, t:Throwable){
                Log.wtf("ArticleLine85",t.message)
            }

        })
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
