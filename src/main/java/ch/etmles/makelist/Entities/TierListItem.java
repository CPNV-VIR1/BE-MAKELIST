package ch.etmles.makelist.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TierListItem {

    private @Id
    @GeneratedValue Long id;
    private String text;
    private Short rank;
    private Long tierListId;

    public TierListItem(){}

    public TierListItem(String text, Long tierListId){
        this.setText(text);
        this.setTierListId(tierListId);
    }

    public TierListItem(String text, Long tierListId, Short rank){
        this.setText(text);
        this.setTierListId(tierListId);
        this.setRank(rank);
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text = text;
    }

    public Short getRank(){
        return this.rank;
    }

    public void setRank(Short rank){
        this.rank = rank;
    }

    public Long getTierListId(){
        return this.tierListId;
    }

    public void setTierListId(Long tierListId){
        this.tierListId = tierListId;
    }
}
