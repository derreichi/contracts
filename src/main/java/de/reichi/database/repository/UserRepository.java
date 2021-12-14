package de.reichi.database.repository;

import de.reichi.database.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    /*Optional<List<User>> findByEmail(String email);

    Optional<List<User>> findBySurenameAndFirstname(String surename, String firstname);

    Optional<List<User>> findBySurename(String surename);

    Optional<List<User>> findByFirstname(String firstname);*/
}

