package by.it_academy.agency.services;

import by.it_academy.agency.beans.Role;
import by.it_academy.agency.dao.RoleDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;

import java.util.List;

public class RoleService implements IService<Role> {

    private RoleDAO roleDAO = new RoleDAO();

    @Override
    public void add(Role role) {

    }

    @Override
    public void update(Role role) {

    }

    @Override
    public Role getById(int id) throws ServiceException {
        try {
            return roleDAO.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("RoleService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Role> getAll() throws ServiceException {
        try {
            return roleDAO.getAll();
        } catch (DAOException e) {
            logger.writeLog("RoleService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public Role getIdByRole(String role) throws ServiceException {
        try {
            return roleDAO.getEntityByRole(role);
        } catch (DAOException e) {
            logger.writeLog("RoleService getEntityByRole error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
