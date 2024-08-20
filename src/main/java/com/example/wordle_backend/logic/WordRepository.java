package com.example.wordle_backend.logic;


import com.example.wordle_backend.models.Level;
import com.example.wordle_backend.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WordRepository extends JpaRepository<Word, Long> {
    @Query(value = "SELECT * FROM word WHERE level = :level ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Word findRandomWordByLevel(@Param("level") String level);

    @Query(value = "SELECT * FROM word  ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Word findRandomWord();


}
