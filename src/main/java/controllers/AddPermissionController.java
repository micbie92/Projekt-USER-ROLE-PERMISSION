package controllers;

import controllers.helpers.PermissionHelper;
import dao.PermissionDAO;
import forms.PermissionForm;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named("addPermissionController")
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

    @Inject
    PermissionDAO permissionDAO;

    public void addPermissionForm(){
        permissionDAO.add(PermissionHelper.convert_PF_To_P(permissionForm));
    }


}
