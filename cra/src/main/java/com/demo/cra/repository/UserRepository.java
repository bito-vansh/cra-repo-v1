package com.demo.cra.repository;

import com.demo.cra.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing UserEntity objects in the database.
 * Extends JpaRepository to provide CRUD operations and other data access functionality.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
