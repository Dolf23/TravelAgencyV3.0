package by.it_academy.TravelAgency.dto;

public class HotelType extends Entity {
    private int id;
    private String hotelType;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + ((hotelType == null) ? 0 : hotelType.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Hotel type [id=" + id + ", Hotel type=" + hotelType + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!super.equals(obj))
            return false;

        if (!(obj instanceof HotelType))
            return false;

        HotelType other = (HotelType)obj;

        if (id != other.id)
            return false;

        if (hotelType == null)
            if (other.hotelType != null)
                return false;
        else
            if (!hotelType.equals(other.hotelType))
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

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }
}
