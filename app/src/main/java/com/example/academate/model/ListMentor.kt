package com.example.academate.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.academate.R

data class ListMentor(@DrawableRes val imgProfil: Int, @StringRes val namaMentor: Int, @StringRes val matkulMentor: Int)

val dummyListMentor = listOf(
    Triple(R.drawable.arif, R.string.arif, R.string.jst),
    Triple(R.drawable.richo, R.string.richo, R.string.jst),
    Triple(R.drawable.aziz, R.string.aziz, R.string.jst)
).map { ListMentor(it.first, it.second, it.third) }