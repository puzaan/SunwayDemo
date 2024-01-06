package com.example.SunwayDemo.util;

import com.example.SunwayDemo.Canteen.dto.foodDto.FoodDto;
import com.example.SunwayDemo.Canteen.entity.foodEntity.Food;
import com.example.SunwayDemo.Canteen.service.foodService.FoodService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfGenerator {
    @Autowired
    private FoodService foodService;
    private final static String rootPath = new AttachmentStorageProperties().getPATH();

    private final static String logoPath = "src/main/java/com/example/SunwayDemo/attachment/logo.jpg";
    public Boolean generatePdf(String text, String filename) throws IOException, DocumentException {

        List<FoodDto> foodDtoList = foodService.getAllFood();


        // create a new PDF document
        Document document = new Document();
        // create a PdfWriter instance to write to the document
        PdfWriter.getInstance(document, new FileOutputStream(new File(rootPath, filename)));

        // open the document
        document.open();

        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_BOLD);

        Font normalText = FontFactory.getFont(FontFactory.COURIER, 15);
        fontTiltle.setSize(20);
        Paragraph paragraph = new Paragraph("ABCD Restaurant ", fontTiltle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph paragraph4 = new Paragraph("Gokarneshwor, Bhumisthali"+"\n"+"3/15/12 at 6:06:44 PM"+"\n"+"Table No. 2   Bill No. 101" +
                "\n" + "List Of Food" + "\n"+ "\n", normalText);
        paragraph4.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph);
        document.add(paragraph4);

        // Creating a table of 4 columns
        PdfPTable table = new PdfPTable(4);

        // Setting width of table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[] { 3, 3, 3, 3 });
        table.setSpacingBefore(4);

        // Create Table Cells for table header
        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding
        cell.setBackgroundColor(CMYKColor.BLACK);
        cell.setPadding(5);

        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);

        // Adding headings in the created table cell/ header
        // Adding Cell to table
        cell.setPhrase(new Phrase("Food Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Quantity", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Rate", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Total", font));
        table.addCell(cell);

        for (FoodDto foodList : foodDtoList) {
            // Adding student id
            table.addCell(String.valueOf(foodList.getFoodName()));
            // Adding student name
            table.addCell(String.valueOf(foodList.getQuantity()));
            // Adding student section
            table.addCell(String.valueOf(foodList.getPrice()));
            Integer totalprice = foodList.getQuantity() * foodList.getPrice();
            table.addCell(String.valueOf(totalprice));
        }



        PdfPTable table2 = new PdfPTable(2);

        // Setting width of table, its columns and spacing
        table2.setWidthPercentage(100f);
        table2.setWidths(new int[] { 3, 3 });
        table2.setSpacingBefore(4);

        // Create Table Cells for table header
        PdfPCell cell2 = new PdfPCell();

        cell.setPhrase(new Phrase("Total Price", font));
        table.addCell(cell2);
        cell.setPhrase(new Phrase("Quantity", font));
        table.addCell(cell2);




        // Adding the created table to document
        document.add(table);
        document.add(table2);


        Paragraph paragraph2 = new Paragraph("\n \n THANK YOU FOR DINING WITH US!\n" +
                "PLEASE COME AGAIN", normalText);
        paragraph2.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph2);

        // close the document
        document.close();
        return true;
    }
}
