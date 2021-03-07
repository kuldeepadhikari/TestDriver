package common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class GetPropertyValues {

    String result = "";
    InputStream inputStream;

    public String getPropValues(String Env,String propValue) throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "config/"+Env +"/config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            if(propValue.equals("User")) {
                result = System.getProperty("User");
            }else if(propValue.equals("Pwd")) {
                result = System.getProperty("Pwd");
            }else {
                result = prop.getProperty(propValue);
            }
            // System.out.println("propertyValue = " +);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            if(inputStream!=null){
                inputStream.close();}
        }
        return result;
    }
}