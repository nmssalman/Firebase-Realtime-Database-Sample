package com.nmssalman.firebasesamples.realtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nmssalman.firebasesamples.*

class RealtimeActivity : AppCompatActivity() {
    lateinit var viewModel: FirebaseRealtimeViewModel

    lateinit var btnCreate: Button
    lateinit var projectID: EditText
    lateinit var projectName: EditText
    lateinit var projectDescription: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realtime)
        viewModel = ViewModelProvider(this).get(FirebaseRealtimeViewModel::class.java)

        btnCreate = findViewById(R.id.btnCreate)
        projectID = findViewById(R.id.textProjectID)
        projectName = findViewById(R.id.textProjectName)
        projectDescription = findViewById(R.id.textProjectDescription)
        Observers()
        
        btnCreate.setOnClickListener { 
            if(projectID.text.isNullOrEmpty() || projectName.text.isNullOrEmpty() || projectDescription.text.isNullOrEmpty())
                Toast.makeText(this, "Please Provide All Information", Toast.LENGTH_SHORT).show()
            else
                viewModel.addData(projectID.text.toString().toInt(), projectName.text.toString(), projectDescription.text.toString())

        }

    }

    private fun Observers(){
        viewModel.onSuccess.observe(this, Observer {
            Toast.makeText(this, "Project Created: ${it.name}", Toast.LENGTH_SHORT).show()
        })

        viewModel.onFailure.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}