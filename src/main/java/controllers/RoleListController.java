package controllers;

import controllers.helpers.RoleHelper;
import dao.RoleDAO;
import forms.RoleForm;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("roleListController")
@RequestScoped
public class RoleListController implements Serializable {

    private List<RoleForm> roleFormList;
    private String[] selectedRoles;

    public String[] getSelectedRoles() {
        return selectedRoles;
    }

    public void setSelectedRoles(String[] selectedRoles) {
        this.selectedRoles = selectedRoles;
    }

    public List<RoleForm> getRoleFormList() {
        return roleFormList;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public void setRoleFormList(List<RoleForm> roleFormList) {
        this.roleFormList = roleFormList;
    }

    public void deleteRole(RoleForm roleForm){
        roleDAO.delete(RoleHelper.convert_RF_To_R(roleForm));
    }

    public void AddRoleToUser(String selectedRoles){
        System.out.printf(selectedRoles);
    }

    @Inject
    RoleDAO roleDAO;

    @PostConstruct
    public void getFormList(){
        roleFormList = RoleHelper.getRoleList(roleDAO.getList());
    }

    public String getURL(String id){
        String s = "/edit_role.xhtml?faces-redirect=true&role_id="+id;
        return s;
    }
}