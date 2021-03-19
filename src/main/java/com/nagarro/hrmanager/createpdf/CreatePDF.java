package com.nagarro.hrmanager.createpdf;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nagarro.hrmanager.entity.Employee;

public class CreatePDF {
	
	private List<Employee> listEmployee;
	
	public CreatePDF(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}
	
	private void tableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(3);
		
		 Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("Employee Code", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Employee Name", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Employee Location", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Employee Email", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Employee Date Of Birth", font));
	        table.addCell(cell); 
		
	}
	
	
	private void tableData(PdfPTable table) {
		
		for(Employee employee:listEmployee) {
			table.addCell(String.valueOf(employee.getEmployeeCode()));
			table.addCell(employee.getEmployeeName());
			table.addCell(employee.getEmployeeLocation());
			table.addCell(employee.getEmployeeEmail());
			table.addCell(employee.getEmployeeDateOfBirth());
		}
		
	}
	
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setSize(15);
		font.setColor(Color.BLUE);
		
		
		Paragraph paragraph = new Paragraph("Employee List",font);
		paragraph.setAlignment(paragraph.ALIGN_CENTER);
		
		document.add(paragraph);
		
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
		table.setSpacingBefore(10);
		
		tableHeader(table);
		tableData(table);
		
		document.add(table);
		document.close();
		
	}
	
}
