package com.jay.wackiestapp.contentProvider


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jay.wackiestapp.R

class ContactAdapter (private val contacts:List<ContentProviderActivity.Contact>):RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){
    class ContactViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val contactNameTextView: TextView =itemView.findViewById(R.id.name)
        val contactNumberTextView: TextView =itemView.findViewById(R.id.number)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.activity_content_provider_item,parent,false)
        return ContactViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return contacts.size

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact=contacts[position]

        holder.contactNameTextView.text=contact.name
        holder.contactNumberTextView.text=contact.phoneNumber
    }
}