package org.isen.CIR3.Paper_News_GGH.view

import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.searchEngine.OpenInBrowser
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem
import kotlin.system.exitProcess

class Menu {
    companion object : Logging
     val menuBar: JMenuBar = JMenuBar()
    private val menu1: JMenu = JMenu("Files")
    private val menu2: JMenu = JMenu("About")
    private val menu3: JMenu = JMenu("Favorites")
    private val menuItemQuit: JMenuItem = JMenuItem("Quit").apply {
        actionCommand = "QUIT"
        addActionListener(MenuButtonClickListener()) }
    private val menuItemAboutUs: JMenuItem = JMenuItem("About us").apply {
        actionCommand = "ABOUT_US"
        addActionListener(MenuButtonClickListener()) }
    private val menuItemIsenLink: JMenuItem = JMenuItem("Visit isen-mediterranee.fr").apply {
        actionCommand = "ISEN_LINK"
        addActionListener(MenuButtonClickListener()) }
    private val menuItemLinkNewsAPI: JMenuItem = JMenuItem("visit newsapi.org").apply {
        actionCommand = "NEWSAPI_LINK"
        addActionListener(MenuButtonClickListener()) }
    /*
    private val menuItemFavorites: JMenuItem = JMenuItem("My favorites news").apply {
        actionCommand = "FAVORITE_VIEW"
        addActionListener(MenuButtonClickListener()) }

     */

    init{
        //initialisation menu
        menu1.add(menuItemQuit)
        menuBar.add(menu1)
        menu2.add(menuItemAboutUs)
        menu2.add(menuItemIsenLink)
        menu2.add(menuItemLinkNewsAPI)
        menuBar.add(menu2)
        //menu3.add(menuItemFavorites)
        //menuBar.add(menu3)
    }

    //actionneur pour le menu
    private inner class MenuButtonClickListener : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            when (e.actionCommand) {
                "QUIT" -> {
                    logger.info("Paper_News_GGH closed")
                    exitProcess(0)
                }
                "ABOUT_US" -> {
                    AboutView()
                }
                "ISEN_LINK" -> {
                    OpenInBrowser("www.isen-mediterranee.fr")
                    logger.info("browser open")
                }
                "NEWSAPI_LINK" ->{
                    OpenInBrowser("https://newsapi.org")
                    logger.info("browser open")
                }
                /*
                "FAVORITE_VIEW" ->{
                    FavoriteView(null)
                }
                 */
                else -> logger.info("unknown menu action")
            }
        }
    }
}