package com.money.money.service;

import java.util.List;

import com.money.money.entity.Questions;
import com.money.money.exceptions.QuestionNotFoundException;

public interface IQuestionService {
    
    public boolean addQuestion(Questions questions);
    public boolean updateQuestion(Questions questions) throws QuestionNotFoundException;
    public List<Questions> getAllQuestions() throws QuestionNotFoundException;
    public List<Questions> getAllDraftQuestions() throws QuestionNotFoundException;
	Questions getQuestionById(int id) throws QuestionNotFoundException;
}
