package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Address;
import com.astontech.hr.repositories.AddressRepository;
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
public class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testSaveAddress() {
        Address address = new Address();
        address.setStreet("1339 Updton Ave");
        address.setState("MN");
        address.setZip("55411");

        assertNull(address.getId());
        addressRepository.save(address);
        assertNotNull(address.getId());

    }

    @Test
    public void testUpdateAddress() {
        Address address = new Address();
        address.setStreet("1335 Updton Ave");
        address.setState("MN");
        address.setZip("55411");

        addressRepository.save(address);

        Address fetchedAddress = addressRepository.findOne(address.getId());
        assertNotNull(fetchedAddress.getId());
        assertEquals(address.getId(), fetchedAddress.getId());
    }
}
