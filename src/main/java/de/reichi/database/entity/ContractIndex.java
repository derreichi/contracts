package de.reichi.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.Email;

@Document(indexName = "contracts")
@Getter
@Setter
@NoArgsConstructor
public class ContractIndex {

  @Id
  private Long id;

  private String firstname;

  private String surename;

  @Email(regexp = ".+@.+\\..+", message = "An email has to look like an email!!!")
  private String email;

  public ContractIndex(Long id, String firstname, String surename, String email) {
    this.id = id;
    this.firstname = firstname;
    this.surename = surename;
    this.email = email;
  }
}
