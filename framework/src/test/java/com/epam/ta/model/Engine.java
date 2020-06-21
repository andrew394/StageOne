package com.epam.ta.model;

public class Engine {

    private String numberOfInstances;

    public Engine(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        return numberOfInstances != null ? numberOfInstances.equals(engine.numberOfInstances) : engine.numberOfInstances == null;

    }

    @Override
    public int hashCode() {
        return numberOfInstances != null ? numberOfInstances.hashCode() : 0;
    }
}
