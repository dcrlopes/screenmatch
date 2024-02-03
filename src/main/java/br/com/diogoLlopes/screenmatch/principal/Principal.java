package br.com.diogoLlopes.screenmatch.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.diogoLlopes.screenmatch.model.DadosEpisodio;
import br.com.diogoLlopes.screenmatch.model.DadosSerie;
import br.com.diogoLlopes.screenmatch.model.DadosTemporada;
import br.com.diogoLlopes.screenmatch.service.ConsumoApi;
import br.com.diogoLlopes.screenmatch.service.ConverteDados;

public class Principal {

	private Scanner leitura = new Scanner(System.in);
	private ConsumoApi consumo = new ConsumoApi();
	
	private final String ENDERECO = "https://www.omdbapi.com/?t=";
	private final String API_KEY = "&apikey=6585022c";
	
	public void exibeMenu() {
		System.out.println("Digite o nome da série para busca");
		var nomeSerie = leitura.nextLine();
		var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		
		List<DadosTemporada> temporadas = new ArrayList<>();
		
		for(int i=1; i<=dados.totalTemporadas(); i++) {
			json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		
			
		
		temporadas.forEach(System.out::println);
		
		temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
		
		
		
	}
}
