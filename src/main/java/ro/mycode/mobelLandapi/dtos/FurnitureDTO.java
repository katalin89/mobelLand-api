package ro.mycode.mobelLandapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FurnitureDTO {
    private  String denumire="";

    private String culoare="";

    private String material="";

    private  int pret=0;

}
