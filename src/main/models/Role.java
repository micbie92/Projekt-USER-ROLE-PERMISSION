package main.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mbielecki on 06.07.15.
 */


public class Role implements Entity{

    Random random = new Random();

    private Integer id;
    private String name;
    private String roleShortcuts;
    private List<Permission> permissionList = new ArrayList<Permission>();

    public Role(){}

    public Role(String name, String shortcuts){
        this.name = name;
        this.roleShortcuts = shortcuts;
        this.id = random.nextInt();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        return !(id != null ? !id.equals(role.id) : role.id != null);

    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleShortcuts() {
        return roleShortcuts;
    }

    public void setRoleShortcuts(String roleShortcuts) {
        this.roleShortcuts = roleShortcuts;
    }
}
