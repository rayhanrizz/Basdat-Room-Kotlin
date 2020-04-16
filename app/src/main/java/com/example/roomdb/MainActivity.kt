package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val db = MhsDatabase(this)

        btInsert.setOnClickListener{
            val mhsnama = nama.text
            val mhsalamat = alamat.text

            GlobalScope.launch {
                db.mhsDao().insertAll(MhsEntity(0,mhsnama.toString(),mhsalamat.toString()))
                val data = db.mhsDao().getAll()

                data?.forEach {
                    Log.d("Database", it.toString())
                }
            }
            nama.setText("")
            alamat.setText("")
        }
    }
}
