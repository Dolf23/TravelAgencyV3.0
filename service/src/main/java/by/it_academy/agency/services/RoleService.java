package by.it_academy.agency.services;

import by.it_academy.agency.beans.Role;
import by.it_academy.agency.dao.RoleDAO;
import java.util.List;

public class RoleService implements IService<Role> {
    @Override
    public void add(by.it_academy.agency.beans.Role role) {

    }

    @Override
    public void update(by.it_academy.agency.beans.Role role) {

    }

    @Override
    public Role getById(int id) {
        return RoleDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<Role> getAll() {
        return RoleDAO.INSTANCE.getAll();
    }

    public Role getIdByRole(String role) {
        return RoleDAO.INSTANCE.getEntityByRole(role);
    }
}
