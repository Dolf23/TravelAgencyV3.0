package by.it_academy.TravelAgency.dto;

public class FoodComplex extends Entity {
    private int id;
    private String foodComplex;

    @Override
    public int hashCode() {
        final int prime =31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + ((foodComplex == null) ? 0 : foodComplex.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Food comlex [id=" + id + ", Food complex=" + foodComplex + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!super.equals(obj))
            return false;

        if (!(obj instanceof FoodComplex))
            return false;

        FoodComplex other = (FoodComplex)obj;

        if (id != other.id)
            return false;

        if (foodComplex == null)
            if (other.foodComplex != null)
                return false;
        else
            if (!foodComplex.equals(other.foodComplex))
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

    public String getFoodComplex() {
        return foodComplex;
    }

    public void setFoodComplex(String foodComplex) {
        this.foodComplex = foodComplex;
    }
}
