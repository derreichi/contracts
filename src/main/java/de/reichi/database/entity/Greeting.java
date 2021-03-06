package de.reichi.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Greeting {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String message;

  public Greeting(String name) {
    this.message = name;
  }
}
