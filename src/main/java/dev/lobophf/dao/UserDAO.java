package dev.lobophf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.lobophf.dao.jdbc.ConnectionFactory;
import dev.lobophf.domain.TelephoneType;
import dev.lobophf.domain.User;

public class UserDAO implements IUserDAO {

  @Override
  public Integer register(User user) throws Exception {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = ConnectionFactory.getConnection();
      String query = "INSERT INTO tb_user(id, name, telephone, type) VALUES(nextval('sq_user'), ?, ?, ?::telephone_type)";
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, user.getName());
      preparedStatement.setString(2, user.getTelephone());
      preparedStatement.setString(3, user.getTelephoneType().name());
      return preparedStatement.executeUpdate();
    } catch (Exception e) {
      throw e;
    } finally {
      if (preparedStatement != null && !preparedStatement.isClosed()) {
        preparedStatement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }

  @Override
  public Integer remove(User user) throws Exception {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = ConnectionFactory.getConnection();
      String query = "DELETE FROM tb_user WHERE telephone = ?";
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, user.getTelephone());
      return preparedStatement.executeUpdate();
    } catch (Exception e) {
      throw e;
    } finally {
      if (preparedStatement != null && !preparedStatement.isClosed()) {
        preparedStatement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }

  @Override
  public List<User> searchAll() throws Exception {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = ConnectionFactory.getConnection();
      String query = "SELECT * FROM tb_user";
      preparedStatement = connection.prepareStatement(query);
      resultSet = preparedStatement.executeQuery();
      List<User> userList = new ArrayList<User>();

      while (resultSet.next()) {
        User user = new User();
        user.setName(resultSet.getString("name"));
        user.setTelephone(resultSet.getString("telephone"));
        user.setTelephoneType(TelephoneType.valueOf(resultSet.getString("type")));
        userList.add(user);
      }
      return userList;
    } catch (Exception e) {
      throw e;
    } finally {
      if (preparedStatement != null && !preparedStatement.isClosed()) {
        preparedStatement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }

  @Override
  public Optional<User> search(String telephone) throws Exception {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = ConnectionFactory.getConnection();
      String query = "SELECT * FROM tb_user WHERE telephone = ?";
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, telephone);
      resultSet = preparedStatement.executeQuery();
      User user = new User();
      while (resultSet.next()) {
        user.setName(resultSet.getString("name"));
        user.setTelephone(resultSet.getString("telephone"));
        user.setTelephoneType(TelephoneType.valueOf(resultSet.getString("type")));
      }
      if(user.getTelephone() == null) {
        return Optional.empty();
      }
      return Optional.of(user);

    } catch (Exception e) {
      throw e;
    } finally {
      if (preparedStatement != null && !preparedStatement.isClosed()) {
        preparedStatement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }
}
