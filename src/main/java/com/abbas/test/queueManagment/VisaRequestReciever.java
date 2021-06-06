package com.abbas.test.queueManagment;

import com.abbas.test.models.UserDetails;
import com.abbas.test.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class VisaRequestReciever {


    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @JmsListener(destination = "VisaProcessingQueue")
    public void receiveMessage(UserDetails userDetails) {
        System.out.println("Received <" + userDetails + ">");
        userDetailsRepository.save(userDetails);
    }

}
