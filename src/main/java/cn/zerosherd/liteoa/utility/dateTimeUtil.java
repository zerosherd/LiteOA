package cn.zerosherd.liteoa.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateTimeUtil {

    public static Date getFormattedDateTime() throws ParseException {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date = sdf.format(now);
        return sdf.parse(date);
    }

}
