package smartfx.project.implement;

import java.util.List;

import smartfx.project.Exception.DAOException;
import smartfx.project.models.Culture;
import smartfx.project.service.CultureService;

public class CultureImpl {
	private static CultureService cultureService;

	public static void addCulture(Culture culture) throws DAOException {
		cultureService=new CultureService();
		try {
			cultureService.create(culture);
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}
	public static List<Culture> listCulture() throws DAOException{
		cultureService=new CultureService();

		try {
			List<Culture> cultures=cultureService.list();
			return cultures;
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}
	public static Culture readCulture(int id)throws DAOException{

		cultureService=new CultureService();
		return cultureService.read(id);
	}
	public static void updateCulture(Culture culture) throws DAOException{
		cultureService=new CultureService();
		cultureService.update(culture);
	}
	public static void deleteCulture(int id)throws DAOException{
	}
}
