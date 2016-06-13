package by.it_academy.TravelAgency.dto;

public class Country extends Entity {
    private int id;
    private String country;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Country [id=" + id + ", Country=" + country + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!super.equals(obj))
            return false;

        if (!(obj instanceof Country))
            return false;

        Country other = (Country) obj;

        if (id != other.id)
            return false;

        if (country == null)
            if (other.country != null)
                return false;
        else
            if (!country.equals(other.country))
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
