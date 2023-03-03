package com.simpli.learner.dao;

import com.simpli.learner.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesDao extends JpaRepository<Classes, Integer> {

}
