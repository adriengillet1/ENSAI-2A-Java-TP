package fr.ensai.library;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Author tolkien = new Author("J.R.R. Tolkien", 81, "UK");

        Book fellowshipOfTheRing = new Book(
                "978-0-618-26025-6",
                "The Fellowship of the Ring",
                tolkien,
                1954,
                423);

        Magazine tvMagazine = new Magazine("61565-156-54", "TV Magazine", "5", 2015, 48);
        Magazine autoMotoMagazine = new Magazine("8954-8484-46", "Auto-Moto Magazine", "6", 2020, 96);

        List<Item> items = new ArrayList<>();
        items.add(fellowshipOfTheRing);
        items.add(tvMagazine);
        items.add(autoMotoMagazine);

        Library my_Library = new Library("La librairie de AD", items);

        my_Library.loadBooksFromCSV("books.csv");

        my_Library.displayItems();
    }
}