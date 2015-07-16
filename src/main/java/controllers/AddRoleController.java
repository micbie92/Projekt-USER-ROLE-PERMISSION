package controllers;

import controllers.helpers.PermissionHelper;
import controllers.helpers.RoleHelper;
import dao.PermissionDAO;
import dao.RoleDAO;
import forms.PermissionForm;
import forms.RoleForm;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;


@Named("addRoleController")
@RequestScoped
public class AddRoleController {

    @PostConstruct
    public void init() {
        List<String> permissionsSource = new ArrayList<String>();
        List<String> permissionsTarget = new ArrayList<String>();

        List<PermissionForm> permissionsFormList = PermissionHelper.getPermissionList(permissionDAO.getList());

        for (PermissionForm permissionForm : permissionsFormList) {
            permissionsSource.add(PermissionHelper.convertPermissionToString(permissionForm));
        }

        permissionsToPickList.setSource(permissionsSource);
        permissionsToPickList.setTarget(permissionsTarget);
    }

    private RoleForm roleForm = new RoleForm();
    private DualListModel<String> permissionsToPickList = new DualListModel();

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

    @Inject
    RoleDAO roleDAO;

    @Inject
    PermissionDAO permissionDAO;

    public void addRoleForm(){
        Integer id = roleDAO.add(RoleHelper.convert_RF_To_R(roleForm));
        for (String name : permissionsToPickList.getTarget()) {
            roleDAO.addPermission(roleDAO.find(id), permissionDAO.findByName(name));
        }
    }

}
