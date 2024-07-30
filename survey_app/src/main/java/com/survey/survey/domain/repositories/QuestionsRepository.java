package com.survey.survey.domain.repositories;


import com.survey.survey.entities.Questions;
import org.springframework.data.repository.CrudRepository;

public interface QuestionsRepository extends CrudRepository<Questions, Long> {
}
