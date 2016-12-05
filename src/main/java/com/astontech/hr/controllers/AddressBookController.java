package com.astontech.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddressBookController {
    //Controller for Contact + Address, not to be confused with a "Contact Us" page
    @RequestMapping("/addressbook")
    public String employeePage() {
        return "addressbook";
    }

}
