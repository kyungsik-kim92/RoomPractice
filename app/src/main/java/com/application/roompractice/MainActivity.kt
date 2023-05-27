package com.application.roompractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.roompractice.db.Entity.NumberEntity
import com.application.roompractice.view.CustomAdapter
import com.application.roompractice.view.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()


    lateinit var numberArrayList: ArrayList<NumberEntity>

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

        val numberRV = findViewById<RecyclerView>(R.id.numberRV)


        // Read
        viewModel.read()
        viewModel.numberEntityList.observe(this) {
            Log.d("MAIN", it.toString())

            numberArrayList = it as ArrayList<NumberEntity>
            val customAdapter = CustomAdapter(numberArrayList)
            numberRV.adapter = customAdapter

            onClickEventHandling(customAdapter)
        }

        numberRV.layoutManager = LinearLayoutManager(this)


    }

    private fun onClickEventHandling(customAdapter: CustomAdapter) {

        // Update

        customAdapter.updateClick = object : CustomAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                viewModel.update(numberArrayList[position])
            }

        }


        // Delete
        customAdapter.deleteClick = object : CustomAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {

                Toast.makeText(
                    this@MainActivity,
                    numberArrayList[position].toString(),
                    Toast.LENGTH_LONG
                ).show()
                viewModel.delete(numberArrayList[position])
            }


        }
    }
}

