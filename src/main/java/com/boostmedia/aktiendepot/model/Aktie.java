package com.boostmedia.aktiendepot.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "wkn")
public class Aktie implements Serializable {

    @Id
    private String wkn;
    private String name;
    private int anzahl;
    private LocalDateTime kaufdatum;
    private LocalDateTime verkaufdatum;
    private float kaufpreis;
    private float kaufpreistotal;
    private float verkaufpreis;
    private float verkaufpreistotal;
    private float gewinnproaktie;
    private float gewinntotal;

    //@JsonManagedReference
    @OneToMany(mappedBy = "aktie")
    private Set<Dividente> dividente = new HashSet<Dividente>();

    public Aktie(){}

    public Aktie(String wkn, String name, int anzahl, LocalDateTime kaufDatum,float kaufPreis,float kaufPreisTotal ){
        this.wkn = wkn;
        this.name = name;
        this.anzahl = anzahl;
        this.kaufdatum = kaufDatum;
        this.kaufpreis = kaufPreis;
        this.kaufpreistotal = kaufPreisTotal;
        this.gewinnproaktie = 0f;
        this.gewinntotal = 0f;
        this.verkaufpreis = 0f;
        this.verkaufpreistotal = 0f;
        this.verkaufdatum = null;
    }


    public void assiciateWithDividente(final Dividente dividente2017) {
        dividente.add(dividente2017);
        dividente2017.setAktie(this);
    }

    public String getWkn() {
        return wkn;
    }

    public void setWkn(String wkn) {
        this.wkn = wkn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public LocalDateTime getKaufdatum() {
        return kaufdatum;
    }

    public void setKaufdatum(LocalDateTime kaufdatum) {
        this.kaufdatum = kaufdatum;
    }

    public LocalDateTime getVerkaufdatum() {
        return verkaufdatum;
    }

    public void setVerkaufdatum(LocalDateTime verkaufdatum) {
        this.verkaufdatum = verkaufdatum;
    }

    public float getKaufpreis() {
        return kaufpreis;
    }

    public void setKaufpreis(float kaufpreis) {
        this.kaufpreis = kaufpreis;
    }

    public float getKaufpreistotal() {
        return kaufpreistotal;
    }

    public void setKaufpreistotal(float kaufpreistotal) {
        this.kaufpreistotal = kaufpreistotal;
    }

    public float getVerkaufpreis() {
        return verkaufpreis;
    }

    public void setVerkaufpreis(float verkaufpreis) {
        this.verkaufpreis = verkaufpreis;
    }

    public float getVerkaufpreistotal() {
        return verkaufpreistotal;
    }

    public void setVerkaufpreistotal(float verkaufpreistotal) {
        this.verkaufpreistotal = verkaufpreistotal;
    }

    public float getGewinnproaktie() {
        return gewinnproaktie;
    }

    public void setGewinnproaktie(float gewinnproaktie) {
        this.gewinnproaktie = gewinnproaktie;
    }

    public float getGewinntotal() {
        return gewinntotal;
    }

    public void setGewinntotal(float gewinntotal) {
        this.gewinntotal = gewinntotal;
    }

    public Set<Dividente> getDividente() {
        return dividente;
    }

    public void setDividente(Set<Dividente> dividente) {
        this.dividente = dividente;
    }



    public boolean equals(Object o){
        Aktie other = (Aktie)o;
        if(this.wkn.equals(other.getWkn())){
            return true;
        }
        return false;
    }

    public int hashCode(){
       return this.wkn.hashCode();
    }
}
