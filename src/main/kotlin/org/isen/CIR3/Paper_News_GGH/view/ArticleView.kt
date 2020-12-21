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


class ArticleView(article:ArticleData):JFrame() {
    companion object : Logging

    //icone application
    private val img = ImageIcon(System.getProperty("user.dir") + "/src/main/resources/icone.png")//TODO ajouter un image d'icone

    //ajout menu
    //TODO pour simplifier la lecture du code, a rajouter quand la fenetre est finie


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

        //layout
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
        this.defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }

    //actionneur pour les articles
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


}