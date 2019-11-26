package com.systechInterns.controllers.Books.downloads;

import com.systechInterns.Beans.PublisherI;
import com.systechInterns.library.Book;
import com.systechInterns.library.Publisher;

import javax.ejb.EJB;
import java.util.List;

public class GenerateCSV {

    public static String generateCsvFile(List<Book> books) {
        String output = "Book Title , Isbn No, Publisher, Author \n";

        for (Book book : books) {
            output += book.getTitle() + " , " + book.getIsbn() + " , "+ book.getPublisher().getPublisherName()+" , "+ book.getAuthors()+"\n";
        }
        return output;

    }
}