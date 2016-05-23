package by.it_academy.TravelAgency.dto;

public class TourType extends Entity {
    private int id;
    private String tourType;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + ((tourType == null) ? 0 : tourType.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Type tour [id=" + id + ", Type tour=" + tourType + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!super.equals(obj))
            return false;

        if (!(obj instanceof TourType))
            return false;

        TourType other = (TourType) obj;

        if (id != other.id)
            return false;

        if (tourType != null)
            if (other.tourType != null)
                return false;
        else
            if (!tourType.equals(other.tourType))
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

    public String getTourType() {
        return tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
    }
}
