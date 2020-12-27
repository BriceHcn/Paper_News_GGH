package org.isen.CIR3.Paper_News_GGH.searchEngine

import java.io.File
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

class ImgTools {
   fun getArticleImg(urlImg: String?): String {
        var url = urlImg

       //on vide le dossiers des images
       Arrays.stream(File(System.getProperty("user.dir") + "/src/main/resources/photo/ArticleImg").listFiles()).forEach(File::delete);

       if (urlImg == null) {
            return "defaultArticle.jpg"
        }
        else{
            //tout les cas "bizarre" qu'on a pu rencontré sur les urls
            url = urlImg.removeSuffix("?v=1")
            url = urlImg.removeSuffix("?v1")

            val filename = url.substringAfterLast('/')
            try {
                URL(url).openStream().use { `in` ->
                    Files.copy(`in`, Paths.get(System.getProperty("user.dir") + "/src/main/resources/photo/ArticleImg/$filename"))}

            //si l'image a un defaut dans le nom, extension etc...
            } catch (e: Exception) {
                return "defaultArticle.jpg"
            }
            return filename
        }
    }
}


