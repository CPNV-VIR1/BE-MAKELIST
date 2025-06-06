package ch.etmles.tierlistservice.dtos;

public class TierListItemDTO {
    private Long id;
    private String description;
    private Long tierListId;
    private Short ranking;

    public TierListItemDTO(Long id, String description, Short ranking, Long tierListId) {
        this.id = id;
        this.description = description;
        this.tierListId = tierListId;
        this.ranking = ranking;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Long getTierListId() {
        return tierListId;
    }

    public Short getRanking() {
        return ranking;
    }
}
