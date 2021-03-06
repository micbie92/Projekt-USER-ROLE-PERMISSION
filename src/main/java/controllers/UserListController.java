package controllers;

import controllers.helpers.UserHelper;
import dao.UserDAO;
import forms.UserForm;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("userListController")
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

    @Inject
    UserDAO userDAO;

    @PostConstruct
    public void getList(){
        userFormList = UserHelper.getUserFormList(userDAO.getList());
    }


}