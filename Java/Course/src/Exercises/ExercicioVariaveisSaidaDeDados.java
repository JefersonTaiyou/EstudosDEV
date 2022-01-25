package Exercises;

import java.util.Locale;

public class ExercicioVariaveisSaidaDeDados {

	public static void main(String[] args) {
				
		String product1 = "Computador";
		String product2 = "Mesa de escritorio";
		
		int age = 30;
		int code = 5290;
		char gender = 'F';
		
		double price1 = 2100.0;
		double price2 = 650.50;
		double measure = 53.234567;

		System.out.printf("Produtos:%n%s, cujo preço é de $%.2f", product1, price1);
		System.out.printf("%n%s, cujo preço é de $%.2f", product2, price2);
		
		System.out.printf("%n%nRegistro: %d anos, código: %d e gênero: %c", age,code,gender);

		System.out.printf("%nNúmero com oito casas decimais: %.8f", measure);
		System.out.printf("%nNúmero com 3 casas decimais: %.3f", measure);
		
		Locale.setDefault(Locale.US);
		System.out.printf("%nPonto decimal dos EUA: %.3f", measure);
		

	}

}
