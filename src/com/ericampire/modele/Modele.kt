package com.ericampire.modele

data class Article(
    val numero: Int,
    val nom: String,
    val prix: Double,
    val quantity: Int
)

interface DOA<T> {
    fun insert(item: T)
    fun delete(id: Int)
    fun update(item: T)
    fun getItem(id: Int): T
    fun getAllItem(): List<T>
}