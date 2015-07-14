package controllers.helpers;


import forms.PermissionForm;
import models.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbielecki on 09.07.15.
 */

public class PermissionHelper {

    public static List<PermissionForm> getPermissionList(List<Permission> permissionList) {
        List<PermissionForm> permissionFormList = new ArrayList<PermissionForm>();
        for (Permission permission : permissionList) {
            permissionFormList.add(convert_P_To_PF(permission));
        }
        return permissionFormList;
    }


    public static PermissionForm convert_P_To_PF(Permission permission) {
        PermissionForm permissionForm = new PermissionForm();
        permissionForm.setId(permission.getId());
        permissionForm.setName(permission.getName());
        permissionForm.setShortcut(permission.getPermissionShortcut());
        return permissionForm;
    }

    public static Permission convert_PF_To_P(PermissionForm permissionForm) {
        Permission permission = new Permission();
        permission.setId(permissionForm.getId());
        permission.setName(permissionForm.getName());
        permission.setPermissionShortcut(permissionForm.getShortcut());
        return permission;
    }
}