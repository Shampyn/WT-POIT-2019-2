package com.company;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLSerializer {
    public void Serialize(Object object, String filepath) {
        try {
            File file = new File(filepath);
            if (!file.exists()) {
                if (!file.createNewFile())
                    throw new IOException();
            }
            XMLEncoder out = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filepath)));
            out.writeObject(object);
            out.flush();
            out.close();
        } catch (IOException e) {

        }
    }
}
