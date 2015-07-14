package controllers.helpers;

import forms.RoleForm;
import forms.UserForm;
import models.Role;
import models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbielecki on 08.07.15.
 */

public class UserHelper {

    public static List<UserForm> getUserFormList(List<User> userList) {
        List<UserForm> userFormList = new ArrayList<UserForm>();
        for(User user: userList){
            userFormList.add(convert_U_To_UF(user));
        }
        return userFormList;
    }

    public static List<RoleForm> getUserRoleFormList(List<Role> roleList){
        List<RoleForm> roleFormList = new ArrayList();
        for(Role role: roleList){
            roleFormList.add(RoleHelper.convert_R_To_RF(role));
        }
        return roleFormList;
    }

    public static UserForm convert_U_To_UF(User user){
        UserForm userForm = new UserForm();

        userForm.setName(user.getName());
        userForm.setLastName(user.getLastName());
        userForm.setEmail(user.getEmail());
        userForm.setPhoneNumber(user.getPhoneNumber());
        userForm.setId(user.getId());
        return userForm;
    }

    public static User convert_UF_To_U(UserForm userForm){
        User user = new User();

        user.setName(userForm.getName());
        user.setLastName(userForm.getLastName());
        user.setEmail(userForm.getEmail());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setId(userForm.getId());
        return user;
    }


}
