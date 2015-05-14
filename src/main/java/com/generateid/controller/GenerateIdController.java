package com.generateid.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.generateid.model.Request;
import com.generateid.service.ClientService;
import com.generateid.service.StoreService;

/**
 * <pre>
 * http://localhost:8080/api/id/new
 * http://localhost:8080/api/id/count
 * http://localhost:8080/api/id/show
 * 
 * <pre>
 */
@RestController
@RequestMapping("/api")
public class GenerateIdController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private StoreService storeService;

    private static long MAX_MEMORY = (long) 1288490188.8;

    public static boolean hasMemoryAvailable() {
	return MAX_MEMORY - Runtime.getRuntime().freeMemory() > 0;
    }

    @ResponseBody
    @RequestMapping("/id/new")
    public Request newId() {
	if (!hasMemoryAvailable()) { return null; }

	Request request = new Request();
	clientService.createRequest(request);
	return request;
    }

    @ResponseBody
    @RequestMapping("/id/count")
    public Integer countId() {
	return storeService.count();
    }

    @ResponseBody
    @RequestMapping("/id/show")
    public Set<Request> showAll() {
	return storeService.getReceived();
    }
}