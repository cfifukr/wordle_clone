package com.example.wordle_backend.models;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String word;

    private String meaning;

    private String advice;

    @Enumerated(value = EnumType.STRING)
    private Level level;

    public Word(Long id, String word, String advice, String meaning, Level level) {
        this.id = id;
        this.word = word;
        this.advice = advice;
        this.level = level;
    }


    public Word(String word, String advice, String meaning, Level level) {
        this.word = word;
        this.advice = advice;
        this.level = level;
    }

    public Word() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "WordObject(" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                ", advice='" + advice + '\'' +
                ", level=" + level +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word word1)) return false;
        return Objects.equals(getId(), word1.getId()) && Objects.equals(getWord(), word1.getWord()) && Objects.equals(getMeaning(), word1.getMeaning()) && Objects.equals(getAdvice(), word1.getAdvice()) && getLevel() == word1.getLevel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWord(), getMeaning(), getAdvice(), getLevel());
    }
}
