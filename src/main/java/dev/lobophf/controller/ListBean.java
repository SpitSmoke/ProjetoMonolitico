package dev.lobophf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.annotation.PostConstruct;

import dev.lobophf.dao.UserDAO;
import dev.lobophf.domain.User;

@Named
@ViewScoped
public class ListBean implements Serializable {
  private static final long serialVersionUID = 1L;

  private UserDAO dao;
  private User user;
  private List<User> users;

  @PostConstruct
  public void init() throws Exception {
    dao = new UserDAO();
    user = new User();
    users = dao.searchAll();
  }

  public List<User> getList() throws Exception {
    return users;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void delete(User user) throws Exception {
    dao.remove(user);
    users.remove(user);
  }

}
