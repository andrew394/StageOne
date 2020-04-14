package com.epam.learn.collection.maintask.entity;

public class SemipreciousStone extends Gem {

    private SemipreciousNameType type;

    public SemipreciousStone(int transparence, int price, double value, SemipreciousNameType type) {
        super(transparence, price, value);
        this.type = type;
    }

    public SemipreciousNameType getType() {
        return type;
    }

    public void setType(SemipreciousNameType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SemipreciousStone{" +
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

        SemipreciousStone that = (SemipreciousStone) o;

        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
