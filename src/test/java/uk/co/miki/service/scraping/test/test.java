/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.miki.service.scraping.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import uk.co.miki.service.scraping.Scarpingbatch;
import uk.co.miki.service.scraping.batch.Scraping;
import uk.co.miki.service.scraping.model.Index;

/**
 *
 * @author darongpon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Scarpingbatch.class)
public class test {
    @Autowired
    private Scraping scraping;
    
    @Test
    public void test_data() throws Exception{
        System.out.println("uk.co.miki.service.scraping.test.test.test_data()");
        Index index = scraping.pulling("SET");
        scraping.putting(index);
    }
}
