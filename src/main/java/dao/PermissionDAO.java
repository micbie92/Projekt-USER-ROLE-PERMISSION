package dao;

import models.Permission;


import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;


@ApplicationScoped
public class PermissionDAO extends AbstractDAO<Permission> implements Serializable{

    public PermissionDAO() {
        init();
    }

    public void init() {
        add(new Permission("Uprawnienie 1", "U1"));
        add(new Permission("Uprawnienie 2", "U2"));
        add(new Permission("Uprawnienie 3", "U3"));
    }
}

