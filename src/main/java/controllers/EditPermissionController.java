package controllers;

import controllers.helpers.PermissionHelper;
import dao.PermissionDAO;
import forms.PermissionForm;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named("editPermissionController")
@ApplicationScoped
//był ViewScoped
public class EditPermissionController {

    private PermissionForm permissionForm = new PermissionForm();
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public void editPermissionForm(){
        permissionDAO.edit(PermissionHelper.convert_PF_To_P(permissionForm));
    }

    @PostConstruct
    public void Init(){
        id =Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("permission_id"));
        permissionForm = PermissionHelper.convert_P_To_PF(permissionDAO.find(id));
    }

}
