package ch.etmles.tierlistitemservice.Controllers;

public class TierListItemNotFoundException extends RuntimeException{

    TierListItemNotFoundException(Long id){
        super("Could not find tierlist item " + id);
    }
}
