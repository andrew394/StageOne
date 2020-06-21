package com.epam.ta.service;

import com.epam.ta.model.Engine;

public class EngineCreator {

    private static final String TESTDATA_ENGINE_NUMBER = "testdata.engine.numberofinstances";

    public static Engine withEngineFromProperty() {
        return new Engine(TestDataReader.getTestData(TESTDATA_ENGINE_NUMBER));
    }
}
