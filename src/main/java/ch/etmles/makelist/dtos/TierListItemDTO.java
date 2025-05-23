package ch.etmles.makelist.dtos;

public class TierListItemDTO {
    private Long id;
    private String text;
    private Long tierListId;
    private Short rank;

    public TierListItemDTO(Long id, String text, Short rank, Long tierListId) {
        this.id = id;
        this.text = text;
        this.tierListId = tierListId;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Long getTierListId() {
        return tierListId;
    }

    public Short getRank() {
        return rank;
    }
}
