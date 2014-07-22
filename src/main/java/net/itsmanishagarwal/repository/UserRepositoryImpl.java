package net.itsmanishagarwal.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import net.itsmanishagarwal.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author manish
 */
@Service
public class UserRepositoryImpl implements UserRepository {

  @Autowired
  private MongoTemplate mongoTemplate;

  public List<User> findByName(String name) {
    return mongoTemplate.find(new Query(where("name").is("Manish")), User.class);
  }
  
  public List<User> findByAge(Long age) {
    return mongoTemplate.find(new Query(where("age").gt(12L)), User.class);
  }

  public List<User> findAll() {
    return mongoTemplate.findAll(User.class);
  }

}
