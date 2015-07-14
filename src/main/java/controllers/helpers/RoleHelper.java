package controllers.helpers;

import forms.RoleForm;
import models.Entity;
import models.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbielecki on 09.07.15.
 */
public class RoleHelper {

    public static List<RoleForm> getRoleList(List<Role> roleList) {
        List <RoleForm> roleFormList = new ArrayList<RoleForm>();
        for(Role role: roleList){
            roleFormList.add(convert_R_To_RF(role));
        }
        return roleFormList;
    }

    public static RoleForm convert_R_To_RF(Role role){
        RoleForm roleForm = new RoleForm();
        roleForm.setId(role.getId());
        roleForm.setName(role.getName());
        roleForm.setShortcuts(role.getRoleShortcuts());
        return roleForm;
    }

    public static Role convert_RF_To_R(RoleForm roleForm){
        Role role = new Role();
        role.setName(roleForm.getName());
        role.setRoleShortcuts(roleForm.getShortcuts());
        role.setId(roleForm.getId());
        return role;
    }

    public static String convertRoleToString(RoleForm roleForm){
        return roleForm.getName();
    }

}
