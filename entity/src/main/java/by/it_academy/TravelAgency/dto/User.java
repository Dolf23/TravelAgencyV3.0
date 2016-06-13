package by.it_academy.TravelAgency.dto;

public class User extends Entity {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
    private int fk_Role;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + fk_Role;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!super.equals(obj))
            return false;

        if (!(obj instanceof User))
            return false;

        User other = (User) obj;

        if (fk_Role != other.fk_Role)
            return false;

        if (id != other.id)
            return false;

        if (name == null)
            if (other.name != null)
                return false;
        else
            if (!name.equals(other.name))
                return false;


        if (surname == null)
            if (other.surname != null)
                return false;
        else
            if (!surname.equals(other.surname))
                return false;


        if (email == null)
            if (other.email != null)
                return false;
        else
            if (!email.equals(other.email))
                return false;

        if (login == null)
            if (other.login != null)
                return false;
        else
            if (!login.equals(other.login))
                return false;

        if (password == null)
            if (other.password != null)
                return false;
        else
            if (!password.equals(other.password))
                return false;
        return true;
    }

    @Override
    public String toString() {
        String outString  = "User [" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", email='" + email + '\'' +
                    ", login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    ", role=" + fk_Role +
                    ']';

        return outString;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFk_Role() {
        return fk_Role;
    }

    public void setFk_Role(int fk_Role) {
        this.fk_Role = fk_Role;
    }
}
