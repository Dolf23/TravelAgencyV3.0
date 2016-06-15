package by.it_academy.agency.services;

import by.it_academy.agency.beans.ActionType;
import by.it_academy.agency.dao.ActionTypeDAO;
import java.util.List;

public class ActionTypeService implements IService<ActionType> {
    @Override
    public void add(ActionType actionType) {

    }

    @Override
    public void update(ActionType actionType) {

    }

    @Override
    public ActionType getById(int id) {
        return ActionTypeDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<ActionType> getAll() {
        return ActionTypeDAO.INSTANCE.getAll();
    }

    public static ActionType getIdByActionType(String actionType) {
        return ActionTypeDAO.INSTANCE.getEntityByValue(actionType);
    }
}
