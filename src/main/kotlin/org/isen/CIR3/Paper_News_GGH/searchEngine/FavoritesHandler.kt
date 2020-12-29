package org.isen.CIR3.Paper_News_GGH.searchEngine

import com.google.gson.Gson

import org.isen.CIR3.Paper_News_GGH.data.ArticleData
import java.io.File
import java.io.InputStream

class FavoritesHandler {

    fun getAllFavoritesFromFile(): List<ArticleData>? {
        val inputStream: InputStream = File(System.getProperty("user.dir") + "/src/main/resources/favorite.json").inputStream()
        val inputString = inputStream.bufferedReader().use { it.readText() }
         //println(inputString)

        return null
    }

    fun addFavoriteToFile(article: ArticleData): Int {
        File(System.getProperty("user.dir") + "/src/main/resources/favorite.json").printWriter().use { out -> out.println(article.toString()) }
        return 1
    }

    fun deleteFavoriteFromFile(article: ArticleData):Int{

        return 1
    }


}