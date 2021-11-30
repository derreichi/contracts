package de.reichi.database.repository;

import de.reichi.database.entity.Jokes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JokesRepositories extends JpaRepository<Jokes, Long> {

}
