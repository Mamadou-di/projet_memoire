package smartfx.project.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import smartfx.project.Exception.DAOException;
import smartfx.project.dao.Dao;
import smartfx.project.dao.Idao;
import smartfx.project.models.Culture;

public class CultureService implements Idao<Culture> {
	@Override
	public void create(Culture entity) throws DAOException {
		// TODO Auto-generated method stub
		try(Connection connection=Dao.getConnection()){

			String query="insert into culture (nom_culture,quantite,type,rendement) values (?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, entity.getNom());
			ps.setInt(2, entity.getQuantite());
			ps.setString(3, entity.getType());
			ps.setDouble(2, entity.getRendement());
			ps.executeUpdate();


		}catch(Exception e){
			throw new DAOException (e.getMessage());
		}

	}

	@Override
	public Culture read(int id) throws DAOException {
		// TODO Auto-generated method stub
		Culture culture = null;
		try(Connection connection =Dao.getConnection()){
			String query="select * from culture where id=?";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.first()) {
				String nom_culture=rs.getString("nom_culture");
				int quantite= rs.getInt("quantite");
				String type=rs.getString("type");
				double rendement=rs.getDouble("rendement");
				culture=new Culture(nom_culture,quantite,type,rendement);
			}
			return culture;
		}catch(Exception e ) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public List<Culture> list() throws DAOException {
		// TODO Auto-generated method stub
		List <Culture> cultures =new ArrayList<>();
		Culture culture;
		try(Connection connection =Dao.getConnection()){
			String query="select * from culture ";
			PreparedStatement ps =connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				String nom_culture=rs.getString("nom_culture");
				int quantite= rs.getInt("quantite");
				double rendement=rs.getDouble("rendement");
				String type=rs.getString("type");
				culture=new Culture(nom_culture,quantite,type,rendement);
				cultures.add(culture);

			}
			return cultures;
		}catch(Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public void update(Culture entity) throws DAOException {
		// TODO Auto-generated method stub
		try(Connection connection=Dao.getConnection()){
			String query="Update culture set (nom_culture,quantite,type,rendement)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNom());
			ps.setInt(2, entity.getQuantite());
			ps.setString(3, entity.getType());
			ps.setDouble(3, entity.getRendement());
			ps.executeUpdate();

		}catch(Exception e ) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		try (Connection connection = Dao.getConnection()) {
			String query = "Delete From culture Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

}
