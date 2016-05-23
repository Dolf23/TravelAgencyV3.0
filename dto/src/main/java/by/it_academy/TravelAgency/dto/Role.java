package by.it_academy.TravelAgency.dto;

public class Role extends Entity {
    private int id;
    private String role;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", Role=" + role + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!super.equals(obj))
            return false;

        if (!(obj instanceof Role))
            return false;

        Role other = (Role) obj;

        if (id != other.id)
            return false;

        if (role == null)
            if (other.role != null)
                return false;
        else
            if (!role.equals(other.role))
                return false;

        return true;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
