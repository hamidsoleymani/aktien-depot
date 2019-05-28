package com.boostmedia.aktiendepot.model;

public class SearchDTO {
    private Long id[];

    public Long[] getId() {
        return id;
    }

    public void setId(Long[] id) {
        this.id = id;
    }
    // reflection toString from apache commons
    @Override
    public String toString() {
        return this.id.toString();
    }
}
