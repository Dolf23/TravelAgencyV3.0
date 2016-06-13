package by.it_academy.TravelAgency.dto;

import java.io.Serializable;

public abstract class Entity implements Serializable{
    protected int id;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (null == obj){
            return false;
        }

        if (!(obj instanceof Entity)){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity [id=" + id + "]";
    }

    public Entity(){}

    public Entity(int id){
        this.id = id;
    }
    //@return id
    public int getId(){
        return id;
    }

    //@param id the id to set
    public void setId(int id){
        this.id = id;
    }
}
