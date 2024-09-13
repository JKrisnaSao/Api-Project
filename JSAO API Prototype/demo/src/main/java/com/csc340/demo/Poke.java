package com.csc340.demo;

public class Poke {
    public String name;
    public int gIndex;
    public int weight;


    public Poke(String name, int gIndex, int weights){
        this.name=name;
        this.gIndex = gIndex;
        this.weight=weight;

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getgIndex(){
        return gIndex;
    }

    public void setgIndex(int gIndex){
        this.gIndex = gIndex;
    }

    public int getWeight(){
        return weight;
    }

    public void setType(int type){
        this.weight = weight;
    }


}

