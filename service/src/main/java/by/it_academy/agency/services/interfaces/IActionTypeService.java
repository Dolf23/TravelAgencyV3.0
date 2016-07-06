package by.it_academy.agency.services.interfaces;

import by.it_academy.agency.beans.ActionType;
import by.it_academy.agency.exceptions.ServiceException;

public interface IActionTypeService extends IService<ActionType> {
    ActionType getEntityByActionType(String actionType) throws ServiceException;
}
