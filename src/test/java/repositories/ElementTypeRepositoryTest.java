package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementTypeRepositoryTest {

    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Test
    public void testFindByElementType() {
        ElementType elementType = new ElementType("TestFindByElementType");
        elementTypeRepository.save(elementType);

        ElementType foundByElementType = elementTypeRepository.findByElementTypeName(elementType.getElementTypeName());

        assertEquals(elementType.getId(), foundByElementType.getId());
    }

    @Test
    public void testFindByElementTypeIgnoreCase() {
        ElementType elementType = new ElementType("TestFindByElementTypeIgnoreCase");
        elementTypeRepository.save(elementType);

        ElementType foundByElementType = elementTypeRepository.findByElementTypeNameIgnoreCase("testfindbyelementtypeignorecase");

        assertEquals(elementType.getId(), foundByElementType.getId());
    }

    @Test
    public void testFindAllByName() {
        ElementType elementType1 = new ElementType("FindAllTest");
        elementTypeRepository.save(elementType1);
        ElementType elementType2 = new ElementType("FindAllTest");
        elementTypeRepository.save(elementType2);
        ElementType elementType3 = new ElementType("FindAllTest");
        elementTypeRepository.save(elementType3);
        ElementType elementType4 = new ElementType("FindAllTest");
        elementTypeRepository.save(elementType4);


        List<ElementType> foundAllByNameElement = elementTypeRepository.findAllByElementTypeName("FindAllTest");

        assertEquals(4, foundAllByNameElement.size());
    }

    @Test
    public void testCountAll(){
        ElementType e = new ElementType("This Type");
        ElementType e2 = new ElementType("This Type");
        ElementType e3 = new ElementType("This Type");
        elementTypeRepository.save(e);
        elementTypeRepository.save(e2);
        elementTypeRepository.save(e3);
        Integer count = elementTypeRepository.countByElementTypeName("This Type");
        assertEquals((Integer)3, count);
    }

}
