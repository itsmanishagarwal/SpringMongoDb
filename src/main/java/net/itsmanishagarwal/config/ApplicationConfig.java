package net.itsmanishagarwal.config;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import net.itsmanishagarwal.controller.UserController;
import net.itsmanishagarwal.repository.UserRepositoryImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * @author manish
 */
@Configuration
@ComponentScan(basePackageClasses = {
    UserController.class, UserRepositoryImpl.class
})
@EnableMongoRepositories
@EnableWebMvc
public class ApplicationConfig extends AbstractMongoConfiguration {

  @Override
  public @Bean
  Mongo mongo() throws UnknownHostException {
    return new MongoClient("localhost");
  }

  @Override
  protected String getDatabaseName() {
    return "database";
  }

  @Bean
  protected MappingJackson2HttpMessageConverter getMappingJacksonHttpMessageConverter() {
    return new MappingJackson2HttpMessageConverter();
  }

  @Bean
  protected RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
    RequestMappingHandlerAdapter rmha = new RequestMappingHandlerAdapter();
    List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
    converters.add(getMappingJacksonHttpMessageConverter());
    rmha.setMessageConverters(converters);
    return rmha;
  }
}
