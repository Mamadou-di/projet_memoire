package smartfx.project.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import smartfx.project.Exception.DAOException;
import smartfx.project.dao.Dao;
import smartfx.project.dao.Idao;
import smartfx.project.models.Facture;

public class BillingService implements Idao<Facture>{

	@Override
	public void create(Facture facture) throws DAOException {

		try(Connection connection =Dao.getConnection()){

			String 	query = "insert into facture(libelle,nom_client,prenom_client,quantite,prix_unitaire,total,date) values(?,?,?,?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, facture.getLibelle());
			ps.setString(2,facture.getNom());
			ps.setString(3, facture.getPrenom());
			ps.setDouble(4,facture.getQuantite());
			ps.setInt(5, facture.getPrix_unitaire());
			ps.setInt(6,facture.getTotal());
			ps.setString(7, facture.getDate());


			ps.executeUpdate();

		}catch(Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Facture read(int id) throws DAOException {
		try(Connection connection = Dao.getConnection()) {
			String query = "select * from facture where id=?";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.first()) {
				String libelle=rs.getString("libelle");
				String nom_client=rs.getString("nom_client");
				String prenom_client=rs.getString("prenom_client");
				double quantite=rs.getDouble("quantite");
				int prix_unitaire=rs.getInt("prix_unitaire");
				int total=rs.getInt("total");
				String date=rs.getString("date");

				Facture facture=new Facture(libelle,nom_client,prenom_client,quantite,prix_unitaire,total,date);

				return facture;

			}
			return null;	

		}catch(Exception e ) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<Facture> list() throws DAOException {
		List<Facture>factures=new ArrayList<Facture>();
		try(Connection connection=Dao.getConnection()){
			String query="select all from  facture";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String libelle=rs.getString("libelle");
				String nom_client=rs.getString("nom_client");
				String prenom_client=rs.getString("prenom_client");
				double quantite=rs.getDouble("quantite");
				int prix_unitaire=rs.getInt("prix_unitaire");
				int total=rs.getInt("total");
				String date=rs.getString("date");

				Facture facture=new Facture(libelle,nom_client,prenom_client,quantite,prix_unitaire,total,date);

				factures.add(facture);
			}

			return factures;
		}catch(Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void update(Facture facture) throws DAOException {
		// TODO Auto-generated method stub
		try (Connection connection=Dao.getConnection()){
			String query="Update facture set login=?,password=? where id =?";
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, facture.getLibelle());
			ps.setString(2,facture.getNom());
			ps.setString(3, facture.getPrenom());
			ps.setDouble(4,facture.getQuantite());
			ps.setInt(5, facture.getPrix_unitaire());
			ps.setInt(6,facture.getTotal());
			ps.setString(7, facture.getDate());
			ps.executeUpdate();

		}catch(Exception e) {
			throw new DAOException(e.getMessage());

		}

	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		try (Connection connection = Dao.getConnection()) {
			String query = "Delete From facture Where id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}


}
