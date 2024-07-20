package arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EscreveJSON {

	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("22334587699");
		usuario1.setLogin("jojaoo");
		usuario1.setSenha("ff15pls");
		usuario1.setNome("Joao Junior");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("66654321761");
		usuario2.setLogin("fhc2022");
		usuario2.setSenha("altf4monst");
		usuario2.setNome("Fernando Henrique");
		
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\Arthur\\git\\arquivosEmJava\\arquivosEmJava\\src\\arquivos\\filjson.json");
		
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
	}
	
}
