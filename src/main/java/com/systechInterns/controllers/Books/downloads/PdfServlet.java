package com.systechInterns.controllers.Books.downloads;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.controllers.Books.downloads.PDFCreator;
import com.systechInterns.library.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


@WebServlet(name = "downloads", urlPatterns = "/downloads")
public class PdfServlet extends HttpServlet {
    private static final String TITLE = "TestReport";
    public static final String PDF_EXTENSION = ".downloads";

    @EJB
    BookBeanI bookBeanI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Document document = null;
//        try {
//            List<Book> dataObjList = getDataObjectList();
//            //Document is not auto-closable hence need to close it separately
//            document = new Document(PageSize.A4);
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(TITLE + PDF_EXTENSION)));
//            HeaderFooter event = new HeaderFooter();
//
//            event.setHeader("Test Report");
//            writer.setPageEvent(event);
//            document.open();
//            PDFCreator.addMetaData(document, TITLE);
//            PDFCreator.addTitlePage(document, TITLE);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("FileNotFoundException occurs.." + e.getMessage());
//        } finally {
//            if (null != document) {
//                document.close();
//            }
//        }
//    }
//
//
//    public List<Book> getDataObjectList(){
//        List<Book> dataObjList = new ArrayList<>();
//        try{
//           Book d1 = bookBeanI.findAll();
//           d1.setTitle(d1.getTitle());
//           d1.setIsbn(d1.getIsbn());
//           d1.setPublisher(d1.getPublisher());
//           d1.setAuthors(d1.getAuthors());
//
//           dataObjList.add(d1);
//       }catch (Exception e){
//           e.printStackTrace();
//       }
//        return dataObjList;
//    }


        Document document = new Document();
        try{
            Book books = bookBeanI.findAll();
            resp.setContentType("application/pdf");
            PdfWriter.getInstance(document, resp.getOutputStream());
            document.open();
            document.addTitle("ALL BOOKS LIST");
            document.add(new Paragraph("Library Books List"));
//            document.add(new Paragraph(String.valueOf(books)));
            PDFCreator.addContent(document, Collections.singletonList(books));


//            document.add(new Paragraph(new Date().toString()));
            //Add more content here
        }catch(Exception e){
            e.printStackTrace();
        }
        document.close();
    }
    }




