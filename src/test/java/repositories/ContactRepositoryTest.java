package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.repositories.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ContactRepositoryTest {
    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testSaveContact() {
        Contact contact = new Contact();
        contact.setFirstName("Abe");
        contact.setLastName("Raham");
        contact.setDescription("Tophatty President");

        assertNull(contact.getId());
        contactRepository.save(contact);
        assertNotNull(contact.getId());

        Contact fetchedContact = contactRepository.findOne(contact.getId());
        assertNotNull(fetchedContact.getId());
        assertEquals(contact.getId(), fetchedContact.getId());

    }
}
