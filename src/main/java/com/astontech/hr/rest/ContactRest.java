package com.astontech.hr.rest;

import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.services.ContactService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactRest {
    private Logger log = Logger.getLogger(ContactRest.class);

    @Autowired
    ContactService contactService;

    // GET ALL
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Contact> getAllContacts() { return contactService.listAllContacts();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Contact getContactById(@PathVariable Integer id) {return contactService.getContactById(id);}

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Contact saveContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        boolean result = false;
        try {
            contactService.deleteContact(id);
            result = true;
        } catch (Exception e) {
            log.error(e);
        }
        return result;
    }
}
