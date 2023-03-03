package com.simpli.learner.controller;

import com.simpli.learner.dao.ClassesDao;
import com.simpli.learner.dao.StudentDao;
import com.simpli.learner.dao.SubjectDao;
import com.simpli.learner.dao.TeacherDao;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/admin")
public class AdminController {

  private final ClassesDao classesDao;
  private final StudentDao studentDao;
  private final SubjectDao subjectDao;
  private final TeacherDao teacherDao;

  @GetMapping("/classes")
  public String getAllClasses(Model model) {
    model.addAttribute("classes", classesDao.findAll());
    return "admin/classes";
  }

  @GetMapping("/students")
  public String findAllStudents(Model model) {
    model.addAttribute("students", studentDao.findAll());
    return "admin/students";
  }

  @GetMapping("/teachers")
  public String findAllTeachers(Model model) {
    model.addAttribute("teachers", teacherDao.findAll());
    return "admin/teachers";
  }

  @GetMapping("/subjects")
  public String findAllSubjects(Model model) {
    model.addAttribute("subjects", subjectDao.findAll());
    return "admin/subjects";
  }

  @GetMapping("/classStudents")
  public String findStudentsInClass(Model model, HttpServletRequest req) {
    try {
      int classId = Integer.parseInt(req.getParameter("id"));
      model.addAttribute("students", studentDao.findStudentsByClass(classId));
      return "admin/students";
    } catch (Exception e) {
      log.error("Exception on findStudentsInClass: ", e);
      return "access-denied";
    }

  }

}
