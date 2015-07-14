package main.controllers;

import main.controllers.helpers.UserHelper;
import main.dao.UserDAO;
import main.forms.UserForm;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name ="userListController")
@RequestScoped
public class UserListController implements Serializable {

    private List<UserForm> userFormList;

    public List<UserForm> getUserFormList() {
        return userFormList;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void deleteUser(UserForm userForm){
        userDAO.delete(UserHelper.convert_UF_To_U(userForm));
    }

    public String getURL(String id){
        String s = "/edit_user.xhtml?faces-redirect=true&user_id="+id;
        return s;
    }

    public void setUserList(List<UserForm> userFormList) {
        this.userFormList = userFormList;
    }

    @ManagedProperty(value="#{userDAO}")
    UserDAO userDAO;

    @PostConstruct
    public void getList(){
        userFormList = UserHelper.getUserFormList(userDAO.getList());
    }


}