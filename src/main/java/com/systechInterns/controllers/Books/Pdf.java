//package com.systechInterns.controllers.Books;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.systechInterns.library.Book;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.util.List;
//
//public class Pdf {
//    public static String generatePdf(List<Book> books){
//        Document document = new Document();
//        try
//        {
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
//            document.open();
//            document.add(new Paragraph("A Hello World PDF document."));
//            document.close();
//            writer.close();
//        } catch (DocumentException e)
//        {
//            e.printStackTrace();
//        } catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        return
//    }
//}
