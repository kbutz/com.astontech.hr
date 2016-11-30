package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {

        Employee employee = new Employee();
        employee.setFirstName("KyleTest");
        employee.setLastName("ButzTest");
        employee.setBackground("Java DevTest");

        assertNull(employee.getId());
        employeeRepository.save(employee);
        assertNotNull(employee.getId());

        //fetch
        Employee fetchedEmployee = employeeRepository.findOne(employee.getId());
        assertNotNull(fetchedEmployee.getId());
        assertEquals(employee.getId(), fetchedEmployee.getId());

        //update
        fetchedEmployee.setFirstName("FirstNameTest");
        employeeRepository.save(fetchedEmployee);

        Employee fetchedUpdatedEmployee = employeeRepository.findOne(fetchedEmployee.getId());
        assertEquals("FirstNameTest", fetchedUpdatedEmployee.getFirstName());

    }

}
