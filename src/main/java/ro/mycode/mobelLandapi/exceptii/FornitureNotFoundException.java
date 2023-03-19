package ro.mycode.mobelLandapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.mobelLandapi.constants.Constants.FURNITURE_NOT_FOUND_EXCEPTION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FornitureNotFoundException  extends RuntimeException{

    public FornitureNotFoundException(){
        super(FURNITURE_NOT_FOUND_EXCEPTION);
    }
}
