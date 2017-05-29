package com.emedinaa.contactsapp.ui.adapters

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.emedinaa.komath.R
import com.emedinaa.komath.model.Subject
import kotlinx.android.synthetic.main.row_subject.view.*

/**
 * Created by emedinaa on 06/04/17.
 */
class SubjectAdapter (val subjects:List<Subject>,val context:Context): RecyclerView.Adapter<SubjectAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.textViewName
        val llyContainer: View = view.llyContainer
    }

    /*
        int height = parent.getMeasuredHeight() / 4;
        itemView.setMinimumHeight(height);
        return new ItemViewHolder(itemView);
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val height= parent.measuredHeight/2
        val view:View= layoutInflater.inflate(R.layout.row_subject, parent, false)
        view.minimumHeight=height
        return ViewHolder(view) //To change body of created functions use File | Settings | File Templates.
    }

    /*
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val name:String = pokemonList[position].name
        holder!!.tviName.text = name //To change body of created functions use File | Settings | File Templates.
    }*/

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contactFullName: String = subjects[position].name!!
        val color:Int= Color.parseColor(subjects[position].color!!)

        holder.textViewName.text = contactFullName //To change body of created functions use File | Settings | File Templates.
        holder.llyContainer.setBackgroundColor(color)
        //holder.iviPhoto.setImageBitmap(getBitmapFromAssets(photo))
    }

    override fun getItemCount(): Int {
        return subjects.size //To change body of created functions use File | Settings | File Templates.
    }

}