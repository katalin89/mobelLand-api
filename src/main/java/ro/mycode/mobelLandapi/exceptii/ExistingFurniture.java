package ro.mycode.mobelLandapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.mobelLandapi.constants.Constants.FURNITURE_DUPLICATION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExistingFurniture extends  RuntimeException {

    public ExistingFurniture(){
        super(FURNITURE_DUPLICATION);
    }
}
