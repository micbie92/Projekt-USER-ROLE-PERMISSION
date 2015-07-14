package dao;

import dao.PermissionDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mbielecki on 13.07.15.
 */
public class PermissionDAOTest {

    PermissionDAO permissionDAO;

    @Before
    public void beforeTest(){
        permissionDAO = new PermissionDAO();
    }

    @After
    public void afterTest(){
        permissionDAO = null;
    }

    @Test
    public void testInit() throws Exception {
        int size = permissionDAO.getList().size();
        permissionDAO.init();

        assertEquals(size+3, permissionDAO.getList().size());

    }
}