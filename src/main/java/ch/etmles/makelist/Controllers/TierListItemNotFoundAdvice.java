package ch.etmles.makelist.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TierListItemNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TierListItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String TierListItemNotFoundHandler(TierListItemNotFoundException ex){
        return ex.getMessage();
    }
}
