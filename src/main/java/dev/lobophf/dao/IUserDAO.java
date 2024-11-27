package dev.lobophf.dao;

import java.util.List;
import java.util.Optional;

import dev.lobophf.domain.User;

public interface IUserDAO {

	public Integer register(User user) throws Exception;

	public Integer remove(User user) throws Exception;
  
	public List<User> searchAll() throws Exception;

  public Optional<User> search(String telephone) throws Exception;

}
