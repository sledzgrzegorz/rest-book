package com.example.controller;

import com.example.domain.Poll;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * Created by Grzesiek on 2017-02-26.
 */
@RestController
public class PollController {
    @Autowired
    private PollRepository pollRepository;

    @RequestMapping(value = "/polls", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();
        return new ResponseEntity<>(pollRepository.findAll(),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/polls", method = RequestMethod.POST)
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
        poll = pollRepository.save(poll);


        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();
        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, responseHeaders,
                HttpStatus.CREATED);
    }

    @RequestMapping(value = "/polls/{pollId}",
            method = RequestMethod.GET)
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) throws ResourceNotFoundException {
        Poll p = pollRepository.findOne(pollId);
        verifyPoll(pollId, p);

        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    private void verifyPoll(@PathVariable Long pollId, Poll p) {
        if(p == null) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }
    }

    @RequestMapping(value = "/polls/{pollId}",
            method = RequestMethod.PUT)
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll,
                                        @PathVariable Long pollId) {
// Save the entity
        Poll p = pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/polls/{pollId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long
                                                pollId) {
        pollRepository.delete(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
