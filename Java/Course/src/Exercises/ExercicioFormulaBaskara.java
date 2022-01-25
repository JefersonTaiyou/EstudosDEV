package Exercises;

public class ExercicioFormulaBaskara {

	public static void main(String[] args) {
		
		double a = 1.0, b = -3.0, c = -1.0, x1,x2;

		x1 = (-b + Math.sqrt(b * b - 4 * a * c))/(2*a);
		x2 = (-b - Math.sqrt(b * b - 4 * a * c))/(2*a);
		
		System.out.printf("X1 = %.2f%nX2 = %.2f",x1,x2);

	}

}
