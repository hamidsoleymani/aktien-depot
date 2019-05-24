package com.boostmedia.aktiendepot.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AktieTest {

    EntityManagerFactory emf;
    EntityManager em;

    @BeforeEach
    public void setUp(){
         emf = Persistence.createEntityManagerFactory("aktienDepotPU");
         em = emf.createEntityManager();
    }

    @Test
    public void testt(){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Aktie facc = new Aktie("12345","FACC", 2000, LocalDateTime.now(), 16.66f,32000f);
        Dividente dividente2017 = new Dividente(LocalDateTime.now(),.14f,234f, 20.0f);
        //dividente2017.setId(1l);
        facc.assiciateWithDividente(dividente2017);

        em.persist(facc);
        em.persist(dividente2017);

        transaction.commit();
        Aktie notFound = em.find(Aktie.class, "12");
        Aktie found = em.find(Aktie.class, "12345");
        assertNull(notFound);
        assertNotNull(found);
    }

}