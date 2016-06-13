package by.it_academy.TravelAgency.dto;

public class Transport extends Entity {
    private int id;
    private String transport;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + ((transport == null) ? 0 : transport.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Transport [id=" + id + ", Transport=" + transport + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!super.equals(obj))
            return false;

        if (!(obj instanceof Transport))
            return false;

        Transport other = (Transport)obj;

        if (id != other.id)
            return false;

        if (transport == null)
            if (other.transport != null)
                return false;
        else
            if (!transport.equals(other.transport))
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

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }
}
