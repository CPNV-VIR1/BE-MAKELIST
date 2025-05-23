package ch.etmles.makelist.Controllers;

import org.springframework.web.bind.annotation.*;

import ch.etmles.makelist.Entities.TierList;
import ch.etmles.makelist.Repositories.TierListRepository;

import java.util.List;

@RestController
public class TierListController {

    private final TierListRepository repository;

    TierListController(TierListRepository repository){
        this.repository = repository;
    }

    /* curl sample :
    curl -i localhost:8080/TierLists
    */
    @GetMapping("/TierLists")
    List<TierList> all(){
        return repository.findAll();
    }

    /* curl sample :
    curl -i -X POST localhost:8080/TierLists ^
        -H "Content-type:application/json" ^
        -d "{\"title\": \"Awesome tier list!\"}"
    */
    @PostMapping("/TierLists")
    TierList newTierList(@RequestBody TierList newTierList){
        return repository.save(newTierList);
    }

    /* curl sample :
    curl -i localhost:8080/TierLists/1
    */
    @GetMapping("/TierLists/{id}")
    TierList one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new TierListNotFoundException(id));
    }

    /* curl sample :
    curl -i -X PUT localhost:8080/TierLists/2 ^
        -H "Content-type:application/json" ^
        -d "{\"title\": \"My updated tier list!\"}"
     */
    @PutMapping("/TierLists/{id}")
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
    curl -i -X DELETE localhost:8080/TierLists/2
    */
    @DeleteMapping("/TierLists/{id}")
    void deleteTierList(@PathVariable Long id){
        repository.deleteById(id);
    }
}
