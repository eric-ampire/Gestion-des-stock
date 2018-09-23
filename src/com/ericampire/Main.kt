package com.ericampire

import com.ericampire.modele.ArticleDOA
import java.io.Console

var choixMenu: Int? = null
val articleDOA = ArticleDOA()

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

    if (choixMenu != null) {
        verifierChoice()
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
            try {
                print("Donner le numero de l'article :")
                articleDOA.delete(readLine()!!.toInt())

            } catch (e: Exception) {

                clearTerminal()
                print("VALEUR INCORRECT !!! \n\n")
                afficherMenu()
            }

        }

        4 -> {

        }

        5 -> {
            clearTerminal()
            println("""N   Nom     Prix    Quantity""")

            articleDOA.getAllItem().forEach {

                val chaine = """${it.numero}     ${it.nom}    ${it.prix}     ${it.quantity}"""
                println(chaine)
            }
        }

        6 -> {
            clearTerminal()
            print("Au revoir !!!")
            System.exit(0)
        }
    }
}