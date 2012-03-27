package org.scauhci.official.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertityReader {

    private java.util.Properties p;
    private String file = null;

    /**
     *从配置文件中读取配置
     *
     */
    public PropertityReader(String propertityFile) throws IOException {
        this.file = propertityFile;
        try {
            init();
        } catch (IOException ex) {
            IOException e = new IOException("Cannot load propertities from " + propertityFile + "!", ex);
            throw e;
        }
    }

    /**
     *初始化配置
     *
     */
    private void init() throws IOException {
        InputStreamReader inr = null;
        try {
            inr = new InputStreamReader(PropertityReader.class.getClassLoader().getResourceAsStream(file), "UTF-8");
            p = new Properties();
            p.load(inr);
        } finally {
            inr.close();
        }

    }

    /**
     *获得配置
     *
     */
    public String get(String key) {
        return this.p.getProperty(key);
    }
}
