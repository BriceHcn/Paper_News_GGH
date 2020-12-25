package org.isen.CIR3.Paper_News_GGH.view

import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.App
import org.isen.CIR3.Paper_News_GGH.data.ArticleData
import org.isen.CIR3.Paper_News_GGH.data.NewsSearchData
import org.isen.CIR3.Paper_News_GGH.searchEngine.NewsSearchEngine
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.Toolkit
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.time.LocalDate
import javax.swing.*


class MainView : JFrame(){
    //logger
    companion object : Logging

    //icone application avec un petit easter egg
    private val img:ImageIcon = if(LocalDate.now().monthValue==12 || LocalDate.now().monthValue==1 || LocalDate.now().monthValue==2){
         ImageIcon(System.getProperty("user.dir") + "/src/main/resources/photo/iconeChristmas.png") }else{
        ImageIcon(System.getProperty("user.dir") + "/src/main/resources/photo/icone.png") }

    //menu
    private val menuBar:JMenuBar=Menu().menuBar

    //fenetre a onglet
    private val tabbedPane = JTabbedPane(JTabbedPane.LEFT)


    //layout principal
    private val layoutMainView=BorderLayout()

    //initialisation fenetre graphique
    init{
        logger.info("Launching main view window")
        //ajout icone d'application
        this.iconImage = img.image

        //ajout du menu
        this.jMenuBar=menuBar

        //initialisation layout principal
        this.layout=layoutMainView

        //initialisation onglets

        for(cat in App.cfg.categoryList){
            //ajout de chaque panneau comprenant les news
            val panel = panelNewsMaker(cat)
            tabbedPane.add(cat,panel)
        }
        this.add(tabbedPane, BorderLayout.CENTER)


        //parametre generale de la fenetre
        title = "Paper News GGH"
        setSize(1100, 580)
        setLocation(((Toolkit.getDefaultToolkit().screenSize.getWidth() - getWidth()) / 2).toInt(), ((Toolkit.getDefaultToolkit().screenSize.getHeight() - getHeight()) / 2).toInt())
        this.defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }


    //fonction qui creer des panels pour chaque categorie
    private fun panelNewsMaker(cat:String):JPanel{
        //on recupere les données
      val newsData: NewsSearchData? =NewsSearchEngine(null,cat  ,null).newsResult

        //on creer un tableau de la taille des données
      val tabArticles=JPanel(GridLayout(newsData?.articles?.size!!,1))

        for ((articleIterator, e) in newsData.articles.withIndex()){
            //pour chaque article, on affiche le titre et un bouton pour ouvrir cet article
            val ligne = JPanel(BorderLayout())

            //ajout titre news
            ligne.add(JLabel(e.title),BorderLayout.CENTER)
            val button=JButton("See more").apply {
                //ajout du listener pour chaque boutton avec comme parametre l'article en question
                actionCommand = "OPEN_ARTICLE"
                addActionListener(ArticleButtonClickListener(newsData.articles[ articleIterator]))
            }
            button.size= Dimension(100,5)
            //ajout bouton voir plus
            ligne.add(button,BorderLayout.LINE_END)
            tabArticles.add(ligne)//on "ajoute" la ligne au tableau
        }
        return tabArticles
    }


    //actionneur pour les articles
    private inner class ArticleButtonClickListener(private var article: ArticleData): ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            if(e.actionCommand=="OPEN_ARTICLE") {
                logger.info("Opening article : ${article.title}...")
                val artView = ArticleView(article)
            }
            else{
                logger.info("unknown action")
            }
        }
    }




}