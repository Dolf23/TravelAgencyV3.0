package by.it_academy.TravelAgency.dto;

public class Tour extends Entity {
    private int id;
    private int fk_country;
    private int fk_tour_type;
    private int fk_transport;
    private int fk_hotel_type;
    private int fk_food_complex;
    private int cost;
    private int discount;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + fk_country;
        result = prime * result + fk_tour_type;
        result = prime * result + fk_transport;
        result = prime * result + fk_hotel_type;
        result = prime * result + fk_food_complex;
        result = prime * result + cost;
        result = prime * result + discount;
        return result;
    }

    @Override
    public String toString() {
        String outString ="Tour [" +
                    "id=" + id +
                    ", country=" + fk_country +
                    ", tour type=" + fk_tour_type +
                    ", transport=" + fk_transport +
                    ", hotel type=" + fk_hotel_type +
                    ", food complex=" + fk_food_complex +
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

        Tour other = (Tour)obj;

        if (id != other.id)
            return false;

        if (fk_country != other.fk_country)
            return false;

        if (fk_tour_type != other.fk_tour_type)
            return false;

        if (fk_transport != other.fk_transport)
            return false;

        if (fk_hotel_type != other.fk_hotel_type)
            return false;

        if (fk_food_complex != other.fk_food_complex)
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

    public int getFk_country() {
        return fk_country;
    }

    public void setFk_country(int fk_country) {
        this.fk_country = fk_country;
    }

    public int getFk_tour_type() {
        return fk_tour_type;
    }

    public void setFk_tour_type(int fk_tour_type) {
        this.fk_tour_type = fk_tour_type;
    }

    public int getFk_transport() {
        return fk_transport;
    }

    public void setFk_transport(int fk_transport) {
        this.fk_transport = fk_transport;
    }

    public int getFk_hotel_type() {
        return fk_hotel_type;
    }

    public void setFk_hotel_type(int fk_hotel_type) {
        this.fk_hotel_type = fk_hotel_type;
    }

    public int getFk_food_complex() {
        return fk_food_complex;
    }

    public void setFk_food_complex(int fk_food_complex) {
        this.fk_food_complex = fk_food_complex;
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
}
