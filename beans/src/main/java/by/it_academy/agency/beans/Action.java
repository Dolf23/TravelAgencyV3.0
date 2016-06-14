package by.it_academy.agency.beans;

public class Action extends Entity {
    private int id;
    private ActionType actionType;
    private User user;
    private Tour tour;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + actionType.hashCode();
        result = prime * result + user.hashCode();
        result = prime * result + tour.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Action [" + "id=" + id + ", action=" + actionType + ", user=" + user + ", tour=" + tour + ']';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!super.equals(obj))
            return false;

        if (!(obj instanceof Action))
            return false;

        Action other = (Action) obj;

        if (id != other.id)
            return false;

        if (actionType.equals(other.actionType))
            return false;

        if (user.equals(other.user))
            return false;

        if ((tour.equals(other.tour)))
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

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
