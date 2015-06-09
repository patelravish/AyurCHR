package fv.ayurchr.commons.utils;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

/**
 * User: RavishPatel
 * Date: 12/24/11
 * Time: 9:01 PM
 */
public class LoggerUtils extends SecurityManager {
    public static Logger getLogger() {
        String className = new LoggerUtils().getClassName();
        AtomicReference<Logger> logger = new AtomicReference<Logger>(Logger.getLogger(className));
        return logger.get();
    }

    private String getClassName() {
        return getClassContext()[2].getName();
    }
}
