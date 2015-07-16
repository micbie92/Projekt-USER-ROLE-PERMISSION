package controllers;

import controllers.helpers.PermissionHelper;
import dao.PermissionDAO;
import forms.PermissionForm;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("permissionListController")
@RequestScoped
public class PermissionListController implements Serializable {

    private List<PermissionForm> permissionFormList;

    public List<PermissionForm> getPermissionFormList() {
        return permissionFormList;
    }

    public PermissionDAO getPermissionDAO() {
        return permissionDAO;
    }

    public void setPermissionDAO(PermissionDAO permissionDAO) {
        this.permissionDAO = permissionDAO;
    }

    public void setPermissionList(List<PermissionForm> permissionFormList) {
        this.permissionFormList = permissionFormList;
    }

    public void deletePermissionForm(PermissionForm permissionForm){
        permissionDAO.delete(PermissionHelper.convert_PF_To_P(permissionForm));

    }

    @Inject
    PermissionDAO permissionDAO;

    @PostConstruct
    public void getList(){
        permissionFormList = PermissionHelper.getPermissionList(permissionDAO.getList());
    }

    public String getURL(String id){
        String s = "/edit_permission.xhtml?faces-redirect=true&permission_id="+id;
        return s;
    }


}