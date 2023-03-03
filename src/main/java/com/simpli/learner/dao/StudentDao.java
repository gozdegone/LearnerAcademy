package com.simpli.learner.dao;

import com.simpli.learner.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
  @Query("select s from students s where s.classId = ?1")
  List<Student> findStudentsByClass(int classId);
}
