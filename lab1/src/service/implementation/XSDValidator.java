package service.implementation;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class XSDValidator {
    public boolean ValidateXMLByXSD(File xmlpath, File xsdpath){
        try{
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(xsdpath).newValidator().validate(new StreamSource(xmlpath));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
