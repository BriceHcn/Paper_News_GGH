package org.isen.CIR3.Paper_News_GGH.dataTest

import org.isen.CIR3.Paper_News_GGH.data.ArticleData
import org.isen.CIR3.Paper_News_GGH.data.NewsSearchData
import org.isen.CIR3.Paper_News_GGH.data.SourceData
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

class NewsSearchDataTest {
    private val article = ArticleData(SourceData("10","name"),"author","title","description","url","urlToImage", Date(1,1,1),"content")
    private val listart = listOf(article)

    private val classUnderTest: NewsSearchData = NewsSearchData("2",3, listart)
    @Test
    fun testArticleDataStatusNotModified() {
        assertEquals("2",classUnderTest.status,"data should have an id")
    }
    @Test
    fun testArticleDataTotalResultsNotModified() {
        assertEquals(3,classUnderTest.totalResults,"data should have an total result")
    }
}