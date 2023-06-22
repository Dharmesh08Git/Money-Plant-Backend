package com.money.money.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.money.entity.Questions;
import com.money.money.exceptions.QuestionNotFoundException;
import com.money.money.repository.IQuestionRepository;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private IQuestionRepository questionRepository;

    @Override
    public boolean addQuestion(Questions questions) {
        
        Questions questionsSave = questionRepository.save(questions);

        if(questionsSave.getQuestionId() != 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateQuestion(Questions questions) throws QuestionNotFoundException {

        Optional<Questions> questionsOp = questionRepository.findById(questions.getQuestionId());

        if(questionsOp.isPresent()){
            questionRepository.save(questions);
            return true;
        }else{
            throw new QuestionNotFoundException("Question Not Found!!");
        }
    }

    @Override
    public List<Questions> getAllQuestions() throws QuestionNotFoundException {
        
        List<Questions> questionsList = questionRepository.findAll();

        if(questionsList.isEmpty()){
            throw new QuestionNotFoundException("Question Not Found!!");
        }else{
            return questionsList;
        }
        
    }

    @Override
    public List<Questions> getAllDraftQuestions() throws QuestionNotFoundException {
        List<Questions> questionsList = questionRepository.getAllDraftQuestion();

        if(questionsList.isEmpty()){
            throw new QuestionNotFoundException("Question Not Found!!");
        }else{
            return questionsList;
        }
    }

    @Override
    public Questions getQuestionById(int id) throws QuestionNotFoundException {
        Optional<Questions> questionsOp = questionRepository.findById(id);

        if(questionsOp.isPresent()){
            return questionsOp.get();
        }else{
            throw new QuestionNotFoundException("Question Not Found!!");
        }
    }
}
