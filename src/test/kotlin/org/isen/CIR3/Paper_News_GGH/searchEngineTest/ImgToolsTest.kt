package org.isen.CIR3.Paper_News_GGH.searchEngineTest

import org.isen.CIR3.Paper_News_GGH.searchEngine.ImgTools
import org.junit.Test
import kotlin.test.assertEquals
import java.io.File

class ImgToolsTest {
    private val classUnderTest = ImgTools()
    @Test
    fun testDownloadedImageHasItsName() {
        assertEquals("image.png",classUnderTest.getArticleImg("https://place-hold.it/300x500/666/image.png"),"La methode renvoi le meme nom d'image que son nom")
    }

    @Test
    fun testDownloadedImageExist() {
        val file = File(System.getProperty("user.dir") + "/src/main/resources/photo/ArticleImg/" +classUnderTest.getArticleImg("https://place-hold.it/300x500/666/image.png"))
        var expectedResult = true
        var actualResult = false
        if (file.exists()){
            actualResult = true
        }
        assertEquals(expectedResult, actualResult)
    }

}

