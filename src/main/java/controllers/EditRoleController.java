package controllers;

import controllers.helpers.PermissionHelper;
import controllers.helpers.RoleHelper;
import dao.PermissionDAO;
import dao.RoleDAO;
import forms.PermissionForm;
import forms.RoleForm;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name ="editRoleController")
@ViewScoped
public class EditRoleController {

    private RoleForm roleForm;
    private Integer id;
    private DualListModel<String> permissionsToPickList = new DualListModel();


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

    public DualListModel<String> getPermissionsToPickList() {
        return permissionsToPickList;
    }

    public void setPermissionsToPickList(DualListModel<String> permissionsToPickList) {
        this.permissionsToPickList = permissionsToPickList;
    }

    public PermissionDAO getPermissionDAO() {
        return permissionDAO;
    }

    public void setPermissionDAO(PermissionDAO permissionDAO) {
        this.permissionDAO = permissionDAO;
    }

    @ManagedProperty(value="#{roleDAO2}")
    RoleDAO roleDAO;

    @ManagedProperty(value="#{permissionDAO2}")
    PermissionDAO permissionDAO;

    public void editRoleForm(){
        roleDAO.edit(RoleHelper.convert_RF_To_R(roleForm));
        for (String name : permissionsToPickList.getTarget()) {
            roleDAO.addPermission(roleDAO.find(id), permissionDAO.findByName(name));
        }
    }

    @PostConstruct
    public void Init(){
        id =Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("role_id"));
        roleForm = RoleHelper.convert_R_To_RF(roleDAO.find(id));

        List<String> permissionsSource = new ArrayList<String>();
        List<String> permissionsTarget = new ArrayList<String>();

        List<PermissionForm> permissionsFormList = PermissionHelper.getPermissionList(permissionDAO.getList());
        List<PermissionForm> rolePermissionsList = RoleHelper.getRolePermissionFormList(roleDAO.find(id).getPermissionList());
        for (PermissionForm permissionForm : rolePermissionsList) {
            permissionsTarget.add(PermissionHelper.convertPermissionToString(permissionForm));
            if( permissionsFormList.contains(permissionForm)){
                permissionsFormList.remove(permissionForm);
            }
        }

        for (PermissionForm permissionForm : permissionsFormList) {
            permissionsSource.add(PermissionHelper.convertPermissionToString(permissionForm));
        }

        permissionsToPickList.setSource(permissionsSource);
        permissionsToPickList.setTarget(permissionsTarget);
    }

}
