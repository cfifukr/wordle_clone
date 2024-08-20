package com.example.wordle_backend.logic;


import com.example.wordle_backend.dtos.WordDto;
import com.example.wordle_backend.models.Word;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Controller
public class WordController {

    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService){
        this.wordService = wordService;
    }

    @GetMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/wordle");
    }

    @GetMapping("/wordle")
    public String playGame(@RequestParam(value = "level", defaultValue = "") String level,
                           Model model){
        System.out.println(level);

        Word word = wordService.getRandomWord(level);
        System.out.println(word);

        model.addAttribute("word", word.getWord());
        model.addAttribute("advice", word.getAdvice());

        return "game";
    }
}
