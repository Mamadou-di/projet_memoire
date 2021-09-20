package smartfx.project.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import smartfx.project.Exception.DAOException;
import smartfx.project.dao.Dao;
import smartfx.project.dao.Idao;
import smartfx.project.models.Farmer;

public class FarmService implements Idao<Farmer> {

	@Override
	public void create(Farmer entity) throws DAOException {
		// TODO Auto-generated method stub

		try(Connection connection=Dao.getConnection()){

			String query="insert into farmer (nom,prenom,login,password,telephone,adresse) values (?,?,?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, entity.getNom());
			ps.setString(2, entity.getPrenom());
			ps.setString(3, entity.getLogin());
			ps.setString(4, entity.getPassword());
			ps.setInt(5, entity.getTelephone());
			ps.setString(6, entity.getAdresse());
			ps.executeUpdate();


		}catch(Exception e){
			throw new DAOException (e.getMessage());
		}

	}

	@Override
	public Farmer read(int id) throws DAOException {
		// TODO Auto-generated method stub
		Farmer farmer = null;
		try(Connection connection =Dao.getConnection()){
			String query="select * from farmer join user where id=?";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.first()) {
				String nom=rs.getString("nom");
				String prenom= rs.getString("prenom");
				String adresse=rs.getString("adresse");
				int telephone=rs.getInt("telephone");
				String login=rs.getString("login");
				String pwd=rs.getString("password");
				farmer=new Farmer(nom,prenom,login,pwd,telephone,adresse);

			}
			return farmer;
		}catch(Exception e ) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public List<Farmer> list() throws DAOException {
		// TODO Auto-generated method stub
		List <Farmer> farmers =new ArrayList<>();
		Farmer farmer;
		try(Connection connection =Dao.getConnection()){
			String query="select * from farmer ";
			PreparedStatement ps =connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				String nom=rs.getString("nom");
				String prenom= rs.getString("prenom");
				String adresse=rs.getString("adresse");
				int telephone=rs.getInt("telephone");
				String login=rs.getString("login");
				String pwd=rs.getString("password");
				farmer=new Farmer(nom,prenom,login,pwd,telephone,adresse);
				farmers.add(farmer);
			}
			return farmers;
		}catch(Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public void update(Farmer entity) throws DAOException {
		// TODO Auto-generated method stub
		try(Connection connection=Dao.getConnection()){
			String query="Update farmer set (nom,prenom,adresse,telephone,login,password)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNom());
			ps.setString(2, entity.getPrenom());
			ps.setString(3, entity.getAdresse());
			ps.setInt(4, entity.getTelephone());
			ps.setString(1, entity.getLogin());
			ps.setString(1, entity.getPassword());
			ps.executeUpdate();
			
		}catch(Exception e ) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		try (Connection connection = Dao.getConnection()) {
			String query = "Delete From farmer Where id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}


	}

}
