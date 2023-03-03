package com.simpli.learner.dao;

import com.simpli.learner.model.Subject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends JpaRepository<Subject, Integer> {

}
