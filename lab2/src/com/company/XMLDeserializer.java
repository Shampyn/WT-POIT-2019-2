package com.company;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class XMLDeserializer {
    public Object Deserialize(String filepath) {
        Object result;
        try {
            XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filepath)));
            result = xmlDecoder.readObject();
            xmlDecoder.close();
        } catch (IOException e) {
            System.out.println("Error occured: %s" + e.getMessage());
            return null;
        }
        return result;
    }
}
