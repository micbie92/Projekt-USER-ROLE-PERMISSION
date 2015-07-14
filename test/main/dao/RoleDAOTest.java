package main.dao;

import main.models.Permission;
import main.models.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mbielecki on 13.07.15.
 */
public class RoleDAOTest {

    RoleDAO roleDAO;

    @Before
    public void beforeTest() {roleDAO = new RoleDAO(); }

    @After
    public void afterTest() { roleDAO = null; }

    @Test
    public void testInit() throws Exception {
        int size = roleDAO.getList().size();
        roleDAO.init();

        assertEquals(size + 3, roleDAO.getList().size());

    }

    @Test
    public void testAddPermission() throws Exception {
        Role role = createRole();
        Permission permission = createPermission();
        int size = role.getPermissionList().size();
        roleDAO.addPermission(role, permission);

        assertEquals(size+1, role.getPermissionList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPermissionRoleNotExsist() {
        Role role = new Role();
        Permission permission = createPermission();
        roleDAO.addPermission(role, permission);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPermissionPermissionNotExsist(){
        Role role = createRole();
        Permission permission = new Permission();
        roleDAO.addPermission(role, permission);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddPermissionNullRole(){
        Permission permission = createPermission();
        roleDAO.addPermission(null, permission);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPermissionNullPermission(){
        Role role = createRole();
        roleDAO.addPermission(role, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPermissionPermissionIsOnList(){
        Role role = createRole();
        Permission permission = createPermission();
        roleDAO.addPermission(role, permission);
        roleDAO.addPermission(role, permission);
    }

    @Test
    public void testRemovePermission() throws Exception {
        Role role = createRole();
        Permission permission = createPermission();
        roleDAO.addPermission(role, permission);
        roleDAO.removePermission(role, permission);

        assertFalse(role.getPermissionList().contains(permission));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePermissionRoleNotExsist() {
        Role role = new Role();
        Permission permission = createPermission();
        roleDAO.removePermission(role, permission);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePermissionPermissionNotExsist(){
        Role role = createRole();
        Permission permission = new Permission();
        roleDAO.removePermission(role, permission);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRemovePermissionNullRole(){
        Permission permission = createPermission();
        roleDAO.removePermission(null, permission);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePermissionNullPermisison(){
        Role role = createRole();
        roleDAO.removePermission(role, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePermissionPermissionIsNotOnList(){
        Role role = createRole();
        Permission permission = createPermission();
        roleDAO.removePermission(role, permission);
    }

    private Role createRole(){
        Role role = new Role();
        role.setId(4);
        role.setName("Rycerz");
        role.setRoleShortcuts("Ryc");
        return role;
    }

    private Permission createPermission(){
        Permission permission = new Permission();
        permission.setId(5);
        permission.setName("Chodzenie");
        permission.setPermissionShortcut("Cho");
        return permission;
    }
}