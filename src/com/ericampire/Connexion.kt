package com.ericampire

import java.sql.DriverManager
import java.sql.Connection
import java.sql.SQLException

object Connexion {
    private const val url = "jdbc:mysql://localhost/stock"
    private const val username = "root"
    private const val password = "root"

    private var connexion: Connection? = null


    fun getConnexion(): Connection? {
        try {
            Class.forName("com.mysql.jdbc.Driver")
            connexion = DriverManager.getConnection(url, username, password)
        } catch (e: ClassNotFoundException) {
            println(e.message)
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            return connexion
        }
    }
}