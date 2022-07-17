package jpabook.jpashop.domain;

import javax.persistence.Entity;

@Entity
public class Book extends Item {

    private String author;
    private String jsbn;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getJsbn() {
        return jsbn;
    }

    public void setJsbn(String jsbn) {
        this.jsbn = jsbn;
    }
}
