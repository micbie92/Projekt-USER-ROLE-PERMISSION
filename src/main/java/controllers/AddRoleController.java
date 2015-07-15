package controllers;

import controllers.helpers.RoleHelper;
import dao.RoleDAO;
import forms.RoleForm;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


@ManagedBean(name ="addRoleController")
@RequestScoped
public class AddRoleController {

    private RoleForm roleForm = new RoleForm();

    public RoleForm getRoleForm() {
        return roleForm;
    }

    public void setRoleForm(RoleForm roleForm) {
        this.roleForm = roleForm;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @ManagedProperty(value="#{roleDAO2}")
    RoleDAO roleDAO;

    public void addRoleForm(){
        roleDAO.add(RoleHelper.convert_RF_To_R(roleForm));
    }

}
