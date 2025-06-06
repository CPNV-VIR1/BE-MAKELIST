package ch.etmles.tierlistitemservice.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TierListItem {

    private @Id
    @GeneratedValue Long id;
    private String description;
    private Short ranking;
    private Long tierListId;

    public TierListItem(){}

    public TierListItem(String description, Long tierListId){
        this.setDescription(description);
        this.setTierListId(tierListId);
    }

    public TierListItem(String description, Long tierListId, Short ranking){
        this.setDescription(description);
        this.setTierListId(tierListId);
        this.setRanking(ranking);
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Short getRanking(){
        return this.ranking;
    }

    public void setRanking(Short ranking){
        this.ranking = ranking;
    }

    public Long getTierListId(){
        return this.tierListId;
    }

    public void setTierListId(Long tierListId){
        this.tierListId = tierListId;
    }
}
