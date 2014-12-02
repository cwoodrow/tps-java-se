package com.serli.tp.utils;

import com.serli.tp.java.oo.vehicules.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CarXMLSerializerTest {

    private CarXMLSerializer testedObject;

    @Before
    public void before() {
        testedObject = new CarXMLSerializer();
    }

    @Test
    public void shouldSerializeCarToXML() {
        String xml = testedObject.carToXML(new Car("Peugeot", 2014));

        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<car>" +
                "<name>Peugeot</name>" +
                "<year>2014</year>" +
                "</car>", xml);
    }

    @Test
    public void shouldDeserializeFromXML() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<car>" +
                "<name>Peugeot</name>" +
                "<year>2014</year>" +
                "</car>";

        Car car = testedObject.carFromXML(xml);

        assertNotNull(car);
        assertEquals("Peugeot", car.getName());
        assertEquals(2014, car.getYear());
    }

    @Test
    public void shouldSerializeCarsList() {
        CarsList carsList = new CarsList();
        carsList.getCars().add(new Car("Peugeot", 2014));
        carsList.getCars().add(new Car("Peugeot", 2012));
        carsList.getCars().add(new Car("Peugeot", 20024));

        System.out.println(testedObject.carsListToXML(carsList));
    }
}
