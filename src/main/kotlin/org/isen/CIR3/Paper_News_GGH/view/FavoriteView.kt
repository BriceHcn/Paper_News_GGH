package org.isen.CIR3.Paper_News_GGH.view

import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.data.ArticleData
import java.awt.Toolkit
import java.time.LocalDate
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JMenuBar

class FavoriteView(favArticle: List<ArticleData>?) : JFrame(){

    companion object : Logging

    //icone application avec un petit easter egg
    private val img: ImageIcon = if(LocalDate.now().monthValue==12 || LocalDate.now().monthValue==1 || LocalDate.now().monthValue==2){
        ImageIcon(System.getProperty("user.dir") + "/src/main/resources/photo/iconeChristmas.png") }else{
        ImageIcon(System.getProperty("user.dir") + "/src/main/resources/photo/icone.png") }

    //menu
    private val menuBar: JMenuBar =Menu().menuBar




    init{
        logger.info("opening favorite view window")
        //icone
        this.iconImage = img.image

        //initialisation menu
        this.jMenuBar=menuBar






        //parametre generale de la fenetre
        title = "My favorites - Paper News GGH"
        setSize(1000, 580)
        setLocation(((Toolkit.getDefaultToolkit().screenSize.getWidth() - width) / 2).toInt(), ((Toolkit.getDefaultToolkit().screenSize.getHeight() - height) / 2).toInt())
        this.defaultCloseOperation = DISPOSE_ON_CLOSE
        isVisible = true
    }
}