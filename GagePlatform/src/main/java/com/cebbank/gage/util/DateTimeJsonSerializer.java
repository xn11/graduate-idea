package com.cebbank.gage.util;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * Created by xn on 2017/4/1.
 *
 * pattern: yyyy-MM-dd HH:mm:ss
 */
public class DateTimeJsonSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(GageUtils.dateToString(date, "yyyy-MM-dd HH:mm:ss"));
    }
}