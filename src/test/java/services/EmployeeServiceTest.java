package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void employeeServiceSaveTest() {

        Employee employee = new Employee();
        employee.setFirstName("Kyle");
        employee.setLastName("Butz");
        employee.setBackground("Java Dev");

        assertNull(employee.getId());
        employeeService.saveEmployee(employee);
        assertNotNull(employee.getId());

        //fetch
        Employee fetchedEmployee = employeeService.getEmployeeById(employee.getId());
        assertNotNull(fetchedEmployee);
        assertEquals(employee.getId(), fetchedEmployee.getId());

        //update
        fetchedEmployee.setFirstName("TEST");
        employeeService.saveEmployee(fetchedEmployee);

        Employee updatedFetchedEmployee = employeeService.getEmployeeById(fetchedEmployee.getId());
        assertEquals("TEST", updatedFetchedEmployee.getFirstName());

    }


}
