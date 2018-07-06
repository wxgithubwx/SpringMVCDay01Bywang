package wx.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建自定义类型日期转换器
 */
public class DateConverter implements Converter<String,Date> {

    //定义日期格式
    String datePattern="yyyy-MM-dd HH:mm:ss";
    @Override
    public Date convert(String s) {
        //格式化日期
        SimpleDateFormat sdf=new SimpleDateFormat(datePattern);
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            System.out.println("无效的日期格式，请用这种格式："+datePattern);
            throw new IllegalArgumentException("无效的日期格式，请用这种格式："+datePattern);
        }
    }
}
