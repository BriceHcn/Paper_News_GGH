package org.isen.CIR3.Paper_News_GGH.searchEngineTest

import org.isen.CIR3.Paper_News_GGH.data.ConfigData
import org.isen.CIR3.Paper_News_GGH.searchEngine.ReadConfigFile
import org.junit.Test
import kotlin.test.assertNotNull

class ReadConfigFileTest {
    private val classUnderTest: ConfigData = ReadConfigFile().cfg

    @Test fun testArticleDataHasApiKey() {
        assertNotNull(classUnderTest.apiKey,"data should have an apikey")
    }
    @Test fun testArticleDataHasCategoryList() {
        assertNotNull(classUnderTest.categoryList,"data should have an cat list")
    }
    @Test fun testArticleDataHasCountryList() {
        assertNotNull(classUnderTest.countryList,"data should have an countryList")
    }
    @Test fun testArticleDataHasDefaultLanguage() {
        assertNotNull(classUnderTest.defaultLanguage,"data should have an defaultLanguage")
    }
}