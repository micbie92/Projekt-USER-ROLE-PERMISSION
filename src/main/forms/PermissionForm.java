package main.forms;

import main.models.Permission;

/**
 * Created by mbielecki on 06.07.15.
 */
public class PermissionForm {

    private Integer id;
    private String name;
    private String shortcut;

    public PermissionForm(){}

    public PermissionForm(String name, String shortcuts, int id){
        this.name = name;
        this.shortcut = shortcuts;
        this.id = id;
    }

    public PermissionForm(Permission permission){
        this.name = permission.getName();
        this.shortcut = permission.getPermissionShortcut();
        this.id = permission.getId();
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

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }
}
