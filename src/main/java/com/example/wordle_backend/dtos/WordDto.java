package com.example.wordle_backend.dtos;

import com.example.wordle_backend.models.Level;
import com.example.wordle_backend.models.Word;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WordDto {
    private Long id;
    private String word;
    private String meaning;
    private String advice;
    private String level;

    public Word getWordObject(){
        Word word = new Word(this.word,
                this.advice,
                this.meaning,
                Level.valueOf(this.level.trim().toUpperCase()));
        if(this.id != null){
            word.setId(this.id);
        }

        return word;
    }

    public static WordDto getDto(Word word){
        WordDto wordDto = new WordDto();
        wordDto.setId(word.getId());
        wordDto.setWord(word.getWord());
        wordDto.setLevel(word.getLevel().name() + " " +  word.getLevel().getName());
        wordDto.setAdvice(word.getAdvice());
        wordDto.setMeaning(word.getMeaning());

        return wordDto;
    }
}
