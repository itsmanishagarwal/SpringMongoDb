package net.itsmanishagarwal;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import net.itsmanishagarwal.model.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;

/**
 * @author manish
 */
public class MongoApp {

  private static final Log log = LogFactory.getLog(MongoApp.class);

  public static void main(String[] args) throws Exception {

    MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "database"));

    // mongoOps.insert(new User("Joe", 34L));

    log.info(mongoOps.findOne(new Query(where("name").is("Joe")), User.class));

    System.out.println(mongoOps.findAll(User.class));
    for (User user : mongoOps.findAll(User.class)) {

      System.out.println(user);
    }
    // mongoOps.dropCollection("person");
  }
}