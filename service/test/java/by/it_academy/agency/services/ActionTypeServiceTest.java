package by.it_academy.agency.services;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class ActionTypeServiceTest extends TestCase {

    private ActionTypeService actionTypeService;
    private int id = 3;

    @Before
    public void startTest() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testGetByIdShouldReturnActionType() throws Exception {
//        ActionTypeDAO dao = spy(ActionTypeDAO.INSTANCE);
//        by.it_academy.agency.beans.ActionType actionType = new by.it_academy.agency.beans.ActionType();
//        when(dao.getEntityByID(id)).thenReturn(actionType);
//        actionTypeService.getById(id);
//        verify(dao).getEntityByID(id);
    }

    @Test
    public void testGetAll() throws Exception {
        /*List<ActionType> list = new ArrayList<>();
        when(dao.getAll()).thenReturn(list);
        actionTypeService.getAll();
        verify(dao).getAll();*/
    }

    @Test
    public void testGetIdByActionType() throws Exception {

    }

    @After
    public void stopTest() {
        actionTypeService = null;
    }
}