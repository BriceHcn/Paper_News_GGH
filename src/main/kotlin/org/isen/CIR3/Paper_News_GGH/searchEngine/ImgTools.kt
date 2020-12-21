package org.isen.CIR3.Paper_News_GGH.searchEngine

import java.io.File
import java.io.IOException
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths

class ImgTools() {
    fun getAdressImg(urlImg: String): String {
        if (urlImg == null) {
            return "defaultArticle.jpg"
        } else {
            val filename = urlImg.substringAfterLast('/')
            val img =
                File(System.getProperty("user.dir") + "/src/main/resources/imgArticle.${filename.substringAfterLast('.')}")
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
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return "imgArticle.${filename.substringAfterLast('.')}"
        }
    }

}
