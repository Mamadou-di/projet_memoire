package smartfx.project.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import smartfx.project.Exception.DAOException;
import smartfx.project.dao.Dao;
import smartfx.project.dao.Idao;
import smartfx.project.models.User;

public class AdminService implements Idao<User>{

	@Override
	public void create(User user) throws DAOException {

		try(Connection connection =Dao.getConnection()){

			String 	query = "insert into user(login,password) values(?,?)";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, user.getLogin());
			ps.setString(2,user.getPassword());
			ps.executeUpdate();

		}catch(Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public User read(int id) throws DAOException {
		try(Connection connection = Dao.getConnection()) {
			String query = "select * from user where id=?";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.first()) {
				String login=rs.getString("login");
				String password=rs.getString("password");
				User user=new User(login,password);
				return user;

			}
			return null;	

		}catch(Exception e ) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<User> list() throws DAOException {
		List<User>users=new ArrayList<User>();
		try(Connection connection=Dao.getConnection()){
			String query="select all from  user";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				String login=rs.getString("login");
				String password=rs.getString("password");
				User user=new User(login,password);
				users.add(user);
			}

			return users;
		}catch(Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void update(User user) throws DAOException {
		// TODO Auto-generated method stub
		try (Connection connection=Dao.getConnection()){
			String query="Update user set login=?,password=? where id =?";
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, user.getLogin());
			ps.setString(2,user.getPassword());
			ps.setInt(3, user.getId());
			ps.executeUpdate();

		}catch(Exception e) {
			throw new DAOException(e.getMessage());

		}

	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		try (Connection connection = Dao.getConnection()) {
			String query = "Delete From user Where id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}





}
