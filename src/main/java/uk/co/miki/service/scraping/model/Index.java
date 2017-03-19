/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.miki.service.scraping.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
/**
 *
 * @author darongpon
 */
public class Index {
    @Id
    public String id;
    private String index;
    private String last;
    private String date;
    private String create_date;
    
    public Index() {}
    
    public Index(String index, String last,String date,String create_date) {
            this.index = index;
            this.last = last;
            this.date = date;
            this.create_date = create_date;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
    
    @Override
    public String toString() {
        return "Index{" +
                "index='" + index + '\'' +
                ", last='" + last + '\'' +
                ", date='" + date + '\'' +
                ", create_date='" + create_date + '\'' +
                '}';
    }
}
