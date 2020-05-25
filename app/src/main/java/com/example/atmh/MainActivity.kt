package com.example.atmh

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var login = false
    var counter = 0
    var REQUEST_LOGIN = 1
    var REQUEST_NICKNAME = 2
    var REQUEST_SEX = 3
    var REQUEST_AGE = 4



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        counter = getSharedPreferences("atmh", Context.MODE_PRIVATE)
            .getInt("counter", 0)

        Log.d("RESULT_FIRST","$counter")


        if (!login) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivityForResult(intent, REQUEST_LOGIN)
        }

        if (counter == 1 ){
        val intent = Intent(this,LoginActivity::class.java)
            startActivityForResult(intent,REQUEST_LOGIN)
    }else if (counter == 2){
            val intent = Intent(this,NickNameActivity::class.java)
            startActivityForResult(intent,REQUEST_NICKNAME)
        }else if (counter == 3){
            val intent = Intent(this,SexActivity::class.java)
            startActivityForResult(intent,REQUEST_SEX)
        }else if (counter == 4){
            val intent = Intent(this,AgeActivity::class.java)
            startActivityForResult(intent,REQUEST_AGE)
        }
    }




    override fun onActivityResult(requestCode: Int,resultCode: Int,data: Intent?) {   //他怎麼知道誰要傳進來這裡requestCode???
        super.onActivityResult(requestCode, resultCode, data)



        if (requestCode == REQUEST_LOGIN) {
            if (resultCode == Activity.RESULT_OK) {
                //執行
                counter = 1
                var uid = data?.getStringExtra("EXTRA_USERID")
                val pw = data?.getStringExtra("EXTRA_PASSWD")
                userid_result.text = uid.toString()
                Log.d("RESULT_uidpw", "$uid/$pw")

                val intent = Intent(this, NickNameActivity::class.java)
                getSharedPreferences("atmh", Context.MODE_PRIVATE)
                    .edit()
                    .putInt("counter", counter)
                    .apply()
                Log.d("RESULT_page", "$counter")

//                val counter = getSharedPreferences("atmh", Context.MODE_PRIVATE)  //先確認在這邊是不是可以讀取到...
//                    .getInt("counter", 0)
//                Log.d("RESULT_AAAAAAAAA","$counter")

                startActivityForResult(intent, REQUEST_NICKNAME)
            } else {
                finish()    //結束
            }
        } else if (requestCode == REQUEST_NICKNAME) {
            if (resultCode == Activity.RESULT_OK) {
                counter = 2
                val nickname =
                    data?.getStringExtra("NICKNAME_EXTRA")       //data?.  老師是用intent,但是我的會壞掉  而且一定要用.?
                nickname_result.text = nickname.toString()
                Log.d("RESULT_nickname", nickname)

                val intent = Intent(this, SexActivity::class.java)
                getSharedPreferences("atmh", Context.MODE_PRIVATE)
                    .edit()
                    .putInt("counter", counter)
                    .apply()
                Log.d("RESULT_page", "$counter")
                startActivityForResult(intent, REQUEST_SEX)
            } else {
                finish()
            }
        } else if (requestCode == REQUEST_SEX) {
            if (resultCode == Activity.RESULT_OK) {
                counter = 3
                val sex = data?.getStringExtra("SEX_EXTRA")
                sex_result.text = sex.toString()
                Log.d("RESULT_sex", sex)

                val intent = Intent(this, AgeActivity::class.java)
                getSharedPreferences("atmh", Context.MODE_PRIVATE)
                    .edit()
                    .putInt("counter", counter)
                    .apply()
                Log.d("RESULT_page", "$counter")
                startActivityForResult(intent, REQUEST_AGE)
            } else {
                finish()
            }
        } else if (requestCode == REQUEST_AGE) {
            if (resultCode == Activity.RESULT_OK) {
                counter = 4
                val age = data?.getStringExtra("AGE_EXTRA")
                Log.d("RESULT_age", age)

                age_result.text = age.toString()
                getSharedPreferences("atmh", Context.MODE_PRIVATE)
                    .edit()
                    .putInt("counter", counter)
                    .apply()
                Log.d("RESULT_page", "$counter")

            } else {
                finish()
            }
        }

//        getSharedPreferences("atmh", Context.MODE_PRIVATE)
//            .edit()
//            .putInt("counter",0)
//            .apply()
//
//        Log.d("RESULT_CCC", "$counter")

    }


    fun login_go(v: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivityForResult(intent, REQUEST_LOGIN)
    }

    fun nickname_go(v: View) {
        val intent = Intent(this, NickNameActivity::class.java)
        startActivityForResult(intent, REQUEST_NICKNAME)
    }

    fun sex_go(v: View) {
        val intent = Intent(this, SexActivity::class.java)
        startActivityForResult(intent, REQUEST_SEX)
    }

    fun age_go(v: View) {
        val intent = Intent(this, AgeActivity::class.java)
        startActivityForResult(intent, REQUEST_AGE)
    }

}
