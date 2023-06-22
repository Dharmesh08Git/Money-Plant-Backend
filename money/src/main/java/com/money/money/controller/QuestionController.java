package com.money.money.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.money.money.entity.Questions;
import com.money.money.service.IQuestionService;

@RestController
@RequestMapping(value = "/question")
@CrossOrigin("http://localhost:4200")
public class QuestionController {
    
    @Autowired
    private IQuestionService questionService;

    @PostMapping(value = "/addQuestion")
    public ResponseEntity<Boolean> addQuestions(@RequestBody Questions questions){
        boolean response = questionService.addQuestion(questions);
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

    @PutMapping(value = "/updateQuestion")
    public ResponseEntity<Boolean> updateQuestions(@RequestBody Questions questions){
        boolean response = questionService.updateQuestion(questions);
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllQuestion")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return new ResponseEntity<List<Questions>>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping(value = "/getAllDraftQuestion")
    public ResponseEntity<List<Questions>> getAllDraftQuestions(){
        return new ResponseEntity<List<Questions>>(questionService.getAllDraftQuestions(), HttpStatus.OK);
    }

    @GetMapping(value = "/getQuestionById/{id}")
    public ResponseEntity<Questions> getQuestionById(@PathVariable int id){
        return new ResponseEntity<Questions>(questionService.getQuestionById(id), HttpStatus.OK);
    }
}
