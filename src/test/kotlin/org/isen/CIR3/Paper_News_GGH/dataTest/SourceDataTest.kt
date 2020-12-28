package org.isen.CIR3.Paper_News_GGH.dataTest

import org.isen.CIR3.Paper_News_GGH.data.ConfigData
import org.isen.CIR3.Paper_News_GGH.data.SourceData
import org.isen.CIR3.Paper_News_GGH.searchEngine.ReadConfigFile
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class SourceDataTest {
    private val classUnderTest: SourceData = SourceData("id","name")
    @Test
    fun testArticleDataIdNotModified() {
        assertEquals("id",classUnderTest.id,"Article data should have an id")
    }
    @Test
    fun testArticleNameNotModified() {
        assertEquals("name",classUnderTest.name,"Article data should have an name")
    }
}