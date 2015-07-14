package forms;

public class RoleForm {

    private Integer id;
    private String name;
    private String shortcuts;

    public RoleForm(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleForm)) return false;

        RoleForm roleForm = (RoleForm) o;

        return !(id != null ? !id.equals(roleForm.id) : roleForm.id != null);

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

    public String getShortcuts() {
        return shortcuts;
    }

    public void setShortcuts(String shortcuts) {
        this.shortcuts = shortcuts;
    }
}
