package ch.etmles.makelist.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TierList {

    private @Id
    @GeneratedValue Long id;
    private String title;

    public TierList(){}

    public TierList(String title){
        this.setTitle(title);
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
