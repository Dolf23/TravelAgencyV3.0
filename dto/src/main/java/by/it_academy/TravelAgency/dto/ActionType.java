package by.it_academy.TravelAgency.dto;

public class ActionType extends Entity{
    private int id;
    private String actionType;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + ((actionType == null) ? 0 : actionType.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Action type [id=" + id + ", Action type=" + actionType + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!super.equals(obj))
            return false;

        if (!(obj instanceof ActionType))
            return false;

        ActionType other = (ActionType) obj;

        if (id != other.id)
            return false;

        if (actionType == null)
            if (other.actionType != null)
                return false;
        else
            if (!actionType.equals(other.actionType))
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

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
}
