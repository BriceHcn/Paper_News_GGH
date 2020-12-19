package org.isen.CIR3.Paper_News_GGH.searchEngine

import com.github.kittinunf.fuel.httpGet
import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.data.ConfigData
import org.isen.CIR3.Paper_News_GGH.data.NewsSearchData

class NewsSearchEngine(
        private val pays:String?,
        private val category:String?,
        private val keywords: String?) {

    companion object : Logging

    val newsResult:NewsSearchData?
        get() {
            return this.searchNewsWithSpecifiedSettings()
        }
    private val cfg:ConfigData=ReadConfigFile().cfg


    private fun searchNewsWithSpecifiedSettings(): NewsSearchData? {
        val(request,response,result)="https://newsapi.org/v2/top-headlines?apiKey=${cfg?.apiKey}${getCountry()}${formatedCategory()}${formatedKeywords()}"
                .httpGet().responseObject(NewsSearchData.Deserializer())

        logger.info("Request sent - url : ${request.url}")
        logger.info("the response is : ${response.responseMessage}(code ${response.statusCode})")

        return result.component1()
    }

    private fun formatedCategory(): String {
        return if (category==null) "" else "&category=$category"
    }

    private fun formatedKeywords():String{
        return if (keywords==null) "" else "&q=$keywords"
    }

    private fun getCountry():String{
        return if (pays==null) "&country=${cfg?.defaultLanguage}" else "&country=$pays"
    }
}