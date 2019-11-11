package com.systechInterns.controllers.Books;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.library.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;

@WebServlet(name = "pdf", urlPatterns = "/pdf")
public class PdfServlet extends HttpServlet {

    @EJB
    BookBeanI bookBeanI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf");
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        try
        {
//            List<Book>books = bookBeanI.readAll();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("books.pdf"));
            document.open();

            document.add(new Paragraph("Cool Fam"));
            document.close();
            writer.close();
        } catch (DocumentException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    }
