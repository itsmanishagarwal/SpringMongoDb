package net.itsmanishagarwal.repository;

import java.util.List;

import net.itsmanishagarwal.model.User;

import org.springframework.data.repository.Repository;

/**
 * @author manish
 */
public interface UserRepository extends Repository<User, Long> {

  List<User> findByName(String name);

  List<User> findByAge(Long age);

  List<User> findAll();
}
