package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Address;
import com.astontech.hr.services.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class AddressServiceTest {
    @Autowired
    private AddressService addressService;

    @Test
    public void testAddressSave() {
        Address address = new Address();
        address.setStreet("1234 Stablewood Dr");
        address.setState("MO");
        address.setZip("12345");

        assertNull(address.getId());
        addressService.saveAddress(address);
        assertNotNull(address.getId());
    }
}
