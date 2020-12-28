import org.apache.logging.log4j.kotlin.logger
import org.isen.CIR3.Paper_News_GGH.data.ArticleData
import org.isen.CIR3.Paper_News_GGH.data.SourceData
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ArticleDataTest {
    private val classUnderTest = ArticleData(SourceData("10","name"),"author","title","description","url","urlToImage",
        Date(1,1,1),"content")
    @Test fun testArticleDataAuthorNotModified() {
        assertEquals("author",classUnderTest.author,"Article data should have an author")
    }
    @Test fun testArticleDataSourceIdNotModified() {
        val source = SourceData("10","name")
        assertEquals(source.id,classUnderTest.source.id,"Article data should have source id")
    }
    @Test fun testArticleDataSourceNameNotModified() {
        val source = SourceData("10","name")
        assertEquals(source.name,classUnderTest.source.name,"Article data should have source name")
    }
    @Test fun testArticleDataTitleNotModified() {
        assertEquals("title",classUnderTest.title,"Article data should have a title")
    }
    @Test fun testArticleDataDescriptionNotModified() {
        assertEquals("description",classUnderTest.description,"Article data should have a description")
    }
    @Test fun testArticleDataUrlNotModified() {
        assertEquals("url",classUnderTest.url,"Article data should have a url")
    }
    @Test fun testArticleDataUrlToImageNotModified() {
        assertEquals("urlToImage",classUnderTest.urlToImage,"Article data should have a urlToImage")
    }
    @Test fun testArticleDataPublishedAtNotModified() {
        assertEquals(Date(1,1,1),classUnderTest.publishedAt,"Article data should have a publishedAt")
    }
    @Test fun testArticleDataContentNotModified() {
        assertEquals("content",classUnderTest.content,"Article data should have content")
    }

}