package org.isen.CIR3.Paper_News_GGH.view

import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.data.ConfigData
import org.isen.CIR3.Paper_News_GGH.data.NewsSearchData
import org.isen.CIR3.Paper_News_GGH.searchEngine.NewsSearchEngine
import org.isen.CIR3.Paper_News_GGH.searchEngine.OpenInBrowser
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*
import javax.swing.plaf.basic.BasicTabbedPaneUI
import kotlin.system.exitProcess


class MainView(cfg: ConfigData) : JFrame(), ActionListener {
    //logger
    companion object : Logging

    //icone application
    private val img = ImageIcon(System.getProperty("user.dir") + "/src/main/resources/icone.png")

    //menu
    private val menuBar: JMenuBar = JMenuBar()
    private val menu1:JMenu = JMenu("Files")
    private val menu2:JMenu = JMenu("About")
    private val menuItemQuit: JMenuItem=JMenuItem("Quit").apply {
        actionCommand = "QUIT"
        addActionListener(MenuButtonClickListener()) }
    private val menuItemAboutUs:JMenuItem=JMenuItem("About us").apply {
        actionCommand = "ABOUT_US"
        addActionListener(MenuButtonClickListener()) }
    private val menuItemIsenLink:JMenuItem= JMenuItem("Visit isen-mediterranee.fr").apply {
        actionCommand = "ISEN_LINK"
        addActionListener(MenuButtonClickListener()) }
    private val menuItemLinkNewsAPI:JMenuItem= JMenuItem("visit newsapi.org").apply {
        actionCommand = "NEWSAPI_LINK"
        addActionListener(MenuButtonClickListener()) }


        //layout principal
        private val layoutMainView=BorderLayout()


    init{
        //ajout icone d'application
        this.iconImage = img.image//TODO ajouter un image d'icone

        //initialisation menu
        menu1.add(menuItemQuit)
        menuBar.add(menu1)
        menu2.add(menuItemAboutUs)
        menu2.add(menuItemIsenLink)
        menu2.add(menuItemLinkNewsAPI)
        menuBar.add(menu2)
        this.jMenuBar=menuBar

        //initialisation layout principal
        this.layout=layoutMainView

        //initialisation onglet
        val tabbedPane = JTabbedPane(JTabbedPane.LEFT)
        for(cat in cfg.categoryList){
            val panel =JPanel(BorderLayout())
            panel.add(JLabel("article sur $cat:"),BorderLayout.PAGE_START)
            tabbedPane.add(cat,panel)
        }
        this.add(tabbedPane, BorderLayout.CENTER);


        //parametre generale de la fenetre
        title = "Paper News GGH"
        setSize(770, 580)
        //this.setLocation(30, -1000)//TODO remove for prod
        this.defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }



    override fun actionPerformed(e: ActionEvent?) {
    }


    //actionneur pour le menu
    private inner class MenuButtonClickListener : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            when (e.actionCommand) {
                "QUIT" -> exitProcess(0)
                "ABOUT_US" -> null //TODO ouvrir une fenetre avec les membres de l'equipe
                "ISEN_LINK" -> OpenInBrowser("www.isen-mediterranee.fr")
                "NEWSAPI_LINK" -> OpenInBrowser("https://newsapi.org")
                else -> logger.info("clic sur un bouton incconu")
            }
        }
    }

}