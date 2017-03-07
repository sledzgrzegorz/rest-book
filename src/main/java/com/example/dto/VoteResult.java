package com.example.dto;

import java.util.Collection;

/**
 * Created by Grzesiek on 2017-03-07.
 */
public class VoteResult {
    private int totalVotes;
    private Collection<OptionCount> results;
// Getters and Setters omitted for brevity


    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public Collection<OptionCount> getResults() {
        return results;
    }

    public void setResults(Collection<OptionCount> results) {
        this.results = results;
    }
}
