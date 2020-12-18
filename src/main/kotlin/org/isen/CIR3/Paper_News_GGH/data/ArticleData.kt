package org.isen.CIR3.Paper_News_GGH.data

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class ArticleData(
        val source:SourceData,
        val author:String,
        val title:String,
        val description:String,
        val url:String,
        val urlToImage: String,
        val publishedAt:String,
        val content:String) {



}
