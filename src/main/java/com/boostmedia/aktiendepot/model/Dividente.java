package com.boostmedia.aktiendepot.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
public class Dividente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dividentenDatum;
    private float dividenteProAktie;
    private float dividenteTotal;
    private float steuerAbgaben;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aktie_id")
    private Aktie aktie;

    public Dividente(){}


    public Dividente(LocalDateTime dividentenDatum, float dividenteProAktie, float dividenteTotal, float steuerAbgaben) {
        this.dividentenDatum = dividentenDatum;
        this.dividenteProAktie = dividenteProAktie;
        this.dividenteTotal = dividenteTotal;
        this.steuerAbgaben = steuerAbgaben;
    }

    public boolean equals(Object o){
        Dividente other =(Dividente) o;
        if(this.id == other.id){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return Objects.hashCode(dividentenDatum);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDividentenDatum() {
        return dividentenDatum;
    }

    public void setDividentenDatum(LocalDateTime dividentenDatum) {
        this.dividentenDatum = dividentenDatum;
    }

    public float getDividenteProAktie() {
        return dividenteProAktie;
    }

    public void setDividenteProAktie(float dividenteProAktie) {
        this.dividenteProAktie = dividenteProAktie;
    }

    public float getDividenteTotal() {
        return dividenteTotal;
    }

    public void setDividenteTotal(float dividenteTotal) {
        this.dividenteTotal = dividenteTotal;
    }

    public float getSteuerAbgaben() {
        return steuerAbgaben;
    }

    public void setSteuerAbgaben(float steuerAbgaben) {
        this.steuerAbgaben = steuerAbgaben;
    }

    public Aktie getAktie() {
        return aktie;
    }

    public void setAktie(Aktie aktie) {
        this.aktie = aktie;
    }
}
