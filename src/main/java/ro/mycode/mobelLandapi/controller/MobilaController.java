package ro.mycode.mobelLandapi.controller;

import org.springframework.web.bind.annotation.*;
import ro.mycode.mobelLandapi.model.Mobila;
import ro.mycode.mobelLandapi.repository.MobilaRepo;

import java.util.List;

@RestController
@CrossOrigin
public class MobilaController {

    private MobilaRepo mobilaRepo;

    public MobilaController(MobilaRepo mobilaRepo) {
        this.mobilaRepo = mobilaRepo;
    }

    @GetMapping("api/v1/mobile")
    public List<Mobila> getAllMobile() {
        return mobilaRepo.findAll();
    }

    @GetMapping("api/v1/mobile/denumire")
    public List<String> getAllDenumiri() {
        return mobilaRepo.getAllDenumiri();

}

@GetMapping("api/v1/mobile/{denumire}")
public List<Mobila> getAllMobileByDenumire(@PathVariable String denumire){
        return mobilaRepo.getAllMobilaByDenumire(denumire);
        }
    @PostMapping("api/v1/add")
    public  Mobila addMobila(@RequestBody Mobila mobila){
        this.mobilaRepo.save(mobila);

        return mobila;
    }

}


