package com.epam.ta.model;

public class Search {

    private String term;

    public Search(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Search search = (Search) o;

        return term != null ? term.equals(search.term) : search.term == null;

    }

    @Override
    public int hashCode() {
        return term != null ? term.hashCode() : 0;
    }
}
