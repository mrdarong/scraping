/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.miki.service.scraping.controller;

import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.co.miki.service.scraping.model.Index;
import uk.co.miki.service.scraping.service.Enquery;

/**
 *
 * @author darongpon
 */

@RestController
public class ScrapingController {
    private final static Logger logger = LoggerFactory.getLogger(ScrapingController.class);
    
    @Autowired
    Enquery Enquery;

    @RequestMapping(method = RequestMethod.POST, value = "/getindex")
    public Index searchIndex(@RequestParam("index") String index) {
        logger.info("request index : " + index);
        return Enquery.getIndex(index);
    }
}
