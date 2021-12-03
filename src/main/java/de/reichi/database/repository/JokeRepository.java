package de.reichi.database.repository;

import de.reichi.database.entity.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface JokeRepository extends JpaRepository<Joke, Long> {

}
