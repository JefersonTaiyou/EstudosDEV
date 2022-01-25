package Exercises;

import java.util.Scanner;
import java.awt.*;

public class ExercicioFixacaoComMetodosApp {

	public static void main(String[] args) {

		Pessoa pessoa = new Pessoa();
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite seu nome completo e dê ENTER: ");		
		pessoa.setNomeCompleto(sc.nextLine());
		System.out.println("Digite seu CPF: ");		
		pessoa.setCpf(sc.next());
		sc.nextLine();
		System.out.println("Digite sua idade: ");		
		pessoa.setIdade(sc.nextInt());
		sc.nextLine();
		System.out.println("Digite seu Sexo(M/F): ");		
		pessoa.setSexo(sc.next().charAt(0));
		sc.nextLine();
		
		
		System.out.println(
				"O portador do CPF: " + pessoa.getCpf() + " se chama "
						+ pessoa.getNomeCompleto() + ", tem " + pessoa.getIdade() 
						+ " anos e é do Sexo: " + pessoa.getSexo());
		
		sc.close();	

	}

}
