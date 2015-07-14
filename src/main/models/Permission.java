package main.models;

import java.util.Random;

/**
 * Created by mbielecki on 06.07.15.
 */
public class Permission implements Entity{

    Random random = new Random();

    private Integer id;
    private String name;
    private String permissionShortcut;

    public Permission(){

    }

    public Permission(String name, String shortcuts){

        this.name = name;
        this.permissionShortcut = shortcuts;
        this.id = random.nextInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permission)) return false;

        Permission that = (Permission) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

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

    public String getPermissionShortcut() {
        return permissionShortcut;
    }

    public void setPermissionShortcut(String permissionShortcut) {
        this.permissionShortcut = permissionShortcut;
    }
}
