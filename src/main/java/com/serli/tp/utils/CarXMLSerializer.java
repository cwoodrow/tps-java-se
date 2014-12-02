package com.serli.tp.utils;

import com.google.common.base.Preconditions;
import com.serli.tp.java.oo.vehicules.Car;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringWriter;

import static com.google.common.base.Preconditions.checkArgument;

public class CarXMLSerializer {

    private JAXBContext jaxbContext;

    public CarXMLSerializer() {
        try {
            jaxbContext = JAXBContext.newInstance(Car.class, CarsList.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public String carToXML(Car car) {
        checkArgument(car != null);

        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(car, stringWriter);

            return stringWriter.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public String carsListToXML(CarsList carsList) {
        checkArgument(carsList != null);

        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(carsList, stringWriter);

            return stringWriter.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    public Car carFromXML(String xmlString) {
        checkArgument(xmlString != null && !xmlString.isEmpty());

        try {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Object carFromXML = unmarshaller.unmarshal(new ByteArrayInputStream(xmlString.getBytes()));

            return (Car) carFromXML;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
