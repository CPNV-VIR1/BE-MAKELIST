package ch.etmles.makelist.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TierListNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TierListNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String TierListNotFoundHandler(TierListNotFoundException ex){
        return ex.getMessage();
    }
}
