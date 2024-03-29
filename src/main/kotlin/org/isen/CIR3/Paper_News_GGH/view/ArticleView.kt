package org.isen.CIR3.Paper_News_GGH.view

import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.data.ArticleData
import org.isen.CIR3.Paper_News_GGH.searchEngine.ImgTools
import org.isen.CIR3.Paper_News_GGH.searchEngine.OpenInBrowser
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.Toolkit
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.text.SimpleDateFormat
import java.time.LocalDate
import javax.swing.*


class ArticleView(article:ArticleData):JFrame() {
    companion object : Logging

    //icone application avec un petit easter egg
    private val img:ImageIcon = if(LocalDate.now().monthValue==12 || LocalDate.now().monthValue==1 || LocalDate.now().monthValue==2){
        ImageIcon(System.getProperty("user.dir") + "/src/main/resources/photo/iconeChristmas.png") }else{
        ImageIcon(System.getProperty("user.dir") + "/src/main/resources/photo/icone.png") }

    //menu
    private val menuBar:JMenuBar=Menu().menuBar

    //composant fenetre
    //titre, description, contenu, date
    private val labelTitre:JLabel= JLabel(
        String.format("<html><body style=\"font-weight:bold;  font-size:20px;  text-align: center;  text-justify: inter-word;\">%s</body></html>", article.title ?: "unknown"),JLabel.CENTER)
    private val labelDesc:JLabel= JLabel(
        String.format("<html><body style=\"text-align: center;  text-justify: inter-word;\">%s</body></html>",article.description ?: "unknown"),JLabel.CENTER)
    private val labelContent:JLabel= JLabel(
        String.format("<html><body style=\"text-align: center;  text-justify: inter-word;\">%s</body></html>", article.content?.substringBefore("[+") ?: (article.content ?: "unknown")),JLabel.CENTER)
    //source, auteur,date
    private val publishedAtString :String? = SimpleDateFormat("d MMM yyyy HH:mm").format(article.publishedAt)
    private val labelDetails:JLabel= JLabel(
        String.format("<html><body style=\"font-weight:bold;  font-size:12px;  color:red;  text-align: justify;  text-justify: inter-word;\">%s</body></html>","published on the ${publishedAtString ?: "unknown"} , on ${article.source?.name ?:"unknown"} ${if (article.author==null) "" else "written by ${article.author}"}"),JLabel.CENTER)


    //conteneur info
    private val panelInfo:JPanel= JPanel(GridLayout(5,1))


    //bouton et conteneur bouton
    private val btnSeeOnline:JButton= JButton("See online").apply{
        actionCommand = "SEE_ONLINE"
        addActionListener(ButtonClickListener(article))
    }
    private val btnFeature:JButton=JButton("Incoming feature").apply{
        actionCommand = "FEATURE"
        addActionListener(ButtonClickListener(article))
    }
    private val panelBouton:JPanel= JPanel(GridLayout(1,2))


    //image
    private val tool:ImgTools=ImgTools()
    private var imgArt=ImageIcon(System.getProperty("user.dir") + "/src/main/resources/photo/ArticleImg/${tool.getArticleImg(article.urlToImage)}")
    private val panelImg:JPanel=JPanel()
    private val labelimg:JLabel= JLabel(imgArt,JLabel.CENTER)



    init{
        logger.info("opening article view window")
        //icone
        this.iconImage = img.image

        //initialisation menu
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
        //panelBouton.add(btnFeature)
        panelInfo.add(panelBouton)

        //parametre generale de la fenetre
        title = "${article.title} - Paper News GGH"
        setSize(1000, 700)
        setLocation(((Toolkit.getDefaultToolkit().screenSize.getWidth() - width) / 2).toInt(), ((Toolkit.getDefaultToolkit().screenSize.getHeight() - height) / 2).toInt())
        this.defaultCloseOperation = DISPOSE_ON_CLOSE
        isVisible = true
    }

    //actionneur pour les boutons en bas d'article
    private inner class ButtonClickListener(private var article: ArticleData): ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            when(e.actionCommand){
                "SEE_ONLINE" ->{
                    //ouverture d'un article
                    article.url?.let { OpenInBrowser(it) }
                    logger.info("browser opening")

                }
                "FEATURE" ->{
                    //Si on veut ajouter une fonctionalité supplementaires
                    logger.info("")
                }
                else -> logger.info("unknown action")
            }
        }
    }

}