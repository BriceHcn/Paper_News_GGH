package org.isen.CIR3.Paper_News_GGH.data

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import java.util.*

data class ArticleData(
    val source:SourceData?,
    val author:String?,
    val title:String?,
    val description:String?,
    val url:String?,
    val urlToImage: String?,
    val publishedAt: Date?,
    val content:String?){


    /*
    override fun toString():String{
        return "{\n\"articles\":\n" +
                "[\n" +
                "{\n" +
                "\"source\": {\"id\":\"${source?.id}\",\"name\":\"${source?.name}\"},\n" +
                "\"author\":\"$author\",\n" +
                "\"title\":\"$title\",\n" +
                "\"description\":\"$description.\",\n" +
                "\"url\":\"$url\",\n" +
                "\"urlToImage\":\"$urlToImage\",\n" +
                "\"publishedAt\":\"$publishedAt\",\n" +
                "\"content\": \"$content\"\n" +
                "}\n]\n}"
    }
     */
}
