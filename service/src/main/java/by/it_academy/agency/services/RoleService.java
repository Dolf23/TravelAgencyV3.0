package by.it_academy.agency.services;

import by.it_academy.agency.beans.Role;
import by.it_academy.agency.dao.interfaces.IRoleDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class RoleService implements IRoleService {

    private IRoleDAO dao;

    @Autowired
    public RoleService(IRoleDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(Role role) {

    }

    @Override
    public void update(Role role) {

    }

    @Override
    public Role getById(int id) throws ServiceException {
        try {
            return dao.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("RoleService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Role> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DAOException e) {
            logger.writeLog("RoleService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public Role getEntityByRole(String role) throws ServiceException {
        try {
            return dao.getEntityByRole(role);
        } catch (DAOException e) {
            logger.writeLog("RoleService getEntityByRole error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
