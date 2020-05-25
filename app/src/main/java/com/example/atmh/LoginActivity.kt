package com.example.atmh

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        getSharedPreferences("atmh", Context.MODE_PRIVATE)
            .getString("userid","").run{
                userid_input.setText(this)
            }

        getSharedPreferences("atmh", Context.MODE_PRIVATE)
            .getString("passwd","").run{
                passwd_input.setText(this)
            }

    }

    //接收使用者輸入資訊
    fun login(v: View) {
        val uid = userid_input.text.toString()
        val pw = passwd_input.text.toString()
        if (uid == "ruby" && pw == "1234") {
            Toast.makeText(this, "登入成功，歡迎光臨~", Toast.LENGTH_LONG).show()
            intent.putExtra("EXTRA_USERID", uid)  //把帳號/密碼放入intent物件中
            intent.putExtra("EXTRA_PASSWD", pw)
            setResult(Activity.RESULT_OK,intent)        //呼叫Activity的setResult方法，將這一個功能畫面的結果為RESULT_OK
            //            val intent = Intent(this,MainActivity::class.java)
            Log.d("RESULT_if_pw",pw)
            getSharedPreferences("atmh", Context.MODE_PRIVATE)
                .edit()
                .putString("userid",uid)
                .putString("passwd",pw)
                .apply()
                finish()                                    //結束這一頁，然後離開,mainactivity就會跳出來
        } else {
//            Toast.makeText(this, "失敗了!再試試看呦~", Toast.LENGTH_LONG).show()
            Log.d("RESULT_else_uid",uid)
            Log.d("RESULT_else_pw",pw)
            AlertDialog.Builder(this)
                .setTitle("登入失敗")
                .setMessage("別氣餒，再試試看呦~")
                .setPositiveButton("OK",null)
                .show()
        }
    }


    fun clear (v:View){
        getSharedPreferences("atmh", Context.MODE_PRIVATE)
            .edit()
            .clear()
            .apply()
            userid_input.setText("")
            passwd_input.setText("")

    }
}


