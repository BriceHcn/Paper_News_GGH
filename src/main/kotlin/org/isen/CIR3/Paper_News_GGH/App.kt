/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.isen.CIR3.Paper_News_GGH

import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.data.ArticleData
import org.isen.CIR3.Paper_News_GGH.data.ConfigData
import org.isen.CIR3.Paper_News_GGH.data.NewsSearchData
import org.isen.CIR3.Paper_News_GGH.searchEngine.NewsSearchEngine
import org.isen.CIR3.Paper_News_GGH.searchEngine.ReadConfigFile
import org.isen.CIR3.Paper_News_GGH.view.ArticleView
import org.isen.CIR3.Paper_News_GGH.view.MainView

class App  {
    companion object : Logging
}

fun main(args: Array<String>) {
    //on log le lancement de l'application, ça fait plaisir
    App.logger.info("Paper_News_GGH Started")

    //recuperation fichier de config
    val cfg:ConfigData = ReadConfigFile().cfg

    //lancement fenetre graphique principale
    App.logger.info("Opening window : main window")
    val mainWindow=MainView(cfg)

    //pour tester la fenetre article sans refaire toute les requete et donc griller mon apikey
    //val newsData: NewsSearchData? = NewsSearchEngine(null, cfg.categoryList[1],null).newsResult
    //val article:ArticleData= newsData!!.articles[0]
    //val testArticleGui:ArticleView=ArticleView(article)
}
