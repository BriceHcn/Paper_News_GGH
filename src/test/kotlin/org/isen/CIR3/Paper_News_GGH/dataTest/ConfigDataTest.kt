package org.isen.CIR3.Paper_News_GGH.dataTest

import org.isen.CIR3.Paper_News_GGH.data.ConfigData
import org.junit.Test
import kotlin.test.assertEquals

class ConfigDataTest {
private val listCountry=ArrayList<String>()
private val listCat=ArrayList<String>()
private val classUnderTest:ConfigData= ConfigData("3","fr",listCountry,listCat)

    @Test
    fun testArticleDataAPiKeyNotModified() {
        assertEquals("3",classUnderTest.apiKey,"data should have an apikey")
    }

    @Test
    fun testArticleDataDefaultLanguageNotModified() {
        assertEquals("fr",classUnderTest.defaultLanguage,"data should have an default language")
    }
}