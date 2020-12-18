package org.isen.CIR3.Paper_News_GGH.searchEngine

import com.github.kittinunf.fuel.httpGet
import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.data.NewsSearchData

class NewsSearchEngine(
        private val pays:String="fr",//TODO deplacer pays par defaut dans un fichier de config
        private val category:String,
        private val keywords: String?) {

    companion object : Logging

    //TODO a deplacer dans un fichier de config
    private val apiKey:String="c5362b90a1e54df5a3fc3f381ce21edc"

    val newsResult:NewsSearchData?
        get()=this.searchNewsWithSpecifiedSettings()

    private fun searchNewsWithSpecifiedSettings(): NewsSearchData? {
        val(request,response,result)="https://newsapi.org/v2/top-headlines?country=$pays&apiKey=$apiKey${formatedCategory()}${formatedKeywords()}"
                .httpGet().responseObject(NewsSearchData.Deserializer())

        logger.info("Requete effectué - url : ${request.url}")
        logger.info("La requete est : ${response.responseMessage}(code ${response.statusCode})")

        return result.component1()
    }

    private fun formatedCategory(): String {
        return if (category==null) "" else "&category=$category"
    }

    private fun formatedKeywords():String{
        return if (keywords==null) "" else "&q=$keywords"
    }
}