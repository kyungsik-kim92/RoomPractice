package com.application.roompractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import com.application.roompractice.db.Entity.NumberEntity
import com.application.roompractice.view.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Create
        val createBtn = findViewById<Button>(R.id.create)
        createBtn.setOnClickListener {

            val ranNumber = (0..100).random().toString()
            val numberEntity = NumberEntity(0, ranNumber)
            viewModel.create(numberEntity)
        }



        // Read
        viewModel.read()
        viewModel.numberEntityList.observe(this,{
            Log.d("MAIN",it.toString())
        })


    }
}