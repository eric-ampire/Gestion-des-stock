package com.ericampire

import com.ericampire.modele.ArticleDOA
import java.io.Console

var choixMenu: Int? = null

fun main(args: Array<String>) {
    ArticleDOA().getAllItem().forEach { println(it)}
    //afficherMenu()
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

fun verifierChoice() {
    when(choixMenu) {

        1 -> {
            print("Donner le numero de reference : ")
        }

        2 -> {

        }

        3 -> {

        }

        4 -> {

        }

        5 -> {

        }

        6 -> {
            clearTerminal()
            print("Au revoir !!!")
            System.exit(0)
        }
    }
}