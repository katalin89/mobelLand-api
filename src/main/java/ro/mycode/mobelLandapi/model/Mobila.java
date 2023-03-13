package ro.mycode.mobelLandapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

//        text+=id+","+denumire+","+culoare+","+material+","+pret;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Mobila")//creaza o table in baza de data
@Table(name="mobile")

public class Mobila implements  Comparable<Mobila> {

    @Id
    @SequenceGenerator(name="mobila_sequence",sequenceName = "mobila_sequence",allocationSize  =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "mobila_sequence")

    private Long id;

    @Column(name="denumire",nullable=false)
    @Size(min=4,message = "Trebuie sa fie min 4 caractere")
    private String denumire;

    @Column(name="culoare",nullable = false)
    @Size(max=10,message = "Cularea nu poate fi mai lung decat 10 caractere")
    private String culoare;

    @Column(name="material",nullable = false)
    @Size(min=2,message = "Materialul trebuie sa aiba min 2 caractere")
    private String material;

    @Column
    @Max(value=10000,message = "Pretul Nu poate fi mai mare decat 10000")
    private int pret;


    @Override
    public int compareTo(Mobila o) {
     if(this.material.compareTo(o.material)>0){
         return 1;
     }

     if(this.material.compareTo(o.material)<0){
         return  -1;
     }else


        return 0;
    }

    @Override
    public  boolean equals(Object o){
        Mobila mobila=(Mobila)o;
        return  this.material.equals(mobila.material);
    }
}

