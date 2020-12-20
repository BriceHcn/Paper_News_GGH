package org.isen.CIR3.Paper_News_GGH.data

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class NewsSearchData(
        val status:String,
        val totalResults:Int,
        val articles:List<ArticleData>) {
    class Deserializer : ResponseDeserializable<NewsSearchData> {
        override fun deserialize(content: String): NewsSearchData {
            return Gson().fromJson(content,NewsSearchData::class.java)
        }
    }
}