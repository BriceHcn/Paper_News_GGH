package org.isen.CIR3.Paper_News_GGH.view

import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.data.ArticleData
import org.isen.CIR3.Paper_News_GGH.searchEngine.ImgTools
import java.awt.Dimension
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel
import java.awt.Image
import java.awt.GridLayout
import javax.swing.JPanel


class ArticleView(article:ArticleData):JFrame() {
    companion object : Logging

    //icone application
    private val img = ImageIcon(System.getProperty("user.dir") + "/src/main/resources/icone.png")//TODO ajouter un image d'icone

    //ajout menu
    //TODO pour simplifier la lecture du code, a rajouter quand la fenetre est finie

    //composant fenetre
    //titre, description, contenu, date
    private val labelTitre:JLabel= JLabel(article.title)
    private val labelDesc:JLabel= JLabel(article.description)
    private val labelContent:JLabel=JLabel(article.content)

    //source, auteur
    private val labelNomSource:JLabel= JLabel(article.source.name)
    private val labelNomAuteur:JLabel= JLabel(article.author)
    private val labelDatePubli:JLabel=JLabel(article.publishedAt)//todo a formater bien

    //image
    private val tool:ImgTools=ImgTools()
    private val imgArt = ImageIcon(System.getProperty("user.dir") + "/src/main/resources/${tool.getAdressImg(article.urlToImage)}")
    //private val scaledImgArticle:Image = imgArt.image.getScaledInstance(28, 28, Image.SCALE_DEFAULT)
    private val panelImg:JPanel=JPanel()
    private val labelimg:JLabel= JLabel(imgArt)



    init{
        //icone
        this.iconImage = img.image

        //layout
        this.layout=GridLayout(2,1)

        //ajout image
        labelimg.preferredSize= Dimension(1000,200)
        panelImg.add(labelimg)
        this.add(panelImg)


        this.add(labelTitre)



        //parametre generale de la fenetre
        title = "${article.title} - Paper News GGH"
        setSize(1000, 500)
        this.defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }


}