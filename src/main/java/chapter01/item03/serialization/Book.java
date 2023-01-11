package chapter01.item03.serialization;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * item03. private 생성자 또는 열거타입으로 싱글톤임을 보증하라
 * 완벽공략 - 직렬화
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String name;
    private String isbn;
    private String title;
    private String author;
    private LocalDate published;
    private  transient int numberOfSold; // transient 를 붙이면 직렬화 X

    public Book(String isbn, String title, String author, LocalDate published) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.published = published;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", published=" + published +
                ", numberOfSold=" + numberOfSold +
                '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public int getNumberOfSold() {
        return numberOfSold;
    }

    public void setNumberOfSold(int numberOfSold) {
        this.numberOfSold = numberOfSold;
    }
}
