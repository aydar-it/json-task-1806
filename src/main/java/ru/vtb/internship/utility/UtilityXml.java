package ru.vtb.internship.utility;

import ru.vtb.internship.exceptions.ConverterJAXBException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class UtilityXml {
    public <T> String getXmlFromObject(Object obj, Class<T> cl) throws ConverterJAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(cl);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (JAXBException e) {
            throw new ConverterJAXBException(e.getMessage());
        }
    }

    public <T> T getObjectFromXml(String value, Class<T> cl) throws ConverterJAXBException {
        try (StringReader reader = new StringReader(value)) {
            JAXBContext context = JAXBContext.newInstance(cl);
            return (T) context.createUnmarshaller().unmarshal(reader);
        } catch (JAXBException e) {
            throw new ConverterJAXBException(e.getMessage());
        }
    }
}
