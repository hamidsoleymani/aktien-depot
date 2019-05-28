package com.boostmedia.aktiendepot.controller;

import com.boostmedia.aktiendepot.model.Aktie;
import com.boostmedia.aktiendepot.model.Dividente;
import com.boostmedia.aktiendepot.model.SearchDTO;
import com.boostmedia.aktiendepot.repository.AktieRepository;
import com.boostmedia.aktiendepot.repository.AktienRepositoryCustom;
import com.boostmedia.aktiendepot.repository.DividenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController

@RequestMapping("/aktie")
public class AktienController {

    private static final Logger logger = LoggerFactory.getLogger(AktienController.class);
    @Autowired
    private AktieRepository aktieRepository;

    @Autowired
    private DividenteRepository dividenteRepository;

    @Autowired
    AktienRepositoryCustom aktienRepositoryCustom;


   @RequestMapping(value="/addd", method=RequestMethod.GET, produces = {"application/json"})
    public Dividente addNewAktie (Aktie aktie) {

        Dividente dividente2017 = new Dividente(LocalDateTime.now(),.14f,234f, 20.0f);
        Dividente dividente2012 = new Dividente(LocalDateTime.now(),.14f,234f, 20.0f);
        //dividente2017.setId(1l);
        Aktie facc = new Aktie("1","FACC", 2000, LocalDateTime.now(), 16.66f,32000f);
        facc.assiciateWithDividente(dividente2017);
        facc.assiciateWithDividente(dividente2012);
        Iterable<Aktie> all = aktieRepository.findAll();
       aktieRepository.save(facc);
        dividenteRepository.save(dividente2017);
        dividenteRepository.save(dividente2012);
       aktienRepositoryCustom.tuple();
       List<Aktie> byAnzahl = aktieRepository.findByAnzahl(2000);
       return dividente2017;
    }


    @RequestMapping(value="/adda", method=RequestMethod.GET, produces = {"application/json"})
    public Aktie addNewAktie2 (Aktie aktie){
        Dividente dividente2017 = new Dividente(LocalDateTime.now(),.14f,234f, 20.0f);
        Dividente dividente2012 = new Dividente(LocalDateTime.now(),.14f,234f, 20.0f);
        //dividente2017.setId(1l);
        Aktie facc = new Aktie("1","FACC", 2000, LocalDateTime.now(), 16.66f,32000f);
        facc.assiciateWithDividente(dividente2017);
        facc.assiciateWithDividente(dividente2012);
        Iterable<Aktie> all = aktieRepository.findAll();
      aktieRepository.save(facc);
        dividenteRepository.save(dividente2017);
        dividenteRepository.save(dividente2012);
        return facc;
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Aktie> getAllUsers() {
        return aktieRepository.findAll();
    }

    @RequestMapping(value="/handle", method=RequestMethod.GET)
    public SearchDTO handleRequest(SearchDTO search) {
        logger.info("criteria: {}" +  search);
        return search;
    }

    @RequestMapping(value="/hamid/sol")
    @ResponseBody
    public String getFooBySimplePath(){
       return  "got some foo";
    }

    @RequestMapping(value= "ex/foos", method= POST)
    public String postFoos(){
       return "Post some foos";
    }

    @RequestMapping(value="ex/foo2", headers="key=val", method = GET)
    public String getFoo(@RequestHeader(value="key") String userAgent){
       return "haeder";
    }

    public String index() {
        return "Greetings from Spring Boot!";
    }
}
