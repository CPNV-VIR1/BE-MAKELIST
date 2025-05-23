package ch.etmles.makelist.clients;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ch.etmles.makelist.dtos.TierListItemDTO;

@Service
public class TierListItemClient {
    private final RestTemplate restTemplate;

    public TierListItemClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public List<TierListItemDTO> getItemsForTierList(Long tierListId) {
        ResponseEntity<TierListItemDTO[]> response = restTemplate.getForEntity(
            "http://localhost:8080/tierlists/" + tierListId + "/items",
            TierListItemDTO[].class
        );
        return Arrays.asList(response.getBody());
    }
}
