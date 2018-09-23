package com.ericampire.modele

import java.io.Console

var choixMenu: Int? = null

fun main(args: Array<String>) {
    afficherMenu()
}

fun clearTerminal() {
    Runtime.getRuntime().exec("clear")
}

fun afficherMenu() {
    val menu = """
        1 - Rechercher un article
        2 - Ajouter un article
        3 - Supprimer un article
        4 - Modifier un article
        5 - Afficher tout les articles
        6 - Quit
        >
    """.trimIndent()

    print(menu)

    try {
        choixMenu = readLine()!!.toInt()
    } catch (e: Exception) {

        clearTerminal()
        print("VALEUR INCORRECT !!! \n\n")
        print(menu)
    }
}