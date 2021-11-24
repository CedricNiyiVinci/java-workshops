import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Context {

    private static Properties properties = new Properties();

    public static  void load(String filename){
        InputStream in = Context.class.getResourceAsStream("/"+filename);
        try {
            //FileInputStream in = new FileInputStream(Context.class.getClassLoader().getResource(filename).getFile());
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
    public static int getIntProperty(String key){
        return Integer.parseInt(properties.getProperty(key));
    }
}
