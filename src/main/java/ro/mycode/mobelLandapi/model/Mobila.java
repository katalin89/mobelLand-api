package ro.mycode.mobelLandapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity//creaza o table in baza de data
@Table(name="mobila")
@AllArgsConstructor
@NoArgsConstructor
public class Mobila implements  Comparable<Mobila> {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id

    private long id;
    private String denumire;
    private String culoare;
    private String material;
    private int pret;


    @Override
    public String toString(){
        String text="";
        text+=id+","+denumire+","+culoare+","+material+","+pret;
        return  text;
    }
    @Override
    public int compareTo(Mobila o) {
        return 0;
    }

    public int compare(Object o){
        Mobila mobila=(Mobila) o;
        if(this.pret>mobila.pret){
            return 1;
        }else if(this.pret< mobila.pret){
            return 0;
        }

        return -1;
    }
}

