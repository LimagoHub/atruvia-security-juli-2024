package org.example.simplesecurity.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    @Query("select distinct u from User u left join fetch  u.roles   where u.username = :id")
    Optional<User> findUserByIdWithRoles(String id);
}
