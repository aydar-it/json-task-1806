package ru.vtb.internship.jackson.utility;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class UtilityXml {
    public static <T> String getXmlFromObject(Object obj, Class<T> cl) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(cl);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        return writer.toString();
    }

    public static <T> T getObjectFromXml(String value, Class<T> cl) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(cl);
        try (StringReader reader = new StringReader(value)) {
            return (T) context.createUnmarshaller().unmarshal(reader);
        }
    }
}
