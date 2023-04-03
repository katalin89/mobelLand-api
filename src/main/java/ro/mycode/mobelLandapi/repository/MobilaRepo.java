package ro.mycode.mobelLandapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.mobelLandapi.model.Mobila;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MobilaRepo extends JpaRepository<Mobila, Long> {
    @Query("select distinct p.denumire from Mobila  p")
    List<String> getAllDenumiri();

    @Query("select m from Mobila m where m.denumire = ?1")
    List<Mobila> getAllMobilaByDenumire(String denumire);

    @Transactional
    @Modifying
    @Query("delete from Mobila  m where m.denumire like ?1")
    void deleteMobilaByDenumire(String denumire);

    @Transactional
    @Modifying
    @Query("delete from Mobila m where m.id=?1")
    void deleteById(int id);

    Mobila findMobilaByDenumire(String denumire);

    Mobila fintMobilaById(Long id);


    @Transactional
    @Modifying
    @Query("select  distinct  m from Mobila m order by m.denumire")
    List<Mobila>sortByDenumire();

    @Transactional
    @Modifying
    @Query("select distinct m from Mobila m order by m.material")
    List<Mobila>sortByMaterial();

    @Transactional
    @Modifying
    @Query("select distinct m from Mobila m order by m.culoare")
    List<Mobila>sortByCulare();

    @Transactional
    @Modifying
    @Query("select  distinct m from Mobila m order by m.pret")
    List<Mobila>sortByPret();

    @Transactional
    @Modifying
    @Query("select m from Mobila m where m.denumire=?1 and m.material=?2")
    List<Mobila> findMobilaWith(String denumire,String material);



}

/*
    @Query("select  distinct p.marca from Masina  p")
    List<String> getAllMarci();

    @Query("select m  from  Masina m where  m.marca = ?1")//?1 este primul parametru de la List<masina>,daca ar avea 2 parametri am putea scrie si doi

    List<Masina> getAllMasinaByMarca(String marca);
}*/
