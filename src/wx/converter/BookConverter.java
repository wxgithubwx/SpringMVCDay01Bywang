package wx.converter;

import wx.bean.Book;
import org.springframework.core.convert.converter.Converter;

/**
 * 泛型1：源数据类型
 * 泛型2：转换之后的数据类型
 */
public class BookConverter implements Converter<String,Book> {
    @Override
    public Book convert(String s) {
        //111:JAVA
        String[] ss=s.split(":");
        Book book=new Book();
        book.setBookId(Integer.parseInt(ss[0]));
        book.setBookName(ss[1]);
        return book;
    }
}
