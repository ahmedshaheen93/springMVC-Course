package com.shaheen.view;


import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.shaheen.model.User;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class UserReport extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<User> users = (List<User>) map.get("users");
        Table table = new Table(4);
        table.setAutoFillEmptyCells(true);
        table.setTableFitsPage(true);
        table.setGrayFill(12);
        table.addCell("#");
        table.addCell("First Name");
        table.addCell("Last Name");
        table.addCell("Salary");
        int i = 0;
        for (User user : users) {
            table.addCell("" + i++);
            table.addCell(user.getFirstName());
            table.addCell(user.getLastName());
            table.addCell("" + user.getSalary());
        }
        document.addTitle("user report");
        document.add(table);
    }

}
