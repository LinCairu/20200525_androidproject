package com.example.atmh

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sex.*

class SexActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sex)
    }

    fun next (v:View){
        val sex = sex_input.text.toString()
        Toast.makeText(this,"I'm $sex",Toast.LENGTH_LONG).show()
        intent.putExtra("SEX_EXTRA",sex)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}
