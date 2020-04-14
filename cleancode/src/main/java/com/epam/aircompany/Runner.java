package com.epam.aircompany;

import com.epam.aircompany.action.PlaneAction;
import com.epam.aircompany.data.Data;
import com.epam.aircompany.exception.PassengerPlaneException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws PassengerPlaneException {
        PlaneAction planeAction = new PlaneAction(new Data().dataPlanes());
        PlaneAction militaryPlaneAction = new PlaneAction(planeAction.getMilitaryPlanes());
        PlaneAction passengerPlaneAction = new PlaneAction(planeAction.getPassengerPlanes());
        LOGGER.debug("Military airport sorted by max distance: " + militaryPlaneAction.sortByMaxDistance().toString());
        LOGGER.debug("Passenger airport sorted by max speed: " + passengerPlaneAction.sortByMaxSpeed().toString());
        LOGGER.debug("Plane with max passenger capacity: " + passengerPlaneAction.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
