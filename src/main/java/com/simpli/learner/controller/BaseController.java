package com.simpli.learner.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

  @Value("${spring.application.name}")
  String app;

  @RequestMapping(value = {"/admin/dashboard"}, method = RequestMethod.GET)
  public String homePage() {
    return "admin/dashboard";
  }

  @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
  public String login() {
    return "login";
  }

}
