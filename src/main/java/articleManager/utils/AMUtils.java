package articleManager.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class AMUtils {
    
    public static String dateFormat(LocalDateTime ldt) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ldt);
    }

}
