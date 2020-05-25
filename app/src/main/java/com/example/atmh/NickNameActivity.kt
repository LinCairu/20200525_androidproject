package com.example.atmh

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_nick_name.*

class NickNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nick_name)
    }

    fun next(v: View) {
        val nickname = nickname_input.text.toString()
        Toast.makeText(this,"我是$nickname",Toast.LENGTH_LONG).show()
        intent.putExtra("NICKNAME_EXTRA", nickname)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }

}
