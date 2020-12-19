package org.isen.CIR3.Paper_News_GGH.searchEngine

import java.awt.Desktop
import java.io.IOException
import java.net.URI
import java.net.URISyntaxException

//thanks to https://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java/5226244
class OpenInBrowser(url:String) {
    init{
        if (Desktop.isDesktopSupported()) {
            val desktop = Desktop.getDesktop()
            try {
                desktop.browse(URI(url))
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: URISyntaxException) {
                e.printStackTrace()
            }
        } else {
            val runtime = Runtime.getRuntime()
            try {
                runtime.exec("xdg-open $url")
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}