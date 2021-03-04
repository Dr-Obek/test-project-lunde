package eu.lundegaard.testform.testData;

import eu.lundegaard.testform.domain.ContactForm;
import eu.lundegaard.testform.domain.RequestKind;
import eu.lundegaard.testform.model.ContactFormRequestDto;

import java.util.ArrayList;

public final class ContactFormTestData {

    private static final ContactForm TEST_CONTACT_FORM = new ContactForm()
            .setRequestKind(new RequestKind(3L, "Complaint"))
            .setPolicyNo("abcd01234")
            .setFirstName("first")
            .setLastName("last")
            .setRequestText("Some request text: 123 +-*/ ěščřžýáíé");

    private static final ContactFormRequestDto TEST_CONTACT_FORM_REQUEST_DTO = new ContactFormRequestDto()
            .setKindOfRequest("Complaint")
            .setPolicyNo("abcd01234")
            .setFirstName("first")
            .setLastName("last")
            .setRequestText("Some request text: 123 +-*/ ěščřžýáíé");

    private static final ArrayList<ContactForm> CONTACT_FORMS;

    static {
        CONTACT_FORMS = new ArrayList<>();
        CONTACT_FORMS.add(getTestContactForm());
    }

    private ContactFormTestData() {
    }

    public static ContactForm getTestContactForm() {
        return TEST_CONTACT_FORM;
    }

    public static ContactFormRequestDto getTestContactFormRequestDto() {
        return TEST_CONTACT_FORM_REQUEST_DTO;
    }

    public static ArrayList<ContactForm> getContactForms() {
        return CONTACT_FORMS;
    }
}
