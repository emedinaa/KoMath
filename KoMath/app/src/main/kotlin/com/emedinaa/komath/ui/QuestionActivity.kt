package com.emedinaa.komath.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.emedinaa.komath.R
import com.emedinaa.komath.model.Question
import com.emedinaa.komath.model.interactor.QuestionInteractor
import com.emedinaa.komath.presenter.QuestionContract
import com.emedinaa.komath.presenter.QuestionPresenter
import com.emedinaa.komath.utils.log
import com.google.android.flexbox.FlexboxLayout
import kotlinx.android.synthetic.main.layout_loading.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(),QuestionContract.QuestionView,QuestionContract.AnswerView {

    private val ACTION_RATE:String= "Calificar"
    private var questionPresenter:QuestionPresenter?=null
    private var questions:List<Question>?=null
    private var options:List<String>?=null
    private var count=0

    override fun rateQuestion(question: Question) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun validatedAnswer(obj: Any) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        vLoading.visibility= View.VISIBLE
    }

    override fun hideLoading() {
        vLoading.visibility= View.GONE
    }

    override fun empty() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun receivedQuestions(questionList: List<Question>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        questions=questionList
        renderQuestion(questions!![count])
    }

    override fun showMessage(message: String) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun clearView(){
        textViewTitle.text=""
        textViewQuestion.text=""
        flexBoxOptions.removeAllViews()
        buttonRate.text= ACTION_RATE
    }

    fun renderOptions(mOptions:String){
        options= mOptions.split(",")
        log { "options $options" }

        options!!.forEachIndexed { index, optionValue ->
            flexBoxOptions.addView(buildItem(optionValue,index))
        }
    }

    /*
       LayoutInflater layoutInflater= LayoutInflater.from(this);
        View item= layoutInflater.inflate(R.layout.layout_option,null,false);
        TextView textView= (TextView) item.findViewById(R.id.textViewOption);
        textView.setText(option);
        return item;
        LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,0,0,0);
     */
    fun buildItem(option:String,position:Int):View{
        var layoutInflater:LayoutInflater= LayoutInflater.from(this)
        var llayView:View=layoutInflater.inflate(R.layout.layout_option,null,false)
        var itemTextView:TextView= llayView.findViewById(R.id.textViewOption) as TextView

        itemTextView.text= option
        llayView.tag=position

        var layoutParams:FlexboxLayout.LayoutParams = FlexboxLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,  ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(16,16,16,16)
        llayView.layoutParams= layoutParams

        return llayView
    }

    override fun renderQuestion(question: Question) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        clearView()
        textViewTitle.text= question.title
        textViewQuestion.text= question.format
        renderOptions(question.options)
    }

    override fun nextQuestion() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        count++
        if(count<questions!!.size){
            renderQuestion(questions!![count])
        }else{
            gotoLevelCompleted()
        }
    }

    fun gotoLevelCompleted(){
        val intent= Intent(this,LevelCompletedActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun ui(){
        flexBoxOptions.flexDirection= FlexboxLayout.FLEX_DIRECTION_ROW
        flexBoxOptions.flexWrap = FlexboxLayout.FLEX_WRAP_WRAP
        flexBoxOptions.justifyContent= FlexboxLayout.JUSTIFY_CONTENT_CENTER

        //events
        buttonRate.setOnClickListener {
            if(validateForm()){
                nextQuestion()
            }
        }
    }

    fun validateForm():Boolean{
        return true;
    }
    fun getQuestions()
    {
        questionPresenter!!.getQuestions()
    }

    fun setPresenters(){
        questionPresenter= QuestionPresenter(this, QuestionInteractor())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        setPresenters()
        ui()

        getQuestions()
    }
}
