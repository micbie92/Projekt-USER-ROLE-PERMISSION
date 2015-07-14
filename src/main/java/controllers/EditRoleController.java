package controllers;

import controllers.helpers.RoleHelper;
import dao.RoleDAO;
import forms.RoleForm;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name ="editRoleController")
@ViewScoped
public class EditRoleController {

    private RoleForm roleForm;
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @ManagedProperty(value="#{roleDAO}")
    RoleDAO roleDAO;

    public void editRoleForm(){
        roleDAO.edit(RoleHelper.convert_RF_To_R(roleForm));
    }

    @PostConstruct
    public void Init(){
        id =Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("role_id"));
        roleForm = RoleHelper.convert_R_To_RF(roleDAO.find(id));
    }

}
