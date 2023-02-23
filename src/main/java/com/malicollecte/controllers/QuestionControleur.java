package com.malicollecte.controllers;

import com.malicollecte.Services.QuestionService;
import com.malicollecte.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600, allowCredentials="true")
public class QuestionControleur {

    @Autowired
    QuestionService questionService;


    @GetMapping("/byquestionnaire/{questionnaireId}")
    public ResponseEntity<List<Question>> getQuestionsByQuestionnaireId(@PathVariable Long questionnaireId) {
        List<Question> questions = questionService.getQuestionsByQuestionnaireId(questionnaireId);
        return ResponseEntity.ok().body(questions);
    }

}
