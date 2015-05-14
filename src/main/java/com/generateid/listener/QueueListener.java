package com.generateid.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.generateid.ConfigConstants;
import com.generateid.model.Request;
import com.generateid.service.StoreService;

@Component
public class QueueListener {

    @Autowired
    private StoreService storeService;

    @JmsListener(destination = ConfigConstants.REQUEST_QUEUE_NAME)
    public void receiveRequest(Request request) {
        storeService.register(request);
    }
}
