package rvt;

public class CD implements Packable {
    private String artist;
    private String name;
    private int year;

    public CD(String cdArtist, String cdName, int publicationYear) {
        artist = cdArtist;
        name = cdName;
        year = publicationYear;
    }

    public double weight() {
        return 0.1;
    }

    public String toString() {
        return artist + ": " + name + " (" + year + ")";
    }
}