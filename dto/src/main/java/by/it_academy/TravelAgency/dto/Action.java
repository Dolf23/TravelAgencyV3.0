package by.it_academy.TravelAgency.dto;

public class Action extends Entity {
    private int id;
    private int fk_action;
    private int fk_user;
    private int fk_tour;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + fk_action;
        result = prime * result + fk_user;
        result = prime * result + fk_tour;
        return result;
    }

    @Override
    public String toString() {
        String outString = "Action [" + "id=" + id + ", action=" +  fk_action + ", user=" + fk_user + ", tour=" + fk_tour + ']';
        return outString;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!super.equals(obj))
            return false;

        if (!(obj instanceof Action))
            return false;

        Action other = (Action)obj;

        if (id != other.id)
            return false;

        if (fk_action != other.fk_action)
            return false;

        if (fk_user != other.fk_user)
            return false;

        if ((fk_tour != other.fk_tour))
            return false;
        return true;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getFk_action() {
        return fk_action;
    }

    public void setFk_action(int fk_action) {
        this.fk_action = fk_action;
    }

    public int getFk_user() {
        return fk_user;
    }

    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    public int getFk_tour() {
        return fk_tour;
    }

    public void setFk_tour(int fk_tour) {
        this.fk_tour = fk_tour;
    }
}
