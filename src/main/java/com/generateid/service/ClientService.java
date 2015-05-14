package com.generateid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.generateid.ConfigConstants;
import com.generateid.model.Request;

@Service
public class ClientService {

    @Autowired
    private JmsTemplate template;

    @Async
    public Request createRequest(Request request) {
        template.convertAndSend(ConfigConstants.REQUEST_QUEUE_NAME, request);
        return request;
    }
}
