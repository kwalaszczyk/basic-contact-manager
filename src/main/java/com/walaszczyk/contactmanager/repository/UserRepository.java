package com.walaszczyk.contactmanager.repository;

import com.walaszczyk.contactmanager.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(@Param("email") String email);
}
