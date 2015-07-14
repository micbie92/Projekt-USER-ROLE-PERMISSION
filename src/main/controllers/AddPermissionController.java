package main.controllers;

import main.controllers.helpers.PermissionHelper;
import main.dao.PermissionDAO;
import main.forms.PermissionForm;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


@ManagedBean(name ="addPermissionController")
@RequestScoped
public class AddPermissionController {

    private PermissionForm permissionForm = new PermissionForm();

    public PermissionForm getPermissionForm() {
        return permissionForm;
    }

    public void setPermissionForm(PermissionForm permissionForm) {
        this.permissionForm = permissionForm;
    }

    public PermissionDAO getPermissionDAO() {
        return permissionDAO;
    }

    public void setPermissionDAO(PermissionDAO permissionDAO) {
        this.permissionDAO = permissionDAO;
    }

    @ManagedProperty(value="#{permissionDAO}")
    PermissionDAO permissionDAO;

    public void addPermissionForm(){
        permissionDAO.add(PermissionHelper.convert_PF_To_P(permissionForm));
    }


}
