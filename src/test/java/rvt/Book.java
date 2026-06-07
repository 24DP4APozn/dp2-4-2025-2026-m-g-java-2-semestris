package rvt;

public class Book implements Packable {
    private String author;
    private String name;
    private double weight;

    public Book(String bookAuthor, String bookName, double bookWeight) {
        author = bookAuthor;
        name = bookName;
        weight = bookWeight;
    }

    public double weight() {
        return weight;
    }

    public String toString() {
        return author + ": " + name;
    }
}