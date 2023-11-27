package baseDir;

import baseDir.utils.LogUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SettingsReader {
    static Properties props;

    public static String getTetData(String value){
        props = new Properties();
        try (InputStream input2 = new FileInputStream("src/main/resources/test_data.properties")) {
            props.load(input2);
            return props.getProperty(value);
        } catch (IOException ex) {
            LogUtils.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
    public static String getConfigData(String value){
        props = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/configuration/config.properties")) {
            props.load(input);
            return props.getProperty(value);
        } catch (IOException ex) {
            LogUtils.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
    public static int getConfigDataInt(String value){
        props = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/configuration/config.properties")) {
            props.load(input);
            return Integer.parseInt(props.getProperty(value));
        } catch (IOException ex) {
            LogUtils.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
}
