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
@Entity(name = "classes")
public class Classes {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  private String teacher;
  private String time;
  private String subject;
  private int section;
}
