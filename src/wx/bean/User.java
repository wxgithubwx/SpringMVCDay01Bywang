package wx.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    String name;
    int id;
    Book book;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date date;
    public User() {
    }

    public User(String name, int id, Book book, Date date) {
        this.name = name;
        this.id = id;
        this.book = book;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", book=" + book +
                ", date=" + date +
                '}';
    }
}
