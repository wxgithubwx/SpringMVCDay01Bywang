package wx.converter;

import wx.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ConverterController {

    @RequestMapping("/bookConverter")
    @ResponseBody
    public String bookConverter(Book book){
        return book.toString();
    }

    /**
     * todo http://localhost:8080/dateConverter?date=2018-06-25%2023:10:23
     * @param date
     * @return
     */
    @RequestMapping("/dateConverter")
    @ResponseBody
    public String dateConverter(Date date){
        System.out.println("date="+date);
        return "success";
    }
}
