package com.abbas.test.controllers;

import com.abbas.test.models.UserDetails;
import com.abbas.test.services.VisaProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/visa")
public class VisaProcessingController {



    @Autowired
    VisaProcessingService visaProcessingService;

    @PostMapping("/addUser")
    public String send(@RequestBody UserDetails userDetails) {

        return visaProcessingService.addUser(userDetails);

    }


    @GetMapping("/getUser/{id}")
    UserDetails getAllUsers(@PathVariable("id") Long id){

        return visaProcessingService.getUserById(id);
    }
}
