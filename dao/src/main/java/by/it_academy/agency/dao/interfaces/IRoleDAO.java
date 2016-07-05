package by.it_academy.agency.dao.interfaces;

import by.it_academy.agency.beans.Role;
import by.it_academy.agency.exceptions.DAOException;

public interface IRoleDAO extends DAO<Role> {
    Role getEntityByRole(String role) throws DAOException;
}
