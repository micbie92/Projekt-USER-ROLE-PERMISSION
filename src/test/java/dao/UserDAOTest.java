package main.dao;

import dao.UserDAO;
import models.Entity;
import models.Role;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mbielecki on 09.07.15.
 */
public class UserDAOTest {

    UserDAO userDAO;

    @Before
    public void beforeTest() {
        userDAO = new UserDAO();
    }

    @After
    public void afterTest(){
        userDAO = null;
    }

    @Test
    public void testGetUserList(){
        List<User> userList = userDAO.getList();

        assertEquals(2, userList.size());
    }

    @Test
    public void testEditUser(){
        User oldUser = new User("Name", "LastName", "Email", "PhoneNumber");
        userDAO.add(oldUser);
        User newUser = createUser();
        newUser.setId(oldUser.getId());

        userDAO.edit(newUser);

        assertEquals(newUser.getId(), oldUser.getId());
        assertEquals("Jan", userDAO.find(oldUser.getId()).getName());
        assertEquals("Duży", userDAO.find(oldUser.getId()).getLastName());
        assertEquals("mail@gmail.com", userDAO.find(oldUser.getId()).getEmail());
        assertEquals("533637122", userDAO.find(oldUser.getId()).getPhoneNumber());

    }

    @Test (expected = IllegalArgumentException.class)
    public void testEditUserUserNull(){
        userDAO.edit(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEditUserNotExistUser(){
        User user = new User();
        userDAO.edit(user);
    }

    @Test
    public void testAddUser(){
        int size = userDAO.getList().size();
        User user = createUser();
        userDAO.add(user);

        assertEquals(size + 1, userDAO.getList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddUserNullArgument(){
        userDAO.add(null);
    }

    @Test
    public void testDeleteUser(){
        User user = createUser();
        userDAO.add(user);
        int size = userDAO.getList().size();
        userDAO.delete(user);

        assertEquals(size - 1, userDAO.getList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteUserNull(){
        userDAO.delete(null);
    }

    @Test
    public void testFindUser(){
        User user = createUser();
        userDAO.add(user);

        assertEquals(user, userDAO.find(user.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindUserUserNotOnList(){
        User user = createUser();
        userDAO.find(user.getId()+1);

    }

    @Test
    public void testInit(){
        int size = userDAO.getList().size();
        userDAO.init();

        assertEquals(size + 2, userDAO.getList().size());
    }

    @Test
    public void testAddRole(){
        User user = createUser();
        Role role = createRole();
        int size = user.getUserRoleList().size();
        userDAO.addRole(user, role);

        assertEquals(size + 1, user.getUserRoleList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRoleUserNotExsist() {
        User user = new User();
        Role role = createRole();
        userDAO.addRole(user, role);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRoleRoleNotExsist(){
        User user = createUser();
        Role role = new Role();
        userDAO.addRole(user, role);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddRoleNullUser(){
        Role role = createRole();
        userDAO.addRole(null, role);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRoleNullRole(){
        User user = createUser();
        userDAO.addRole(user, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRoleRoleIsOnList(){
        Role role = createRole();
        User user = createUser();
        userDAO.addRole(user, role);
        userDAO.addRole(user, role);
    }

    @Test
    public void testRemoveRole(){
        User user = createUser();
        Role role = createRole();
        userDAO.addRole(user, role);
        userDAO.removeRole(user, role);

        assertFalse(user.getUserRoleList().contains(role));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRoleUserNotExsist() {
        User user = new User();
        Role role = createRole();
        userDAO.removeRole(user, role);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRoleRoleNotExsist(){
        User user = createUser();
        Role role = new Role();
        userDAO.removeRole(user, role);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRoleNullUser(){
        Role role = createRole();
        userDAO.removeRole(null, role);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRoleNullRole(){
        User user = createUser();
        userDAO.removeRole(user, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRoleRoleIsNotOnList(){
        User user = createUser();
        Role role = createRole();
        userDAO.removeRole(user, role);
    }

    private User createUser(){
        User user = new User();
        user.setId(3);
        user.setName("Jan");
        user.setLastName("Duży");
        user.setPhoneNumber("533637122");
        user.setEmail("mail@gmail.com");
        return user;
    }

    private Role createRole(){
        Role role = new Role();
        role.setId(4);
        role.setName("Rycerz");
        role.setRoleShortcuts("Ryc");
        return role;
    }
}