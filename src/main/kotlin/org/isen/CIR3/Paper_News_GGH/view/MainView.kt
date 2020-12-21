package org.isen.CIR3.Paper_News_GGH.view

import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.data.ArticleData
import org.isen.CIR3.Paper_News_GGH.data.ConfigData
import org.isen.CIR3.Paper_News_GGH.data.NewsSearchData
import org.isen.CIR3.Paper_News_GGH.searchEngine.NewsSearchEngine
import org.isen.CIR3.Paper_News_GGH.searchEngine.OpenInBrowser
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*
import kotlin.system.exitProcess


class MainView(cfg: ConfigData) : JFrame(){
    //logger
    companion object : Logging

    //icone application
    private val img = ImageIcon(System.getProperty("user.dir") + "/src/main/resources/icone.png")//TODO ajouter un image d'icone

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

    //initialisation fenetre graphique
    init{
        //ajout icone d'application
        this.iconImage = img.image

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

        //initialisation onglets
        val tabbedPane = JTabbedPane(JTabbedPane.LEFT)
        for(cat in cfg.categoryList){
            //ajout de chaque panneau comprenant les news
            val panel = panelNewsMaker(cat)
            tabbedPane.add(cat,panel)
        }
        this.add(tabbedPane, BorderLayout.CENTER)


        //parametre generale de la fenetre
        title = "Paper News GGH"
        setSize(1100, 580)
        //this.setLocation(30, -1000)//TODO remove for prod
        this.defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }


    //fonction qui creer des panels pour chaque categorie
    private fun panelNewsMaker(cat:String):JPanel{
        //on recupere les données
      val newsData: NewsSearchData? =NewsSearchEngine(null,cat  ,null).newsResult

        //on creer un tableau de la taille des données
      val tabArticles=JPanel(GridLayout(newsData?.articles?.size!!,1))
        var articleIterator:Int=0
        for ( e in newsData.articles){
            //pour chaque article, on affiche le titre et un bouton pour ouvrir cet article
            val ligne = JPanel(BorderLayout())

            //ajout titre news
            ligne.add(JLabel(e.title),BorderLayout.CENTER)
            val button=JButton("See more").apply {
                //ajout du listener pour chaque boutton avec comme parametre l'article en question
                actionCommand = "OPEN_ARTICLE"
                addActionListener(ArticleButtonClickListener(newsData?.articles[ articleIterator]))
            }
            button.setSize(Dimension(100,5))
            //ajout bouton voir plus
            ligne.add(button,BorderLayout.LINE_END)
            tabArticles.add(ligne)//on "ajoute" la ligne au tableau
            articleIterator++
        }
        return tabArticles
    }


    //actionneur pour les articles
    private inner class ArticleButtonClickListener(private var article: ArticleData): ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            if(e.actionCommand=="OPEN_ARTICLE")
            logger.info("Opening article : ${article.title.subSequence(0,50)}...")
            //TODO ouvrir fenetre qui presente cet article
        }
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