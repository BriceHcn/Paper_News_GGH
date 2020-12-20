package org.isen.CIR3.Paper_News_GGH.searchEngine

import com.sksamuel.hoplite.ConfigLoader
import org.isen.CIR3.Paper_News_GGH.data.ConfigData

class ReadConfigFile {
    val cfg:ConfigData

    init {
        //TODO remettre logger mais sur une ligne sinon c'est relou
        //NewsSearchEngine.logger.info("---------------------------------config file reading-------------------------------------------")
        this.cfg= ConfigLoader().loadConfigOrThrow<ConfigData>("/config.yaml")
        //NewsSearchEngine.logger.info("api key found : ${cfg!!.apiKey}")
        //NewsSearchEngine.logger.info("default country found : ${cfg!!.defaultLanguage}")
        //NewsSearchEngine.logger.info("category list found : ${cfg!!.categoryList}")
        //NewsSearchEngine.logger.info("country list found : ${cfg!!.countryList}")
        //NewsSearchEngine.logger.info("-----------------------------------------------------------------------------------------------")
    }

}