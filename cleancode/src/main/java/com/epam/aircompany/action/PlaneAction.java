package com.epam.aircompany.action;

import com.epam.aircompany.exception.MilitaryPlaneException;
import com.epam.aircompany.exception.PassengerPlaneException;
import com.epam.aircompany.plane.ExperimentalPlane;
import com.epam.aircompany.model.MilitaryType;
import com.epam.aircompany.plane.MilitaryPlane;
import com.epam.aircompany.plane.PassengerPlane;
import com.epam.aircompany.plane.Plane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

/**
 * version: 1.1
 * made by Vitali Shulha
 * 4-Jan-2019
 */
public class PlaneAction {

    private static final Logger LOGGER = LogManager.getLogger();
    private List<? extends Plane> planes;

    public PlaneAction(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlaneList = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlaneList.add((PassengerPlane) plane);
            }
        }
        return passengerPlaneList;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlaneList = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlaneList.add((MilitaryPlane) plane);
            }
        }
        return militaryPlaneList;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlaneList = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlaneList.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlaneList;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() throws PassengerPlaneException {
        if (getPassengerPlanes() == null || getPassengerPlanes().isEmpty()) {
            throw new PassengerPlaneException("passengerPlaneList didn't initialize");
        }
        return Collections.max(getPassengerPlanes(), Comparator.comparingInt(PassengerPlane::getPassengersCapacity));
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() throws MilitaryPlaneException {
        if (getMilitaryPlanes() == null || getMilitaryPlanes().isEmpty()) {
            throw new MilitaryPlaneException("militaryPlaneList didn't initialize");
        }
        return getMilitaryPlanes().stream()
                .filter(p -> p.getMilitaryType() == MilitaryType.TRANSPORT)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() throws MilitaryPlaneException {
        if (getMilitaryPlanes() == null || getMilitaryPlanes().isEmpty()) {
            throw new MilitaryPlaneException("militaryPlaneList didn't initialize");
        }
        return getMilitaryPlanes().stream()
                .filter(p -> p.getMilitaryType() == MilitaryType.BOMBER)
                .collect(Collectors.toList());
    }

    public PlaneAction sortByMaxDistance() {
        this.planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }

    public PlaneAction sortByMaxSpeed() {
        this.planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public PlaneAction sortByMaxLoadCapacity() {
        this.planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public void printPlaneCollection(Collection<? extends Plane> planeCollection) {
        planeCollection.forEach(LOGGER::debug);
    }

    @Override
    public String toString() {
        return "PlaneAction{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
