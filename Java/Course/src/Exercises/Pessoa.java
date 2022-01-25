package Exercises;

public class Pessoa {
	
	// Variaveis privadas -----> podem ser acessadas apenas pelos metodos GET e SET
	 private String nomeCompleto, cpf;
	 private int idade;
	 private char sexo;
	
	// Construtor da classe
	
	public Pessoa() {
		this.nomeCompleto=nomeCompleto;
		this.cpf = cpf;
		this.idade=idade;
		this.sexo=sexo;
	}
	
	// Metodos GET
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public String getCpf() {
		return cpf;
	}
	public int getIdade() {
		return idade;
	}
	public char getSexo() {
		return sexo;
	}
	
	// Metodos SET
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto=nomeCompleto;
	}
	public void setCpf(String cpf) {
		this.cpf=cpf;
	}
	public void setIdade(int idade) {
		this.idade=idade;
	}
	public void setSexo(char sexo) {
		this.sexo=sexo;
	}

}
