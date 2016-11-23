package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
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
public class ElementRepositoryTest {

    @Autowired
    private ElementRepository elementRepository;

    @Test
    public void testSaveElement() {
        // setup element
        Element element = new Element();
        element.setElementName("Phone");

        // save element, verify that it has an ID after the save
        assertNull(element.getId());
        elementRepository.save(element);
        assertNotNull(element.getId());

        // test fetch
        Element fetchedElement = elementRepository.findOne(element.getId());
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        // test update
        fetchedElement.setElementName("Email");
        elementRepository.save(fetchedElement);

        Element updatedElement = elementRepository.findOne(fetchedElement.getId());
        assertEquals(updatedElement.getElementName(), "Email");
    }

    @Test
    public void testSaveElementList() {
        List<Element> elementList = new ArrayList<>();

        elementList.add(new Element("Phone"));
        elementList.add(new Element("Email"));
        elementList.add(new Element("Laptop"));
        elementList.add(new Element("PayRate"));

        elementRepository.save(elementList);

        Iterable<Element> fetchedElementList = elementRepository.findAll();

        int count = 0;
        for(Element e : fetchedElementList){
            count++;
        }

        assertEquals(4, count);
    }

    @Test
    public void testFindByName() {
        Element element = new Element("FindTestSingle");
        elementRepository.save(element);

        Element foundByNameElment = elementRepository.findByElementName("FindTestSingle");

        assertEquals(element.getId(), foundByNameElment.getId());
    }

    @Test
     public void testFindByNameIgnoreCase() {
        Element element = new Element("FindTestIgnoreCase");
        elementRepository.save(element);

        Element foundByNameElment = elementRepository.findByElementNameIgnoreCase("Findtestignorecase");

        assertEquals(element.getId(), foundByNameElment.getId());
    }

    @Test
    public void testFindAllByName() {
        Element element1 = new Element("FindTest");
        elementRepository.save(element1);
        Element element2 = new Element("FindTest");
        elementRepository.save(element2);
        Element element3 = new Element("FindTest");
        elementRepository.save(element3);

       List<Element> foundAllByNameElement = elementRepository.findAllByElementName("Findtest");

        assertEquals(3, foundAllByNameElement.size());
    }

    @Test
    public void testFindAllByNameIgnoreCase() {
        Element element1 = new Element("FindAllIgnoreCase");
        elementRepository.save(element1);
        Element element2 = new Element("FindAllIgnoreCase");
        elementRepository.save(element2);
        Element element3 = new Element("FindAllIgnoreCase");
        elementRepository.save(element3);

        List<Element> foundAllByNameIgnoreCase = elementRepository.findAllByElementNameIgnoreCase("findallignorecase");

        assertEquals(3, foundAllByNameIgnoreCase.size());
    }

    @Test
    public void testFindTop3ByName() {
        Element element1 = new Element("FindTop3");
        elementRepository.save(element1);
        Element element2 = new Element("FindTop3");
        elementRepository.save(element2);
        Element element3 = new Element("FindTop3");
        elementRepository.save(element3);
        Element element4 = new Element("FindTop3");
        elementRepository.save(element4);


        List<Element> foundTop3ByElementName = elementRepository.findTop3ByElementName("FindTop3");

        assertEquals(3, foundTop3ByElementName.size());
    }

}
