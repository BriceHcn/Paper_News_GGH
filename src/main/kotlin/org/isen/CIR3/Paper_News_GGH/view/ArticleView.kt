package org.isen.CIR3.Paper_News_GGH.view

import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.data.ArticleData
import org.isen.CIR3.Paper_News_GGH.searchEngine.ImgTools
import org.isen.CIR3.Paper_News_GGH.searchEngine.OpenInBrowser
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.text.SimpleDateFormat
import javax.swing.*
import kotlin.system.exitProcess


class ArticleView(article:ArticleData):JFrame() {
    companion object : Logging

    //icone application
    private val img = ImageIcon(System.getProperty("user.dir") + "/src/main/resources/icone.png")//TODO ajouter un image d'icone

    //ajout menu
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


    //composant fenetre
    //titre, description, contenu, date
    private val labelTitre:JLabel= JLabel(
        String.format("<html><body style=\"font-weight:bold;  font-size:20px;  text-align: center;  text-justify: inter-word;\">%s</body></html>",article.title),JLabel.CENTER)
    private val labelDesc:JLabel= JLabel(
        String.format("<html><body style=\"text-align: center;  text-justify: inter-word;\">%s</body></html>",article.description),JLabel.CENTER)
    private val labelContent:JLabel= JLabel(
        String.format("<html><body style=\"text-align: center;  text-justify: inter-word;\">%s</body></html>",article.content),JLabel.CENTER)
    //source, auteur,date
    private val publishedAtString :String = SimpleDateFormat("d MMM yyyy HH:mm").format(article.publishedAt)
    private val labelDetails:JLabel= JLabel(
        String.format("<html><body style=\"font-weight:bold;  font-size:12px;  color:red;  text-align: justify;  text-justify: inter-word;\">%s</body></html>","published on the $publishedAtString, on ${article.source.name} ${if (article.author != null) " written by ${article.author}" else ""}"),JLabel.CENTER)


    //conteneur info
    private val panelInfo:JPanel= JPanel(GridLayout(5,1))


    //bouton et conteneur bouton
    private val btnSeeOnline:JButton= JButton("See online").apply{
        actionCommand = "SEE_ONLINE"
        addActionListener(ButtonClickListener(article))
    }
    private val btnGetPdf:JButton=JButton("Get this news in pdf").apply{
        actionCommand = "GET_PDF"
        addActionListener(ButtonClickListener(article))
    }
    private val panelBouton:JPanel= JPanel(GridLayout(1,2))


    //image
    private val tool:ImgTools=ImgTools()
    private var imgArt=ImageIcon(System.getProperty("user.dir") + "/src/main/resources/${tool.getArticleImg(article.urlToImage)}")
    //private val scaledImgArticle:Image = imgArt.image.getScaledInstance(28, 28, Image.SCALE_DEFAULT)
    private val panelImg:JPanel=JPanel()
    private val labelimg:JLabel= JLabel(imgArt,JLabel.CENTER)



    init{
        //icone
        this.iconImage = img.image

        //initialisation menu
        menu1.add(menuItemQuit)
        menuBar.add(menu1)
        menu2.add(menuItemAboutUs)
        menu2.add(menuItemIsenLink)
        menu2.add(menuItemLinkNewsAPI)
        menuBar.add(menu2)
        this.jMenuBar=menuBar

        //layout de la fenetre
        this.layout=BorderLayout()

        //ajout image
        labelimg.preferredSize= Dimension(1000,250)
        panelImg.add(labelimg)
        this.add(panelImg,BorderLayout.PAGE_START)

        //ajout détails
        panelInfo.add(labelTitre)
        panelInfo.add(labelDetails )
        panelInfo.add(labelDesc)
        panelInfo.add(labelContent)
        this.add(panelInfo,BorderLayout.CENTER)

        //ajout bouton
        panelBouton.add(btnSeeOnline)
        panelBouton.add(btnGetPdf)
        panelInfo.add(panelBouton)

        //parametre generale de la fenetre
        title = "${article.title} - Paper News GGH"
        setSize(1000, 600)
        this.defaultCloseOperation = EXIT_ON_CLOSE //todo peut etre retourner a l'ecran des titres,personne regarde une seule news puit ferme u_n site
        isVisible = true
    }

    //actionneur pour les boutons en bas d'article
    private inner class ButtonClickListener(private var article: ArticleData): ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            when(e.actionCommand){
                "SEE_ONLINE" ->{
                    OpenInBrowser(article.url)
                    logger.info("browser open")
                }
                "GET_PDF" ->{
                    //TODO faire des pdfs
                    logger.info("pdf is asked")
                }
                else -> logger.info("unknown action")
            }
        }
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
                    logger.info("about window is opening")
                }
                "ISEN_LINK" -> {
                    OpenInBrowser("www.isen-mediterranee.fr")
                    logger.info("browser open")
                }
                "NEWSAPI_LINK" ->{
                    OpenInBrowser("https://newsapi.org")
                    logger.info("browser open")
                }
                else -> logger.info("unknown action")
            }
        }
    }

}