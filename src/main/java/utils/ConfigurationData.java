package utils;

import java.util.Properties;

public class ConfigurationData {
    private static String getValueFromConfigFile(String value) {
        Properties properties = new Properties();
        String propertiesFileName = "config.properties";
        try {
            properties.load(ConfigurationData.class.getClassLoader().getResourceAsStream(propertiesFileName));
            return properties.getProperty(value);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getBrowser() {
        return getValueFromConfigFile("browser");
    }

    public static String getUsername() {
        return getValueFromConfigFile("username");
    }

    public static String getPassword() {
        return getValueFromConfigFile("password");
    }

    public static String getBaseUrl() {
        return getValueFromConfigFile("baseUrl");
    }

    public static boolean getHeadlessValue() {
        try {
            return Boolean.parseBoolean(ConfigurationData.getValueFromConfigFile("headless").toLowerCase());
        } catch (Exception e) {
            System.out.println("Did not provide clear headless value. Anything besides \"true\" is treated as false");
            return false;
        }
    }

    public static String getErrorMessageInvalid() {
        return getValueFromConfigFile("loginErrorMessageInvalid");
    }

    public static String getErrorMessageEmpty() {
        return getValueFromConfigFile("loginErrorMessageEmpty");
    }
}
