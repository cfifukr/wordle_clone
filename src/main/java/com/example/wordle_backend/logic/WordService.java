package com.example.wordle_backend.logic;

import com.example.wordle_backend.dtos.WordDto;
import com.example.wordle_backend.models.Level;
import com.example.wordle_backend.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }

    public Word addWord(WordDto wordDto){
        Word word = wordDto.getWordObject();

        return wordRepository.save(word);
    }

    public Word saveOrUpdateWord(Word word){

        return wordRepository.save(word);
    }

    public Word getRandomWord(String level){
        if(level.isEmpty() || level.compareTo("") == 0){
            return wordRepository.findRandomWord();
        }
        return wordRepository.findRandomWordByLevel(
                level.toUpperCase().trim()
        );
    }

}
