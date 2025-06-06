package ch.etmles.makelist.dtos;

import java.util.List;

public class TierListResponse {
    private Long id;
    private String title;
    private List<TierListItemDTO> items;

    public TierListResponse(Long id, String title, List<TierListItemDTO> items) {
        this.id = id;
        this.title = title;
        this.items = items;
    }

    public Long getId(){
        return id; 
    }

    public String getTitle(){
        return title;
    }
    public List<TierListItemDTO> getItems(){
        return items;
    }
}
