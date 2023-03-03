package com.simpli.learner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="subjects")
public class Subject {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  private String name;
  private String code;

}
