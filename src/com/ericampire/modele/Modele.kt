package com.ericampire.modele

import com.ericampire.Connexion

data class Article(
    val numero: Int,
    val nom: String,
    val prix: Double,
    val quantity: Int
)