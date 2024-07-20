package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Arthur\\git\\arquivosEmJava\\arquivosEmJava\\src\\arquivos\\arquivo_excel.xls");
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setNome("Fulano");
		pessoa1.setIdade(30);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setNome("Ciclano");
		pessoa2.setIdade(27);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setNome("Beltrano");
		pessoa3.setIdade(40);
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setEmail("pessoa4@gmail.com");
		pessoa4.setNome("Jeremias");
		pessoa4.setIdade(80);
		
		
		// Pode vir de um banco de dados ou qualquer fonte de dados
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); // Vai ser usado para escrever a planilha
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas JDev Treinamento"); // Cria a planilha
		
		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha++);  // Criando a linha na planilha
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula++); // Celula 1
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula++); // Celula 2
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula++); // Celula 3
			celIdade.setCellValue(p.getIdade());
			
		} // Terminou de montar a planilha
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida); // Escreve planilha em arquivo
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada");
	}
	
}
