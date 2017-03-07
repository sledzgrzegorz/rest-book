package com.example.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Grzesiek on 2017-02-26.
 */
@Entity
public class Poll {
    @Id
    @GeneratedValue
    @Column(name="POLL_ID")
    private Long id;
    @Column(name="QUESTION")
    private String question;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POLL_ID")
    @OrderBy
    private Set<Option> options;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}
