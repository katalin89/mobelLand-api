package ro.mycode.mobelLandapi.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ro.mycode.mobelLandapi.dtos.FurnitureDTO;
import ro.mycode.mobelLandapi.exceptii.ExceptionFurnitureDBEmpty;
import ro.mycode.mobelLandapi.exceptii.ExistingFurniture;
import ro.mycode.mobelLandapi.exceptii.FornitureNotFoundException;
import ro.mycode.mobelLandapi.model.Mobila;
import ro.mycode.mobelLandapi.repository.MobilaRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MobilaService {

    private MobilaRepo mobilaRepo;

    public MobilaService(MobilaRepo mobilaRepo) {
        this.mobilaRepo = mobilaRepo;
    }

    public List<Mobila> getAllMobile() throws ExceptionFurnitureDBEmpty {
        List<Mobila> mobila = mobilaRepo.findAll();

        if (mobila.size() > 0) {
            return mobila;
        }

        throw new ExceptionFurnitureDBEmpty();

    }

    public void deleteMobilaByDenumire(String denumire) throws FornitureNotFoundException {
        Mobila byDenumire = mobilaRepo.findMobilasByDenumire(denumire);
        if (byDenumire != null) {
            mobilaRepo.deleteMobilaByDenumire(denumire);
        } else {
            throw new FornitureNotFoundException();
        }
    }

    @Transactional
    @Modifying

    public  void addMobila(Mobila mobila) throws FornitureNotFoundException{
        List<Mobila> mobilaWith=mobilaRepo.findMobilaWith(mobila.getDenumire(), mobila.getMaterial());
         if (mobilaWith.size()>0){
             throw  new ExistingFurniture();
         }

         this.mobilaRepo.saveAndFlush(mobila);
    }

    @Transactional
    @Modifying

    public  void update(@RequestBody FurnitureDTO mobila,String denumire) throws FornitureNotFoundException{
        Mobila m=mobilaRepo.findMobilasByDenumire(mobila.getDenumire());

        if(m==null){
            throw  new FornitureNotFoundException();
        }

        if(mobila.getDenumire().equals("")==false){
            m.setDenumire(mobila.getDenumire());
        }

        if(mobila.getCuloare().equals("")==false){
            m.setCuloare(mobila.getCuloare());
        }
        if(mobila.getMaterial().equals("")==false){
            m.setMaterial(mobila.getMaterial());
        }

        if(mobila.getPret()!=0){
            m.setPret(mobila.getPret());
        }
    }
}
