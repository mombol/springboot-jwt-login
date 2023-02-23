package com.mombol.common.util;

import java.util.Date;

public class TimeUtil {

    public static long getSecondTimestamp(Date date)
    {
        if (date == null) {
            return 0;
        }

        String timestamp = String.valueOf(date.getTime() / 1000);

        return Integer.parseInt(timestamp);
    }

}
