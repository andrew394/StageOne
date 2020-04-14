package com.epam.learn.collection.maintask.entity;

public class PreciousStone extends Gem {

    private PreciousNameType type;

    public PreciousStone(int transparence, int price, double value, PreciousNameType type) {
        super(transparence, price, value);
        this.type = type;
    }

    public PreciousNameType getType() {
        return type;
    }

    public void setType(PreciousNameType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PreciousStone{" +
                "type=" + getType() +
                ", transparence=" + getTransparence() + "%" +
                ", price=" + getPrice() +
                ", value=" + getValue() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PreciousStone that = (PreciousStone) o;

        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
