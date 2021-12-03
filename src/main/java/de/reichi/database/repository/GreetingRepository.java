package de.reichi.database.repository;

import de.reichi.database.entity.Greeting;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "greetings", path = "greetings")
public interface GreetingRepository extends PagingAndSortingRepository<Greeting, Long> {

  Optional<List<Greeting>> findByMessageContaining(String name);
}
