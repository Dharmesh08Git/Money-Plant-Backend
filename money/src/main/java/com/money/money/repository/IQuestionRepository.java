package com.money.money.repository;

import com.money.money.entity.Questions;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IQuestionRepository extends JpaRepository<Questions, Integer> {
  @Query(
    value = "SELECT * FROM questions where is_draft = true",
    nativeQuery = true
  )
  public List<Questions> getAllDraftQuestion();
}