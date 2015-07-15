package dao;

import models.Role;
import models.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.util.List;


@ManagedBean(name ="userDAO2")
@ApplicationScoped
public class UserDAO extends AbstractDAO<User>{

    public UserDAO() {
        init();
    }

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
