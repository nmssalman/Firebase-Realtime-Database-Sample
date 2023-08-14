package com.nmssalman.firebasesamples.realtime

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class FirebaseRealtimeViewModel: ViewModel() {
    private val firebaseRealtimeTransaction: FirebaseRealtimeTransaction
    val onSuccess: LiveData<FirebaseRealtimeTransaction.Project>
    val onFailure: LiveData<String>
    init {
        firebaseRealtimeTransaction = FirebaseRealtimeTransaction()
        onSuccess = firebaseRealtimeTransaction.onSuccess
        onFailure = firebaseRealtimeTransaction.onFailure
    }

    fun addData(id: Int, name: String, description: String)
    {
        firebaseRealtimeTransaction.addProjectDetails(id, name, description)
    }
}