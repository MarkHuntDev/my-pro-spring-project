package com.apress.prospring4.ch7;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class SpringHibernateSample {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:app-context-hibernate.xml");
        context.refresh();

        ContactDao contactDao = context.getBean("contactDao", ContactDao.class);

        Contact contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
        contact.addContactTelDetail(contactTelDetail);
        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
        contact.addContactTelDetail(contactTelDetail);
        contactDao.save(contact);

        listContactsWithDetails(contactDao.findAllWithDetail());

        contact = contactDao.findById(1L);
        System.out.println("");
        System.out.println("Contact with id 1:" + contact);
        System.out.println("");
    }

    private static void listContactsWithDetails(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contact without details:");
        for (Contact contact : contacts) {
            System.out.println(contact);

            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }

            if (contact.getHobbies() != null) {
                for (Hobby hobby : contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }

            System.out.println();
        }
    }
}
