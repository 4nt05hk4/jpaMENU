package jpa1;

import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DishUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @SerializedName("dish")
    private String name;
    @SerializedName("$")
    private double price;
    @SerializedName("weight")
    private double weight;
    @SerializedName("isDiscount")
    private boolean isDiscount;
    @SerializedName("discount")
    public int discount;

    public DishUnit() {
    }

    public DishUnit(String name, double price, double weight, boolean isDiscount, int discount) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.isDiscount = isDiscount;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public void setDiscount(boolean discount) {
        isDiscount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "DishUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", isDiscount=" + isDiscount +
                ", discount=" + discount +
                '}';
    }
}