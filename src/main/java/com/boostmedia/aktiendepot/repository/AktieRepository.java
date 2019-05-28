package com.boostmedia.aktiendepot.repository;
import org.springframework.data.repository.CrudRepository;
import com.boostmedia.aktiendepot.model.Aktie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AktieRepository extends CrudRepository<Aktie, String> {

    List<Aktie> findByAnzahl(int anzal);
    List<Aktie> findByName (String name);


}
