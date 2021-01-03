package org.isen.CIR3.Paper_News_GGH.searchEngine

import com.sksamuel.hoplite.ConfigLoader
import org.apache.logging.log4j.kotlin.Logging
import org.isen.CIR3.Paper_News_GGH.data.ConfigData

class ReadConfigFile {
    companion object : Logging
    val cfg:ConfigData

    init {
        logger.info("---------------------------------config file reading-------------------------------------------")
        this.cfg= ConfigLoader().loadConfigOrThrow("/config.yaml")
        logger.info("api key found : ${cfg.apiKey}")
        logger.info("default country found : ${cfg.defaultLanguage}")
        logger.info("category list found : ${cfg.categoryList}")
        logger.info("country list found : ${cfg.countryList}")
        logger.info("-----------------------------------------------------------------------------------------------")
    }
}