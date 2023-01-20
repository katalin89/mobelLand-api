package ro.mycode.mobelLandapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.mobelLandapi.model.Mobila;

import java.util.List;

@Repository
public interface MobilaRepo extends JpaRepository<Mobila,Long> {
    @Query("select distinct p.denumire from Mobila  p")
    List<String>getAllDenumiri();

    @Query("select m from Mobila m where m.denumire = ?1")
        List<Mobila>getAllMobilaByDenumire(String denumire);



}

/*
    @Query("select  distinct p.marca from Masina  p")
    List<String> getAllMarci();

    @Query("select m  from  Masina m where  m.marca = ?1")//?1 este primul parametru de la List<masina>,daca ar avea 2 parametri am putea scrie si doi

    List<Masina> getAllMasinaByMarca(String marca);
}*/
