package com.example.academate.data.repository

import com.example.academate.data.model.MatkulModelResponse
import com.example.academate.util.Resource
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.callbackFlow

class MatkulRepository {
    private val db: DatabaseReference =
        FirebaseDatabase
            .getInstance("https://academate-10006-default-rtdb.firebaseio.com/")
            .reference
            .child("MataKuliah")
}

fun getMatkulById(nama: String){
    callbackFlow<Resource<MatkulModelResponse>> {
//        trySend(Resource.Loading))

    }
}