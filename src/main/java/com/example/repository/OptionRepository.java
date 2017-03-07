package com.example.repository;

import com.example.domain.Option;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Grzesiek on 2017-02-26.
 */
public interface OptionRepository extends
        CrudRepository<Option, Long> {
}

