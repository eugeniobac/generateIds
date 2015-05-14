package com.generateid.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.generateid.model.Request;

@Service
public class StoreService {

    private final HashSet<Request> received = new HashSet<>();

    public void register(Request request) {
        if (request != null) {
            received.add(request);
        }
    }

    public Optional<Request> getReceivedRequest(String id) {
        return received.stream().filter(req -> req.getId().toString().equals(id)).findFirst();
    }

    public Integer count() {
        return received.size();
    }

    public Set<Request> getReceived() {
        return received;
    }
}