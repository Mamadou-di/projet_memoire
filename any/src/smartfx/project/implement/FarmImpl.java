package smartfx.project.implement;
import java.util.List;

import smartfx.project.Exception.DAOException;
import smartfx.project.models.Farmer;
import smartfx.project.service.FarmService;

public class FarmImpl {
	private static FarmService farmService;

	public static void addFarmer(Farmer farm) throws DAOException {
		farmService=new FarmService();
		try {
			farmService.create(farm);
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}
	public static List<Farmer> listFarmers() throws DAOException{
		farmService=new FarmService();

		try {
			List<Farmer> farms=farmService.list();
			return farms;
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}
	public static Farmer readFarmer(int id)throws DAOException{

		farmService=new FarmService();
		return farmService.read(id);
	}
	public static void updateFarmer(Farmer farm) throws DAOException{
		farmService=new FarmService();
		farmService.update(farm);
	}
	public static void deleteFarmer(int id)throws DAOException{


	}
}