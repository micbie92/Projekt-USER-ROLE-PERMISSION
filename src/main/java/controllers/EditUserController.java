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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.management.relation.RoleList;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name ="editUserController")
@ViewScoped
public class EditUserController {


    private UserForm userForm;
    private Integer id;

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

    public void setUserForm(UserForm user) {
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

    @ManagedProperty(value="#{userDAO}")
    UserDAO userDAO;

    @ManagedProperty(value="#{roleDAO}")
    RoleDAO roleDAO;

    public void editUserForm(){
        userDAO.edit(UserHelper.convert_UF_To_U(userForm));
        for (String name : rolesToPickList.getTarget()) {
            userDAO.addRole(userDAO.find(id), roleDAO.findByName(name));
        }
    }

    @PostConstruct
    public void Init(){
        id =Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("user_id"));
        userForm = UserHelper.convert_U_To_UF(userDAO.find(id));

        List<String> rolesSource = new ArrayList<String>();
        List<String> rolesTarget = new ArrayList<String>();

        List<RoleForm> roleFormList = RoleHelper.getRoleList(roleDAO.getList());
        List<RoleForm> userRoleList = UserHelper.getUserRoleFormList(userDAO.find(id).getUserRoleList());

        for (RoleForm roleForm : userRoleList) {
            rolesTarget.add(RoleHelper.convertRoleToString(roleForm));
            if( roleFormList.contains(roleForm)){
                roleFormList.remove(roleForm);
            }
        }


        for (RoleForm roleForm : roleFormList) {
            rolesSource.add(RoleHelper.convertRoleToString(roleForm));
        }

        rolesToPickList.setSource(rolesSource);
        rolesToPickList.setTarget(rolesTarget);
    }

}
