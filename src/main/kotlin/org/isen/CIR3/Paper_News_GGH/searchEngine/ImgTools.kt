package org.isen.CIR3.Paper_News_GGH.searchEngine

import java.io.File
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths

class ImgTools() {
    fun getArticleImg(urlImg: String?): String {
        if (urlImg == null) {
            return "defaultArticle.jpg"
        }
        else{
        if (urlImg.endsWith("?v=1")) {
            urlImg.removeSuffix("?v=1")
            println(urlImg)
        }
        //s'il n'y a pas d'image dans notre articel


            val filename = urlImg.substringAfterLast('/')
            val img =File(System.getProperty("user.dir") + "/src/main/resources/imgArticle.${filename.substringAfterLast('.')}")
            if (img.exists()) {
                img.delete()
            }

            try {
                URL(urlImg).openStream().use { `in` ->
                    Files.copy(
                        `in`,
                        Paths.get(
                            System.getProperty("user.dir") + "/src/main/resources/imgArticle.${
                                filename.substringAfterLast('.')
                            }"
                        )
                    )
                }
                //si l'image a un defaut dans le nom, extension etc...
            } catch (e: Exception) {
                return "defaultArticle.jpg"
            }
            return "imgArticle.${filename.substringAfterLast('.')}"
        }
    }
}


