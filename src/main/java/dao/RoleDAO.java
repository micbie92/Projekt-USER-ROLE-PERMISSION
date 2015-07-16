package dao;

import models.Permission;
import models.Role;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.List;


@ApplicationScoped
public class RoleDAO extends AbstractDAO<Role> implements Serializable{

    public RoleDAO() {
        init();
    }


    public void init(){
        add(new Role("Rola1", "R1"));
        add(new Role("Rola 2", "R2"));
        add(new Role("Rola 3", "R3"));
    }

    public void addPermission(Role role, Permission permission){
        if( role == null ||
            permission == null ||
            role.equals(new Role()) ||
            permission.equals(new Permission())){
            throw new IllegalArgumentException();
        }
        List<Permission> rolePermissionsList = role.getPermissionList();
        if(rolePermissionsList.contains(permission)) throw new IllegalArgumentException();
        rolePermissionsList.add(permission);
        role.setPermissionList(rolePermissionsList);
        }


    public void removePermission(Role role, Permission permission){
        if( role==null ||
            permission == null ||
            role.equals(new Role()) ||
            permission.equals(new Permission())){
            throw new IllegalArgumentException();
        }
        List<Permission> rolePermissionList = role.getPermissionList();
        if(rolePermissionList.contains(permission)){
            rolePermissionList.remove(permission);
            role.setPermissionList(rolePermissionList);
        }
        else{
            throw new IllegalArgumentException();
        }

    }

}

