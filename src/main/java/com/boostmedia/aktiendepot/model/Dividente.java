package com.boostmedia.aktiendepot.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Dividente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dividentendatum;
    private float dividenteproaktie;
    private float dividentetotal;
    private float steuerabgaben;
    //@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aktie_id")
    private Aktie aktie;

    public Dividente(){}


    public Dividente(LocalDateTime dividentenDatum, float dividenteProAktie, float dividenteTotal, float steuerAbgaben) {
        this.dividentendatum = dividentenDatum;
        this.dividenteproaktie = dividenteProAktie;
        this.dividentetotal = dividenteTotal;
        this.steuerabgaben = steuerAbgaben;
    }

    public boolean equals(Object o){
        Dividente other =(Dividente) o;
        if(this.id == other.id){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return Objects.hashCode(dividentendatum);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDividentendatum() {
        return dividentendatum;
    }

    public void setDividentendatum(LocalDateTime dividentendatum) {
        this.dividentendatum = dividentendatum;
    }

    public float getDividenteproaktie() {
        return dividenteproaktie;
    }

    public void setDividenteproaktie(float dividenteproaktie) {
        this.dividenteproaktie = dividenteproaktie;
    }

    public float getDividentetotal() {
        return dividentetotal;
    }

    public void setDividentetotal(float dividentetotal) {
        this.dividentetotal = dividentetotal;
    }

    public float getSteuerabgaben() {
        return steuerabgaben;
    }

    public void setSteuerabgaben(float steuerabgaben) {
        this.steuerabgaben = steuerabgaben;
    }

    public Aktie getAktie() {
        return aktie;
    }

    public void setAktie(Aktie aktie) {
        this.aktie = aktie;
    }
}
