/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.miki.service.scraping.batch;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.miki.service.scraping.model.Index;
import uk.co.miki.service.scraping.repository.IndexRepository;

/**
 *
 * @author darongpon
 */
@Service
public class Scraping {
    
    private final static Logger logger = LoggerFactory.getLogger(Scraping.class);
    @Autowired
    private IndexRepository indexRepository;
    
    public Index pulling(String indexName) {
        Index index = new Index();
        try {
            // fetch the document over HTTP
            String url = "https://marketdata.set.or.th/mkt/sectorialindices.do?language=en&country=US";
            Document doc = Jsoup.connect(url).get();
            
            // get element td
            Elements trElements = doc.select("tr:matches(SET)");
            for (Element tr : trElements) {
                // get the value from the td
                for(Element td : tr.getAllElements()){
                    if(indexName.equals(td.text())){
                        System.out.println(indexName+": " + td.nextElementSibling().text());
                        index.setIndex(indexName);
                        index.setLast(td.nextElementSibling().text());
                        break;
                    } 
                }
            }
            // get time
            Elements captionElements = doc.select("caption:contains(Last Update)");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            for (Element caption : captionElements) {
                String captionText = caption.text();
                String dateString = captionText.substring(captionText.lastIndexOf("Last Update ")+12);
                System.out.println("time: " + dateString); 
                Date date = formatter.parse(dateString);
                index.setDate(dateString);
                break;
            }
        } catch (IOException ex) {
            logger.error("IOException pulling Fail", ex);
        } catch (ParseException ex) {
            logger.error(" ParseException pulling Fail", ex);
        }
        return index;
    }
    
    public void putting(Index index) { 
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        index.setCreate_date(formatter.format(new Date()));
        indexRepository.save(index);
    }
}
