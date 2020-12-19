package org.isen.CIR3.Paper_News_GGH.data

data class ConfigData(
        val apiKey:String,
        val defaultLanguage:String,
        val categoryList:ArrayList<String>,
        val countryList:ArrayList<String>
) {

}