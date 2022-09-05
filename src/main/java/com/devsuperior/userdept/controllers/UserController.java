package com.devsuperior.userdept.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  // Estamos pegando todos os usuários dentro do banco de dados, guardando todos
  // dentro de um "List<User>" de usuários e retornando essa lista.
  @GetMapping
  public List<User> findAll() {
    List<User> result = userRepository.findAll();
    return result;
  }

  // resgatar um usuário pelo seu ID
  @GetMapping(value = "/{id}")
  public User searchUser(@PathVariable Long id) {
    User result = userRepository.findById(id).get();
    return result;
  }

  // Salvar um usuário
  @PostMapping
  public User insert(@RequestBody User user) {
    User result = userRepository.save(user);
    return result;
  }

}
