package org.isen.CIR3.Paper_News_GGH.data

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
