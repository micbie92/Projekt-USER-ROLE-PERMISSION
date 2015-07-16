package dao;

import models.Role;
import models.User;


import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;


@ApplicationScoped
public class UserDAO extends AbstractDAO<User> implements Serializable{

    public UserDAO() {
        init();
    }

    @PersistenceContext
    private EntityManager entityManager;

    public void init() {
        add(new User("Jacek", "Placek", "fasfsasa@gmail.com", "533633108"));
        add(new User("Jan", "Zamojski", "fgasdfgasgas@gmail.com", "533633109"));
    }

    public void addRole(User user, Role role){
        if(user == null ||
            role == null ||
            user.equals(new User()) ||
            role.equals(new Role())){
            throw new IllegalArgumentException();
        }
        List<Role> userRoleList = user.getUserRoleList();
        if(userRoleList.contains(role)) throw new IllegalArgumentException();
        userRoleList.add(role);
        user.setUserRoleList(userRoleList);
    }

    public void removeRole(User user, Role role){
        if(user == null ||
            role == null ||
            user.equals(new User()) ||
            role.equals(new Role())){
            throw new IllegalArgumentException();
        }
        List<Role> userRoleList = user.getUserRoleList();
        if(userRoleList.contains(role) ){
            userRoleList.remove(role);
            user.setUserRoleList(userRoleList);
        }
        else{
            throw new IllegalArgumentException();
        }
    }


}
