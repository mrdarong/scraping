/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.miki.service.scraping.repository;

import org.springframework.data.repository.CrudRepository;
import uk.co.miki.service.scraping.model.Index;

/**
 *
 * @author darongpon
 */
public interface IndexRepository  extends CrudRepository<Index,Long>{
    
}
