package com.jay.wackiestapp.contentProvider

import android.content.ContentResolver
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jay.wackiestapp.R


class ContentProviderActivity : AppCompatActivity() {
    private val contactsList= mutableListOf<Contact>()
    private lateinit var contactAdapter: ContactAdapter

    data class Contact( val name: String?, val phoneNumber: String?)

    companion object{
        private const val PERMISSION_REQUEST_READ_CONTACTS=100
    }

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_content_provider)

        contactAdapter=ContactAdapter(contactsList)
        recyclerView=findViewById(R.id.rvContacts)
        recyclerView.layoutManager=LinearLayoutManager(this)

        if(checkContactPermission()){
            fetchContacts()
        }else{
            requestContactPermission()
        }
    }//====================onCreate Ends=======================

    private fun checkContactPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_CONTACTS)==
                PackageManager.PERMISSION_GRANTED
    }
    private fun requestContactPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS),
            PERMISSION_REQUEST_READ_CONTACTS)
    }


    private fun fetchContacts()
       {

            val contactResolver: ContentResolver =contentResolver

            val cursor:Cursor?=contactResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                null
            )

            cursor?.let{

                val nameColumnIndex=it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                val numberColumnIndex=it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                while (it.moveToNext()){

                    val name = if(nameColumnIndex!=-1)it.getString(nameColumnIndex) else ""
                    val phoneNumber =if(numberColumnIndex!=-1)it.getString(numberColumnIndex) else ""

                    val contact=Contact(name, phoneNumber)

                    contactsList.add(contact)
                }
                it.close()
            }

           val adapter=ContactAdapter(contactsList)
           recyclerView.adapter=adapter

        }
}

