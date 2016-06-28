package by.it_academy.agency.beans;

import java.util.Set;

public class Tour extends Entity {
    private int id;
    private int cost;
    private int discount;

    private Country country;
    private TourType tourType;
    private Transport transport;
    private HotelType hotelType;
    private FoodComplex foodComplex;
    private Set<Action> actions;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + country.hashCode();
        result = prime * result + tourType.hashCode();
        result = prime * result + transport.hashCode();
        result = prime * result + hotelType.hashCode();
        result = prime * result + foodComplex.hashCode();
        result = prime * result + cost;
        result = prime * result + discount;
        return result;
    }

    @Override
    public String toString() {
        String outString = "Tour [" +
                "id=" + id +
                ", country=" + country +
                ", tour type=" + tourType +
                ", transport=" + transport +
                ", hotel type=" + hotelType +
                ", food complex=" + foodComplex +
                ", cost=" + cost +
                ", discount=" + discount +
                ']';

        return outString;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!super.equals(obj))
            return false;

        if (!(obj instanceof Tour))
            return false;

        Tour other = (Tour) obj;

        if (id != other.id)
            return false;

        if (country.equals(other.country))
            return false;

        if (tourType.equals(other.tourType))
            return false;

        if (transport.equals(other.transport))
            return false;

        if (hotelType.equals(other.hotelType))
            return false;

        if (foodComplex.equals(other.foodComplex))
            return false;

        if (cost != other.cost)
            return false;

        if (discount != other.discount)
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public HotelType getHotelType() {
        return hotelType;
    }

    public void setHotelType(HotelType hotelType) {
        this.hotelType = hotelType;
    }

    public FoodComplex getFoodComplex() {
        return foodComplex;
    }

    public void setFoodComplex(FoodComplex foodComplex) {
        this.foodComplex = foodComplex;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }
}
