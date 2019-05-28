package com.boostmedia.aktiendepot.repository;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
public class AktienRepositoryCustom {

    private static final String PERSISTENCE_UNIT_NAME = "aktienDepotPU";
    private static EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();


    public void tuple (){

        TypedQuery<Tuple> q = em.createQuery(
                "SELECT a.wkn as wkn, a.anzahl as anzahl   FROM Aktie a WHERE a.name LIKE :name",
                Tuple.class);
        q.setParameter("name", "%facc%");
        List<Tuple> aktien = q.getResultList();
        for(Tuple t : aktien){
            System.out.println(t.get("wkn"));
            System.out.println(t.get("anzahl"));
        }



    }


}
