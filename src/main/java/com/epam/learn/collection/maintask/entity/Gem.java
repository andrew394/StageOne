package com.epam.learn.collection.maintask.entity;

public abstract class Gem {

    private int transparence;
    private int price;
    private double value;

    public Gem(int transparence, int price, double value) {
        this.transparence = transparence;
        this.price = price;
        this.value = value;
    }

    public int getTransparence() {
        return transparence;
    }

    public void setTransparence(int transparence) {
        this.transparence = transparence;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Gem{" +
                "transparence=" + transparence + "%" +
                ", price=" + price +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gem gem = (Gem) o;

        if (transparence != gem.transparence) return false;
        if (price != gem.price) return false;
        return Double.compare(gem.value, value) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = transparence;
        result = 31 * result + price;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
