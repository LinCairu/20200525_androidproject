package com.example.atmh

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_age.*

class AgeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age)
    }

    fun next(v:View){
        val age = age_input.text.toString()
        Toast.makeText(this,"我已經 $age 歲了!",Toast.LENGTH_LONG).show()
        intent.putExtra("AGE_EXTRA",age)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}
