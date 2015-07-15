package controllers;

import controllers.helpers.RoleHelper;
import controllers.helpers.UserHelper;
import dao.RoleDAO;
import dao.UserDAO;
import forms.RoleForm;
import forms.UserForm;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name ="addUserController")
@RequestScoped
public class AddUserController {

    @PostConstruct
    public void init() {
        List<String> rolesSource = new ArrayList<String>();
        List<String> rolesTarget = new ArrayList<String>();

        List<RoleForm> roleFormList = RoleHelper.getRoleList(roleDAO.getList());

        for (RoleForm roleForm : roleFormList) {
            rolesSource.add(RoleHelper.convertRoleToString(roleForm));
        }

        rolesToPickList.setSource(rolesSource);
        rolesToPickList.setTarget(rolesTarget);
    }


    private UserForm userForm = new UserForm();
    private DualListModel<String> rolesToPickList = new DualListModel();

    public DualListModel<String> getRolesToPickList() {
        return rolesToPickList;
    }

    public void setRolesToPickList(DualListModel<String> rolesToPickList) {
        this.rolesToPickList = rolesToPickList;
    }

    public UserForm getUserForm() {
        return userForm;
    }

    public void setUserForm(UserForm userForm) {
        this.userForm = userForm;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @ManagedProperty(value = "#{userDAO2}")
    UserDAO userDAO;

    @ManagedProperty(value = "#{roleDAO2}")
    RoleDAO roleDAO;

    public void addUserForm() {
        Integer id = userDAO.add(UserHelper.convert_UF_To_U(userForm));
        for (String name : rolesToPickList.getTarget()) {
            userDAO.addRole(userDAO.find(id), roleDAO.findByName(name));
        }
    }
}