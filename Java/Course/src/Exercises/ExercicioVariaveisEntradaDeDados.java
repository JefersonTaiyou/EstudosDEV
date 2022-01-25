package Exercises;

import java.util.Scanner;

public class ExercicioVariaveisEntradaDeDados {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite seu nome completo e dê ENTER: ");		
		String nomeCompleto = sc.nextLine();

			System.out.println("Você digitou: " + nomeCompleto);
				
		sc.close();
	}

}
