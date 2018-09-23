package com.ericampire.modele

fun main(args: Array<String>) {
    afficherMenu()
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
}