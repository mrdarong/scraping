/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.miki.service.scraping.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import uk.co.miki.service.scraping.model.Index;

/**
 *
 * @author darongpon
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    
    @Autowired
    private Scraping scraping;

    @Scheduled(fixedRate = 3000000)
    public void spushdata() {
        Index index = scraping.pulling("SET");
        Index index50 = scraping.pulling("SET50");
        Index index100 = scraping.pulling("SET100");
        
        scraping.putting(index);
        scraping.putting(index50);
        scraping.putting(index100);
                
    }
}
