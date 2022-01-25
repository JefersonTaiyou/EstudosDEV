package Model;

public class Cursos {

	private int Cod_Curso;
	private String Nome_Curso;
	private String Categoria;
	private int Duracao;
	private String Nivel;
	private String Periodo;
	
	@Override
	public String toString() {
		return Nome_Curso;
	}	
	public String getNome_Curso() {
		return Nome_Curso;
	}
	public void setNome_Curso(String nome_Curso) {
		this.Nome_Curso = nome_Curso;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		this.Categoria = categoria;
	}
	public int getDuracao() {
		return Duracao;
	}
	public void setDuracao(int duracao) {
		this.Duracao = duracao;
	}
	public String getNivel() {
		return Nivel;
	}
	public void setNivel(String nivel) {
		this.Nivel = nivel;
	}
	public String getPeriodo() {
		System.out.println(Periodo);
		return Periodo;
	}
	public void setPeriodo(String periodo) {
		this.Periodo = periodo;
	}
	public int getCod_Curso() {
		return Cod_Curso;
	}
	public void setCod_Curso(int cod_curso) {
		this.Cod_Curso = cod_curso;
	}

}
