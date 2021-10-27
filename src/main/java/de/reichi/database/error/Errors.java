package de.reichi.database.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Errors {

  @JsonProperty
  public final List<String> messages;

  public Errors(List<String> messages) {
    this.messages = messages;
  }
}
