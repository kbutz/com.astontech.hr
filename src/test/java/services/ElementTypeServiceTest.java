package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementTypeService;
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
public class ElementTypeServiceTest {

    @Autowired
    private ElementTypeService elementTypeService;

    @Test
    public void elementServiceSaveTest() {
        ElementType elementType = new ElementType("ServiceTest");

        // save element, verify that it has an ID after the save
        assertNull(elementType.getId());
        elementTypeService.saveElementType(elementType);
        assertNotNull(elementType.getId());

        // test fetch
        ElementType fetchedElementType = elementTypeService.getElementTypeById(elementType.getId());
        assertNotNull(fetchedElementType);
        assertEquals(elementType.getId(), fetchedElementType.getId());

        // test update
        fetchedElementType.setElementTypeName("personal");
        elementTypeService.saveElementType(fetchedElementType);

        ElementType updatedElement = elementTypeService.getElementTypeById(fetchedElementType.getId());
        assertEquals(updatedElement.getElementTypeName(), "personal");
    }

}
