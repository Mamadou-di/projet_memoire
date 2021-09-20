package smartfx.project.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import smartfx.project.Exception.DAOException;
import smartfx.project.dao.Dao;
import smartfx.project.dao.Idao;
import smartfx.project.models.Parcelle;

public class LandService implements Idao<Parcelle> {

	@Override
	public void create(Parcelle entity) throws DAOException {
		// TODO Auto-generated method stub
		try(Connection connection=Dao.getConnection()){

			String query="insert into parcelle (nom,nom_culture,superficie) values (?,?,?)";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, entity.getNom());
			ps.setString(2, entity.getNom_culture());
			ps.setDouble(3, entity.getSuperficie());
			ps.executeUpdate();


		}catch(Exception e){
			throw new DAOException (e.getMessage());
		}

	}

	@Override
	public Parcelle read(int id) throws DAOException {
		// TODO Auto-generated method stub
		Parcelle parcelle = null;
		try(Connection connection =Dao.getConnection()){
			String query="select * from parcelle where id=?";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.first()) {
				String nom=rs.getString("nom");
				String nom_culture= rs.getString("nom_culture");
				double superficie=rs.getDouble("superficie");
				parcelle=new Parcelle(nom,nom_culture,superficie);

			}
			return parcelle;
		}catch(Exception e ) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public List<Parcelle> list() throws DAOException {
		// TODO Auto-generated method stub
		List <Parcelle> parcelles =new ArrayList<>();
		Parcelle parcelle;
		try(Connection connection =Dao.getConnection()){
			String query="select * from parcelle ";
			PreparedStatement ps =connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				String nom=rs.getString("nom");
				String nom_culture= rs.getString("nom_culture");
				double superficie=rs.getDouble("superficie");
				parcelle=new Parcelle(nom,nom_culture,superficie);
				parcelles.add(parcelle);

			}
			return parcelles;
		}catch(Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public void update(Parcelle entity) throws DAOException {
		// TODO Auto-generated method stub
		try(Connection connection=Dao.getConnection()){
			String query="Update parcelle set (nom,nom_culture,superficie)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNom());
			ps.setString(2, entity.getNom_culture());
			ps.setDouble(3, entity.getSuperficie());
			ps.executeUpdate();

		}catch(Exception e ) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		try (Connection connection = Dao.getConnection()) {
			String query = "Delete From parcelle Where id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

}
