package ro.mycode.mobelLandapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.mobelLandapi.dtos.FurnitureDTO;
import ro.mycode.mobelLandapi.model.Mobila;
import ro.mycode.mobelLandapi.service.MobilaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/mobila")
@CrossOrigin
public class MobilaResurce {

    private MobilaService mobilaService;

    public MobilaResurce(MobilaService mobilaService){

        this.mobilaService=mobilaService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Mobila>> getAllMobile(){
        List<Mobila>allMobile=mobilaService.getAllMobile();
        return  new ResponseEntity<>(allMobile,HttpStatus.OK);
    }
    @DeleteMapping("/deleteByDenumire/{denumire}")
    ResponseEntity deleteByDenumire(@PathVariable String denumire){
        this.mobilaService.deleteMobilaByDenumire(denumire);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteById(@PathVariable Long id){
        this.mobilaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public  ResponseEntity addMobila(@RequestBody Mobila mobila){
        mobilaService.addMobila(mobila);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity update(@Valid @RequestBody FurnitureDTO mobila,String denumire){
        this.mobilaService.update(mobila,denumire);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/sortByDenumire")
    public List<Mobila>sortByDenumire(){
        return mobilaService.sortByDenumire();
    }

    @GetMapping("/sortByCuloare")
    public List<Mobila>sortByCuloare(){
        return mobilaService.sortByCuloare();
    }

    @GetMapping("/Material")
    public List<Mobila>sortByMaterial(){
        return  mobilaService.sortByMaterial();
    }

    @GetMapping
    public List<Mobila>sortByPret(){
        return mobilaService.sortByPret();
    }

}
