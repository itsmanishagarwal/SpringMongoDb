package net.itsmanishagarwal.controller;

import java.util.List;

import net.itsmanishagarwal.model.User;
import net.itsmanishagarwal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author manish
 */
@Controller
@RequestMapping(value = "users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @ResponseBody
  @RequestMapping(value = {
      "/", ""
  })
  public List<User> getUsers() {
    return userRepository.findAll();
  }
}
