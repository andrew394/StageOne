package com.epam.ta.service;

import com.epam.ta.model.Search;

public class SearchCreator {

    private static final String TESTDATA_SEARCH_TERM = "testdata.search.term";

    public static Search withSearchFromProperty() {
        return new Search(TestDataReader.getTestData(TESTDATA_SEARCH_TERM));
    }
}
