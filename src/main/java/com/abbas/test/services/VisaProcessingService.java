package com.abbas.test.services;

import com.abbas.test.models.UserDetails;

public interface VisaProcessingService {

    String addUser(UserDetails userDetails);

    UserDetails getUserById(Long id);
}
