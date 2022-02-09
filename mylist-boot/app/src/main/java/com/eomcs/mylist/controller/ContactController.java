package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.ContactDao;
import com.eomcs.mylist.domain.Contact;

@RestController 
public class ContactController {
  @Autowired
  ContactDao contactDao;

  @RequestMapping("/contact/list")
  public Object list() {
    return contactDao.findAll(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) throws Exception {
    contactDao.insert(contact);
    return contactDao.countAll();
  }


  @RequestMapping("/contact/get")
  public Object get(int index) throws Exception {
    Contact contact = contactDao.findByNo(index);
    if (contact == null) {
      return "";
    }
    return contact;
  }

  @RequestMapping("/contact/update")
  public Object update(int index, Contact contact) throws Exception {
    Contact old = contactDao.findByNo(index);
    if (old == null) {
      return 0;
    }
    return contactDao.update(index, contact);
  }

  @RequestMapping("/contact/delete")
  public Object delete(int index) throws Exception {
    return contactDao.delete(index);
  }

}




