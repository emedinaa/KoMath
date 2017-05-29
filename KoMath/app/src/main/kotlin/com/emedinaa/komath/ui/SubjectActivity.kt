package com.emedinaa.komath.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.emedinaa.contactsapp.ui.adapters.SubjectAdapter
import com.emedinaa.contactsapp.ui.listener.RecyclerClickListener
import com.emedinaa.contactsapp.ui.listener.RecyclerTouchListener
import com.emedinaa.komath.R
import com.emedinaa.komath.model.Subject
import com.emedinaa.komath.model.interactor.SubjectInteractor
import com.emedinaa.komath.presenter.SubjectContract
import com.emedinaa.komath.presenter.SubjectPresenter
import kotlinx.android.synthetic.main.activity_subject.*
import kotlinx.android.synthetic.main.layout_loading.*

class SubjectActivity : AppCompatActivity(),SubjectContract.SubjectView {

    private var subjectPresenter:SubjectPresenter?=null
    private var subjectAdapter:SubjectAdapter?=null

    override fun showLoading() {
        vLoading.visibility=View.VISIBLE
    }

    override fun hideLoading() {
        vLoading.visibility=View.GONE
    }

    override fun empty() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun renderSubjects(subjects: List<Subject>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        subjectAdapter= SubjectAdapter(subjects,this)
        rviSubject.adapter=subjectAdapter
    }

    override fun showMessage(message: String) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    fun goToQuestions(){
        val intent= Intent(this,QuestionActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun getSubjects()
    {
        subjectPresenter!!.getSubjects()
    }

    fun setPresenters(){
        subjectPresenter= SubjectPresenter(this,SubjectInteractor())
    }

    fun ui() {
        //val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        var gLayoutManager:RecyclerView.LayoutManager= GridLayoutManager(this,2)
        rviSubject.layoutManager = gLayoutManager

        rviSubject.addOnItemTouchListener(RecyclerTouchListener(
        this,rviSubject,
        object: RecyclerClickListener {
            override fun onClick(view: View, position: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                if(subjectAdapter!=null){
                    val subject:Subject= subjectAdapter!!.subjects.get(position)
                    goToQuestions()
                }
            }

            override fun onLongClick(view: View, position: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)
        ui()
        setPresenters()
        getSubjects()
    }
}
