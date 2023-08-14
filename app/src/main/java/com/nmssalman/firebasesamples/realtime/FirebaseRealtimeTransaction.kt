package com.nmssalman.firebasesamples.realtime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseRealtimeTransaction {
    private var database: DatabaseReference

    val _onSuccess = MutableLiveData<Project>()
    val onSuccess: LiveData<Project>
        get() = _onSuccess

    val _onFailure = MutableLiveData<String>()
    val onFailure: LiveData<String>
        get() = _onFailure


    init {
        database = Firebase.database.reference
    }

    fun addProjectDetails(id: Int, name: String, description: String)
    {
        val project = Project(id, name, description)
        database.child("Projects").child(id.toString()).setValue(project)
            .addOnSuccessListener {
                _onSuccess.postValue(project)
            }
            .addOnFailureListener {
                _onFailure.postValue(it.message)
            }
    }

    data class Project(val id: Int, val name: String, val description: String)
}
