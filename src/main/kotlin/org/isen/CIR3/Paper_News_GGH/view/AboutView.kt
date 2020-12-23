package org.isen.CIR3.Paper_News_GGH.view

import org.apache.logging.log4j.kotlin.Logging
import java.awt.BorderLayout
import java.awt.Color
import java.awt.GridLayout
import java.time.LocalDate
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

class AboutView : JFrame(){

    companion object : Logging

    //icone application avec un petit easter egg
    private val img:ImageIcon = if(LocalDate.now().monthValue==12 || LocalDate.now().monthValue==1 || LocalDate.now().monthValue==2){
        ImageIcon(System.getProperty("user.dir") + "/src/main/resources/photo/iconeChristmas.png") }else{
        ImageIcon(System.getProperty("user.dir") + "/src/main/resources/photo/icone.png") }

    //elements fenetre
    private val aboutLayout = GridLayout(1,3)
    private val lucasPanel = JPanel(BorderLayout())
    private val julienPanel = JPanel(BorderLayout())
    private val bricePanel = JPanel(BorderLayout())

    //element pour chaque partie
    private val imgLucas = ImageIcon(System.getProperty("user.dir") + "/src/main/resources/photo/teamMembers/lucas.jpg")
    private val labelImgLucas = JLabel(imgLucas)

    private val imgJulien = ImageIcon(System.getProperty("user.dir") + "/src/main/resources/photo/teamMembers/julien.jpg")
    private val labelImgJulien = JLabel(imgJulien)

    private val imgBrice = ImageIcon(System.getProperty("user.dir") + "/src/main/resources/photo/teamMembers/brice.jpg")
    private val labelImgBrice = JLabel(imgBrice)

    init{
        logger.info("Opening window : about us")

        //ajout icone d'application
        this.iconImage = img.image

        this.layout=aboutLayout

        lucasPanel.background= Color.CYAN
        julienPanel.background= Color.MAGENTA
        bricePanel.background=Color.ORANGE

        //ajout pour chaque membre de la photo et d'un texte
        lucasPanel.add(labelImgLucas,BorderLayout.CENTER)
        lucasPanel.add(JLabel("GIRAUD Lucas - blablabla"),BorderLayout.PAGE_END)

        julienPanel.add(labelImgJulien,BorderLayout.CENTER)
        julienPanel.add(JLabel("GUINHUT Julien - blablabla"),BorderLayout.PAGE_END)

        bricePanel.add(labelImgBrice,BorderLayout.CENTER)
        bricePanel.add(JLabel("HECHON Brice - blablabla"),BorderLayout.PAGE_END)

        this.add(lucasPanel)
        this.add(julienPanel)
        this.add(bricePanel)

        //parametre generale de la fenetre
        title = "About Us - Paper News GGH"
        setSize(700, 280)//TODO placer fenetre milieu ecran
        this.defaultCloseOperation = HIDE_ON_CLOSE
        isVisible = true
    }
}
