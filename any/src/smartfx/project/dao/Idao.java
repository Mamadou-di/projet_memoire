package smartfx.project.dao;

import java.util.List;

import smartfx.project.Exception.DAOException;

public interface Idao<T> {

	/**
	 * @param entity
	 * @throws DAOException
	 */
	public void create (T entity) throws DAOException;
	/**
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public T read (int id) throws DAOException;
	/**
	 * @return
	 * @throws DAOException
	 */
	public List<T> list () throws DAOException;
	/**
	 * @param entity
	 * @throws DAOException
	 */
	public void update (T entity) throws DAOException;
	/**
	 * @param id
	 * @throws DAOException
	 */
	public void delete (int id) throws DAOException;


}
