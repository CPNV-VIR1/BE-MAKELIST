package ch.etmles.tierlistservice.clients;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import ch.etmles.tierlistservice.dtos.TierListItemDTO;

@Service
public class TierListItemClient {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public TierListItemClient(RestTemplateBuilder builder, @Value("${tierlistitem.service.url}") String baseUrl) {
        this.restTemplate = builder.build();
        this.baseUrl = baseUrl;
    }

    public List<TierListItemDTO> getItemsForTierList(Long tierListId) {
        ResponseEntity<TierListItemDTO[]> response = restTemplate.getForEntity(
            baseUrl + "/tierlists/" + tierListId + "/items",
            TierListItemDTO[].class
        );
        return Arrays.asList(response.getBody());
    }
}
