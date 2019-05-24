package com.boostmedia.aktiendepot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Aktie implements Serializable {

    @Id
    private String wkn;
    private String name;
    private int anzahl;
    private LocalDateTime kaufDatum;
    private LocalDateTime verkaufDatum;
    private float kaufPreis;
    private float kaufPreisTotal;
    private float verkaufPreis;
    private float verkaufPreisTotal;
    private float gewinnProAktie;
    private float gewinnTotal;
    @OneToMany(mappedBy = "aktie")
    private Set<Dividente> dividente = new HashSet<Dividente>();
    private float aktuellerPreis;

    public Aktie(){}

    public Aktie(String wkn, String name, int anzahl, LocalDateTime kaufDatum,float kaufPreis,float kaufPreisTotal ){
        this.wkn = wkn;
        this.name = name;
        this.anzahl = anzahl;
        this.kaufDatum = kaufDatum;
        this.kaufPreis = kaufPreis;
        this.kaufPreisTotal = kaufPreisTotal;
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

    public LocalDateTime getKaufDatum() {
        return kaufDatum;
    }

    public void setKaufDatum(LocalDateTime kaufDatum) {
        this.kaufDatum = kaufDatum;
    }

    public LocalDateTime getVerkaufDatum() {
        return verkaufDatum;
    }

    public void setVerkaufDatum(LocalDateTime verkaufDatum) {
        this.verkaufDatum = verkaufDatum;
    }

    public float getKaufPreis() {
        return kaufPreis;
    }

    public void setKaufPreis(float kaufPreis) {
        this.kaufPreis = kaufPreis;
    }

    public float getKaufPreisTotal() {
        return kaufPreisTotal;
    }

    public void setKaufPreisTotal(float kaufPreisTotal) {
        this.kaufPreisTotal = kaufPreisTotal;
    }

    public float getVerkaufPreis() {
        return verkaufPreis;
    }

    public void setVerkaufPreis(float verkaufPreis) {
        this.verkaufPreis = verkaufPreis;
    }

    public float getVerkaufPreisTotal() {
        return verkaufPreisTotal;
    }

    public void setVerkaufPreisTotal(float verkaufPreisTotal) {
        this.verkaufPreisTotal = verkaufPreisTotal;
    }

    public float getGewinnProAktie() {
        return gewinnProAktie;
    }

    public void setGewinnProAktie(float gewinnProAktie) {
        this.gewinnProAktie = gewinnProAktie;
    }

    public float getGewinnTotal() {
        return gewinnTotal;
    }

    public void setGewinnTotal(float gewinnTotal) {
        this.gewinnTotal = gewinnTotal;
    }

    public Set<Dividente> getDividente() {
        return dividente;
    }

    public void setDividente(Set<Dividente> dividente) {
        this.dividente = dividente;
    }

    public float getAktuellerPreis() {
        return aktuellerPreis;
    }

    public void setAktuellerPreis(float aktuellerPreis) {
        this.aktuellerPreis = aktuellerPreis;
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
