/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.miki.service.scraping.service;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.co.miki.service.scraping.model.Index;
import uk.co.miki.service.scraping.repository.IndexRepository;

/**
 *
 * @author darongpon
 */
@Service
public class Enquery {
    private final static Logger logger = LoggerFactory.getLogger(Enquery.class);
    
    @Inject
    private IndexRepository indexRepository;
    
    public Index getIndex(String index) {
        //todo
        return null;
    }
    
}
