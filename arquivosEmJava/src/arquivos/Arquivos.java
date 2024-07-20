package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {
		
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
		
		
		// Pode vir de um banco de dados ou qualquer fonte de dados
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		
		File arquivo = new File("C:\\Users\\Arthur\\git\\arquivosEmJava\\arquivosEmJava\\src\\arquivos\\arquivos.csv");
		
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		
		for (Pessoa p : pessoas) {
			
			escrever_no_arquivo.write(p.getNome() + "; " + p.getEmail() + "; " + p.getIdade() + "\n");
		}
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
		
	}
	
}
