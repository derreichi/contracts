package de.reichi.database.repository;

import de.reichi.database.entity.Jokes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface JokesRepository extends JpaRepository<Jokes, Long> {

}
