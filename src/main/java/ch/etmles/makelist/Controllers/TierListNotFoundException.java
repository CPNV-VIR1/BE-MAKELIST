package ch.etmles.makelist.Controllers;

public class TierListNotFoundException extends RuntimeException{

    TierListNotFoundException(Long id){
        super("Could not find tierlist " + id);
    }
}
