package com.ericampire.modele

import com.ericampire.Connexion

class ArticleDOA : DOA<Article> {
    private val connexion = Connexion.getConnexion()

    override fun insert(item: Article) {
        val preparedStatement = connexion?.prepareStatement("INSERT INTO article values(?, ?, ?, ?)")

        with(preparedStatement!!) {
            setInt(1, item.numero)
            setDouble(2, item.prix)
            setInt(3, item.quantity)
            setString(4, item.nom)
        }

        preparedStatement.executeUpdate()
    }

    override fun delete(id: Int) {
        val preparedStatement = connexion?.prepareStatement("DELETE FROM article WHERE numero = ?")

        with(preparedStatement!!) {
            setInt(1, id)
        }

        preparedStatement.execute()
    }

    override fun update(item: Article) {

        val preparedStatement = connexion?.prepareStatement(
                "UPDATE `article` SET numero` = ?, prix = ?, `quantity` = ?, `nom` = ? WHERE article.numero = ?")

        with(preparedStatement!!) {
            setInt(1, item.numero)
            setDouble(2, item.prix)
            setInt(3, item.quantity)
            setString(4, item.nom)
            setInt(5, item.numero)
        }

        preparedStatement.execute()
    }

    override fun getItem(id: Int): Article? {
        val preparedStatement = connexion?.prepareStatement("SELECT * FROM article WHERE numero = ?")
        preparedStatement?.setInt(1, id)

        val resultSet = preparedStatement?.executeQuery()

        if (resultSet!!.next()) {

            return Article(
                    resultSet.getInt("numero"),
                    resultSet.getString("nom"),
                    resultSet.getDouble("prix"),
                    resultSet.getInt("quantity")
            )
        }

        return null
    }

    override fun getAllItem(): List<Article> {
        val preparedStatement = connexion?.prepareStatement("SELECT * FROM article")
        val resultSet = preparedStatement?.executeQuery()

        val articles = arrayListOf<Article>()

        while (resultSet!!.next()) {
            val article = Article(
                    resultSet.getInt("numero"),
                    resultSet.getString("nom"),
                    resultSet.getDouble("prix"),
                    resultSet.getInt("quantity")
            )

            articles += article
        }

        return articles.toList()
    }
}

interface DOA<T> {
    fun insert(item: T)
    fun delete(id: Int)
    fun update(item: T)
    fun getItem(id: Int): Article?
    fun getAllItem(): List<T>
}