/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.isen.CIR3.Paper_News_GGH

import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.data.ArticleData
import org.isen.CIR3.Paper_News_GGH.data.ConfigData
import org.isen.CIR3.Paper_News_GGH.data.NewsSearchData
import org.isen.CIR3.Paper_News_GGH.searchEngine.ImgTools
import org.isen.CIR3.Paper_News_GGH.searchEngine.NewsSearchEngine
import org.isen.CIR3.Paper_News_GGH.searchEngine.ReadConfigFile
import org.isen.CIR3.Paper_News_GGH.view.ArticleView
import org.isen.CIR3.Paper_News_GGH.view.MainView
import javax.swing.ImageIcon

class App  {
    //TODO faire des tests pour avoir un max de points
    companion object : Logging {
        //lecture fichier config
        val cfg: ConfigData= ReadConfigFile().cfg
    }
}
fun main(args: Array<String>) {
    //on log le lancement de l'application, ça fait plaisir
    App.logger.info("Paper_News_GGH Started")

    //lancement fenetre graphique principale
    val mainWindow=MainView()
}
