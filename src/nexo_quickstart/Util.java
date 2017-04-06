package nexo_quickstart;


import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains utility methods designed to be statically imported into
 * the quickstart main classes.
 */
public class Util {
    /**
     * Configures logging if the QUICKSTART_DEBUG environment variable is set.
     */
    public static void configureLogging() {
        String value = System.getenv("QUICKSTART_DEBUG");
        if (value != null) {
            Handler handler = new ConsoleHandler();
            handler.setLevel(Level.FINEST);
            Logger logger = Logger.getLogger("com.nexmo");
            logger.setLevel(Level.FINEST);
            logger.addHandler(handler);
        }
    }

    /**
     * Look up a required environment variable and throw an
     * IllegalArgumentException if the variable is not set.
     * @param key whe name of the environment variable
     * @return the value
     */
    public static String envVar(String key) {
        String value = System.getenv(key);
        if (value == null) {
            throw new IllegalArgumentException("You must provide the " + key + " environment variable!");
        }
        return value;
    }
}