package com.reedelk.runtime.openapi.v3.model;

import com.reedelk.runtime.openapi.v3.OpenApiJsons;
import org.junit.jupiter.api.Test;

public class ContactObjectTest extends AbstractOpenApiSerializableTest {

    @Test
    void shouldCorrectlySerializeContactWithAllProperties() {
        // Given
        ContactObject contact = new ContactObject();
        contact.setName("API Support");
        contact.setUrl("http://www.example.com/support");
        contact.setEmail("support@example.com");

        // Expect
        assertSerializeJSON(contact, OpenApiJsons.ContactObject.WithAllProperties);
    }

    @Test
    void shouldCorrectlySerializeContactWithRequiredValues() {
        // Given
        ContactObject contact = new ContactObject();

        // Expect (expect empty, because there are no required properties for contact)
        assertSerializeJSON(contact, OpenApiJsons.ContactObject.WithDefaultProperties);
    }
}