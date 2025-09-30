package com.neueda.bam.usermanager.domain;

import java.util.List;

public class HRUserList {

    private List<HRUser> results;

    public List<HRUser> getResults() {
        return results;
    }

    public void setResults(List<HRUser> results) {
        this.results = results;
    }

    public User getUserFromResults() {
        HRUser hrUser = results.get(0);
        return hrUser.toUser();
    }
}
