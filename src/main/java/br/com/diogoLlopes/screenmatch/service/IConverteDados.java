package br.com.diogoLlopes.screenmatch.service;

public interface IConverteDados {

	<T> T obterDados(String json, Class<T> classe);
	
}
