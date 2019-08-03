package com.sample.contacts.controller;


import com.sample.contacts.models.Contact;
import com.sample.contacts.repository.ContactRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ContactRepository repository;

    @Test
    public void postReturnsSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/contacts/v1/")
                .contentType(APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "  \"firstName\":\"Jon\",\n" +
                        "  \"lastName\":\"Snow\",\n" +
                        "  \"email\":\"jon@snow.com\",\n" +
                        "  \"phone\":\"123456\"\n" +
                        "}"))
                .andExpect(status().isOk());

        Contact contact = repository.findById("jon@snow.com").get();
        Assert.assertEquals("Jon", contact.getFirstName());
        Assert.assertEquals("Snow", contact.getLastName());
        Assert.assertEquals("123456", contact.getPhone());
    }

    @Test
    public void getContactByEmailReturnsOk() throws Exception {
        Contact contact = new Contact("test@test.com", "Mel", "Swanson", "987");
        repository.save(contact);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/contacts/v1")
                .param("email","test@test.com"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"firstName\":\"Mel\",\n" +
                        "  \"lastName\":\"Swanson\",\n" +
                        "  \"email\":\"test@test.com\",\n" +
                        "  \"phone\":\"987\"\n" +
                        "}"));
    }

    @Test
    public void getContactByEmailReturns404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/contacts/v1")
                .param("email","test@test.com"))
                .andExpect(status().isNotFound());
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }


}