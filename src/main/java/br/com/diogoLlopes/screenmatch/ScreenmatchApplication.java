package br.com.diogoLlopes.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

<<<<<<< HEAD
import br.com.diogoLlopes.screenmatch.model.DadosSerie;
import br.com.diogoLlopes.screenmatch.service.ConsumoApi;
import br.com.diogoLlopes.screenmatch.service.ConverteDados;
=======
import br.com.diogoLlopes.screenmatch.service.ConsumoApi;
>>>>>>> 105b639 (Incluido Service)

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
<<<<<<< HEAD
		
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
=======
		System.out.println(json);
		
>>>>>>> 105b639 (Incluido Service)
	}

}
