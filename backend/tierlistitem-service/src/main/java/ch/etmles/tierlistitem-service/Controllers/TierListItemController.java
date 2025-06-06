package ch.etmles.tierlistitemservice.Controllers;

import org.springframework.web.bind.annotation.*;

import ch.etmles.tierlistitemservice.Entities.TierListItem;
import ch.etmles.tierlistitemservice.Repositories.TierListItemRepository;

import java.util.List;

@RestController
public class TierListItemController {

    private final TierListItemRepository repository;

    TierListItemController(TierListItemRepository repository){
        this.repository = repository;
    }

    /* curl sample :
    curl -i localhost:8080/tierlists/1/items
    */
    @GetMapping("/tierlists/{id}/items")
    List<TierListItem> all(@PathVariable("id") Long tierListId){
        return repository.findByTierListId(tierListId);
    }
}
