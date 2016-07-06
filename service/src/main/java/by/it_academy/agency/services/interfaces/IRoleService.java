package by.it_academy.agency.services.interfaces;

import by.it_academy.agency.beans.Role;
import by.it_academy.agency.exceptions.ServiceException;

public interface IRoleService extends IService<Role> {
    Role getEntityByRole(String role) throws ServiceException;
}
