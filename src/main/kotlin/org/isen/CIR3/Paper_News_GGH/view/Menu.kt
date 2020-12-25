package org.isen.CIR3.Paper_News_GGH.view

import org.isen.CIR3.Paper_News_GGH.searchEngine.OpenInBrowser
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem
import kotlin.system.exitProcess

class Menu {
     val menuBar: JMenuBar = JMenuBar()
    private val menu1: JMenu = JMenu("Files")
    private val menu2: JMenu = JMenu("About")
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

    init{
        //initialisation menu
        menu1.add(menuItemQuit)
        menuBar.add(menu1)
        menu2.add(menuItemAboutUs)
        menu2.add(menuItemIsenLink)
        menu2.add(menuItemLinkNewsAPI)
        menuBar.add(menu2)
    }

    //actionneur pour le menu
    private inner class MenuButtonClickListener : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            when (e.actionCommand) {
                "QUIT" -> {
                    MainView.logger.info("Paper_News_GGH closed")
                    exitProcess(0)
                }
                "ABOUT_US" -> {
                    AboutView()
                    MainView.logger.info("about window is opening")
                }
                "ISEN_LINK" -> {
                    OpenInBrowser("www.isen-mediterranee.fr")
                    MainView.logger.info("browser open")
                }
                "NEWSAPI_LINK" ->{
                    OpenInBrowser("https://newsapi.org")
                    MainView.logger.info("browser open")
                }
                else -> MainView.logger.info("unknown menu action")
            }
        }
    }
}