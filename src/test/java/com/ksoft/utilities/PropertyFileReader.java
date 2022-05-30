package com.ksoft.utilities;



import java.io.*;
import java.util.Properties;

public class PropertyFileReader
{
        public PropertyFileReader()
        {

        }

        private Properties getData() {
            ClassLoader classLoader = this.getClass().getClassLoader();
            File file = new File(classLoader.getResource("com/ksoft/utilities/config.properties").getFile());
            FileInputStream fileInput = null;

            try {
                fileInput = new FileInputStream(file);
            } catch (FileNotFoundException var7) {
                var7.printStackTrace();
            }

            Properties prop = new Properties();

            try {
                prop.load(fileInput);
            } catch (IOException var6) {
                var6.printStackTrace();
            }

            return prop;
        }

        public String getProperty(String key) {
            return this.getData().getProperty(key);
        }
}


