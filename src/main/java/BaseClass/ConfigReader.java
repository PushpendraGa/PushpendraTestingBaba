package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\PushpendraTestingBaba\\src\\main\\resources\\config.properties");
            properties = new Properties();
            properties.load(file);
            file.close(); // ✅ File Close Karna Best Practice Hai
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to load config.properties file");
        }
    }

    public static String getProperty(String key) { // ✅ Corrected Method
        return properties.getProperty(key);
    }
}
