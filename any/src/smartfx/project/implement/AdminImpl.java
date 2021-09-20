package smartfx.project.implement;

import java.util.List;

import smartfx.project.Exception.DAOException;
import smartfx.project.models.User;
import smartfx.project.service.AdminService;

public class AdminImpl {
	private static AdminService adminService;

	public static void addUser(User user) throws DAOException {
		adminService=new AdminService();
		try {
			adminService.create(user);
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}
	public static List<User> listUsers() throws DAOException{
		adminService=new AdminService();

		try {
			List<User> users=adminService.list();
			return users;
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}
	public static User readUser(int id)throws DAOException{

		adminService=new AdminService();
		return adminService.read(id);
	}
	public static void updateUser(User user) throws DAOException{
		adminService=new AdminService();
		adminService.update(user);
	}
	public static void deleteUser(int id)throws DAOException{
		adminService=new AdminService();
		adminService.delete(id);
	}
}
