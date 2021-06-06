package com.abbas.test.services;

import com.abbas.test.models.UserDetails;
import com.abbas.test.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class VisaProcessingServiceImpl implements VisaProcessingService {

    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public String addUser(UserDetails userDetails) {
        jmsTemplate.convertAndSend("VisaProcessingQueue", userDetails);
        return "Your Request in Process : ";
    }

    @Override
    public UserDetails getUserById(Long id) {
        return userDetailsRepository.findById(id).get();
    }
}
