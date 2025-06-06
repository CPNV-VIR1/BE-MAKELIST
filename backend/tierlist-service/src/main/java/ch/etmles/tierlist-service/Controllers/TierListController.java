package ch.etmles.tierlistservice.Controllers;

import org.springframework.web.bind.annotation.*;

import ch.etmles.tierlistservice.Entities.TierList;
import ch.etmles.tierlistservice.Repositories.TierListRepository;
import ch.etmles.tierlistservice.clients.TierListItemClient;
import ch.etmles.tierlistservice.dtos.TierListItemDTO;
import ch.etmles.tierlistservice.dtos.TierListResponse;

import java.util.List;

@RestController
public class TierListController {

    private final TierListRepository repository;
    private final TierListItemClient tierListItemClient;

    TierListController(TierListRepository repository, TierListItemClient tierListItemClient){
        this.repository = repository;
        this.tierListItemClient = tierListItemClient;
    }

    /* curl sample :
    curl -i localhost:8000/api/tierlists
    */
    @GetMapping("/tierlists")
    List<TierList> all(){
        return repository.findAll();
    }

    /* curl sample :
    curl -i -X POST localhost:8000/api/tierlists ^
        -H "Content-type:application/json" ^
        -d "{\"title\": \"Awesome tier list!\"}"
    */
    @PostMapping("/tierlists")
    TierList newTierList(@RequestBody TierList newTierList){
        return repository.save(newTierList);
    }

    /* curl sample :
    curl -i localhost:8000/api/tierlists/1
    */
    @GetMapping("/tierlists/{id}")
    public TierListResponse one(@PathVariable Long id){
        TierList tierList = repository.findById(id)
                .orElseThrow(() -> new TierListNotFoundException(id));
        
        List<TierListItemDTO> items = tierListItemClient.getItemsForTierList(id);

        return new TierListResponse(tierList.getId(), tierList.getTitle(), items);
    }

    /* curl sample :
    curl -i -X PUT localhost:8000/api/tierlists/2 ^
        -H "Content-type:application/json" ^
        -d "{\"title\": \"My updated tier list!\"}"
     */
    @PutMapping("/tierlists/{id}")
    TierList updateTierList(@RequestBody TierList newTierList, @PathVariable Long id) {
        return repository.findById(id)
                .map(tierList -> {
                    tierList.setTitle(newTierList.getTitle());
                    return repository.save(tierList);
                })
                .orElseGet(() -> {
                    newTierList.setId(id);
                    return repository.save(newTierList);
                });
    }

    /* curl sample :
    curl -i -X DELETE localhost:8000/api/tierlists/2
    */
    @DeleteMapping("/tierlists/{id}")
    void deleteTierList(@PathVariable Long id){
        repository.deleteById(id);
    }
}
