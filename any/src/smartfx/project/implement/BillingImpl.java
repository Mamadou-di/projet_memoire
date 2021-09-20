package smartfx.project.implement;

import java.util.List;

import smartfx.project.Exception.DAOException;
import smartfx.project.models.Facture;
import smartfx.project.service.BillingService;

public class BillingImpl {
	private static BillingService billingService;

	public static void addFacture(Facture facture) throws DAOException {
		billingService=new BillingService();
		try {
			billingService.create(facture);
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}
	public static List<Facture> listFactures() throws DAOException{
		billingService=new BillingService();

		try {
			List<Facture> factures=billingService.list();
			return factures;
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}
	public static Facture readFacture(int id)throws DAOException{

		billingService=new BillingService();
		return billingService.read(id);
	}
	public static void updateFacture(Facture facture) throws DAOException{
		billingService=new BillingService();
		billingService.update(facture);
	}
	public static void deleteFacture(int id)throws DAOException{
	}
}
