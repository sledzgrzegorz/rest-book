package com.example.repository;

import com.example.domain.Poll;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Grzesiek on 2017-02-26.
 */
public interface PollRepository extends CrudRepository<Poll,
        Long> {
}
