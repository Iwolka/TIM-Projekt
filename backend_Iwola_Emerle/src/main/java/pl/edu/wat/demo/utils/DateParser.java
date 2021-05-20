package pl.edu.wat.demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DateParser {

    public static List<String> parseRangeToList(String startDate, String endDate) {
        List<String> dates = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date start=dateFormat.parse(startDate);
            Date end=dateFormat.parse(endDate);
            long diffInMillies = Math.abs(end.getTime() - start.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            for(int i=0; i<=diff; i++){
                dates.add(dateFormat.format(start));
                start = Date.from(start.toInstant().atZone(ZoneId.of("UTC")).plusDays(1).toInstant());
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  dates;

    }
}
