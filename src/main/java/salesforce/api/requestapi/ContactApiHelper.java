/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.api.requestapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import salesforce.entities.Contact;
import salesforce.api.restclient.RestApi;
import salesforce.utils.EndPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Manages contact information.
 *
 * @author Juan Martinez.
 * @version 1.0 20 March 2020.
 */
public class ContactApiHelper {
    private Contact contact;

    /**
     * Sets contacts.
     *
     * @param contactMapList values.
     * @return contact list.
     */
    public ArrayList<Contact> setContacts(final ArrayList<HashMap<String, String>> contactMapList) {
        ArrayList<Contact> contactsList = new ArrayList<>();
        for (HashMap<String, String> contactItem : contactMapList) {
            contact = new Contact();
            contact.setContactInformation(contactItem);
            contactsList.add(contact);
        }
        return contactsList;
    }

    /**
     * Creates contacts.
     *
     * @param contacts list.
     */
    public void postContacts(final List<Contact> contacts) {
        for (Contact contact : contacts) {
            try {
                String json = new ObjectMapper().writeValueAsString(contact);
                Response response = RestApi.postEntity(json, EndPoint.CONTACT_ENDPOINT);
                JsonPath jsonPath = response.jsonPath();
                String id = jsonPath.get("id");
                contact.setId(id);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Deletes contacts.
     *
     * @param contactList value.
     */
    public void deleteContacts(final List<Contact> contactList) {
        for (Contact contact : contactList) {
            Response response = RestApi.deleteEntity(contact.getId(), EndPoint.CONTACT_ENDPOINT);
            int statusCode = response.getStatusCode();
            contact.setStatusCode(Integer.toString(statusCode));
        }
    }
}
