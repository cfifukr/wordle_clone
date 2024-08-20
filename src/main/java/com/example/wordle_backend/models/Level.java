package com.example.wordle_backend.models;

public enum Level {
    A1("Beginner/Elementary"),
    A2("Pre Intermediate"),
    B1("Intermediate"),
    B2("Upper Intermediate"),
    C1("Advanced"),
    C2("Proficient");
    private String level;

    private Level(String name){
        this.level = name;
    }

    public String getName(){
        return this.level;
    }
}
