package com.skh;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.pdfbox.pdmodel.PDDocument.*;

public class ReadPdfAirtel {
    public static void main(String[] args) throws IOException {
        String filePath1 = "C:\\Users\\Dell\\Downloads\\airtel\\9505208500_20260214001280.pdf";
        String filePath2 = "9505208500_20260214001280.pdf";
        read2(filePath1);

    }

    public static void read2(String filePath){
        try (PDDocument document = PDDocument.load(new File(filePath),"19888500")) {

            if (document.isEncrypted()) {

                PDFTextStripper pdfStripper = new PDFTextStripper();
                String text = pdfStripper.getText(document);

                System.out.println("PDF Content:");
                System.out.println(text);

                Pattern pattern = Pattern.compile("\\b\\d{10,}\\b");
                Matcher matcher = pattern.matcher(text);

                List<String> phoneNumbers = new ArrayList<>();


                while (matcher.find()) {
                    phoneNumbers.add(matcher.group());
                }
                System.out.println("Total Numbers captured: "+ phoneNumbers.size());
                System.out.println("Phone Numbers Found:");
//                phoneNumbers.forEach(System.out::println);
                Set<String> st = new HashSet<String>(phoneNumbers);
                for (String s : st)
                    System.out.println(s + ": " + Collections.frequency(phoneNumbers, s));


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
