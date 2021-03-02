package fr.diginamic.mongodb.model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private ObjectId id;
    @BsonProperty(value = "title")
    private String title;
    @BsonProperty(value = "releaseDate")
    private LocalDate releaseDate;

    public Book() {
    }

    public Book(String title, LocalDate releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id) &&
                title.equals(book.title) &&
                releaseDate.equals(book.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate);
    }
}
