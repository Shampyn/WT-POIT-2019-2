package com.company;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class XMLValidator {
    public boolean ValidateXMLByXSD(File xmlPath, File xsdPath){
        try{
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(xsdPath).newValidator().validate(new StreamSource(xmlPath));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
