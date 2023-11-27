package com.example.academate.data.model

import com.example.academate.model.Matkul

data class MatkulModelResponse(
    val item: Matkul? = Matkul(),
    val key: String? = ""
)
