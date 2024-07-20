package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachPoiEditando {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\\\Users\\\\Arthur\\\\git\\\\arquivosEmJava\\\\arquivosEmJava\\\\src\\\\arquivos\\\\arquivo_excel.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkBook = new HSSFWorkbook(entrada);
		HSSFSheet planilha = hssfWorkBook.getSheetAt(0);
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		
		while (linhaIterator.hasNext()) {
			Row linha = linhaIterator.next();
			
			int numeroCelulas = linha.getPhysicalNumberOfCells();
			
			Cell cell = linha.createCell(numeroCelulas);
			cell.setCellValue("5.387,20");
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkBook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada ");
		
	}
	
}
