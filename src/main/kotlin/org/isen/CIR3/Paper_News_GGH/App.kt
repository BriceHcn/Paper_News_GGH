/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.isen.CIR3.Paper_News_GGH

import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.data.ConfigData
import org.isen.CIR3.Paper_News_GGH.searchEngine.ReadConfigFile
import org.isen.CIR3.Paper_News_GGH.view.MainView

//TODO faire des tests pour avoir un max de points
class App  {
    companion object : Logging{
        val cfg: ConfigData= ReadConfigFile().cfg
    }
}

fun main(args: Array<String>) {
    //on log le lancement de l'application, ça fait plaisir
    App.logger.info("Paper_News_GGH Started")

    //lancement fenetre graphique principale
    val mainWindow=MainView()
}
