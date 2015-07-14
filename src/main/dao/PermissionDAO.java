package main.dao;
import main.models.Permission;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;


@ManagedBean(name ="permissionDAO")
@ApplicationScoped

public class PermissionDAO extends AbstractDAO <Permission> {

    public PermissionDAO() {
        init();
    }

    public void init() {
        add(new Permission("Uprawnienie 1", "U1"));
        add(new Permission("Uprawnienie 2", "U2"));
        add(new Permission("Uprawnienie 3", "U3"));
    }
}

