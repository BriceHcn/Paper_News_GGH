package org.isen.CIR3.Paper_News_GGH.searchEngine

import com.github.kittinunf.fuel.httpGet
import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.App
import org.isen.CIR3.Paper_News_GGH.data.NewsSearchData
import kotlin.system.exitProcess

class NewsSearchEngine(
        private val pays:String?,
        private val category:String?,
        private val keywords: String?) {

    companion object : Logging

    val newsResult:NewsSearchData?
        get() {
            return this.searchNewsWithSpecifiedSettings()
        }
    
    private fun searchNewsWithSpecifiedSettings(): NewsSearchData? {
        val(request,response,result)="https://newsapi.org/v2/top-headlines?apiKey=${App.cfg.apiKey}${getCountry()}${formatedCategory()}${formatedKeywords()}"
                .httpGet().responseObject(NewsSearchData.Deserializer())

        logger.info("Request sent - url : ${request.url}")
        logger.info("the response is : ${response.responseMessage}(code ${response.statusCode})")
        logger.info("${result.component1()?.articles?.size}(over ${result.component1()?.totalResults} total) result for : ${formatedCategory()}")

        //si limite API atteinte
        if(response.statusCode == 429){
            logger.info("Too much API Request Today ")
            exitProcess(0)
        }
        return result.component1()
    }

    //pour choisir une categorie ou pas
    private fun formatedCategory(): String {
        return if (category==null) "" else "&category=$category"
    }

    //pour choisir des mots clés ou pas
    private fun formatedKeywords():String{
        return if (keywords==null) "" else "&q=$keywords"
    }

    //pour choisir un pays ou prendre celui par defaut(sans rien on a des resultats en chinois,etc..)
    private fun getCountry():String{
        return if (pays==null) "&country=${App.cfg.defaultLanguage}" else "&country=$pays"
    }
}