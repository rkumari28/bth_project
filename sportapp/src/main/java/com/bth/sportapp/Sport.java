package com.bth.sportapp;

public class Sport {
    private String id;
    private String sportName;
    private String country;
    private int players;
    private String type;

    public Sport() {
    }

    public Sport(String id, String sportName, String country, int players, String type) {
        this.id = id;
        this.sportName = sportName;
        this.country = country;
        this.players = players;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
