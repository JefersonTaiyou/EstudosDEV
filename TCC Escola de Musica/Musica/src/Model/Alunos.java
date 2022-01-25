package Model;

public class Alunos {
	
	private long Matricula;
	private int Curso,Turma;
	private String CPF,Nome_Aluno, Telefone, Celular, Email,
	Cep, Endereco,Num,Complemento,Bairro,Cidade,Estado,
	Conhecimento,Periodo;
	
	public long getMatricula() {
		return Matricula;
	}
	public void setMatricula(long matricula) {
		this.Matricula = matricula;
	}
	@Override
	public String toString() {
		return Nome_Aluno;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		this.CPF = cPF;
	}
	public String getNome_Aluno() {
		return Nome_Aluno;
	}
	public void setNome_Aluno(String nome_Aluno) {
		this.Nome_Aluno = nome_Aluno;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		this.Telefone = telefone;
	}
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String celular) {
		this.Celular = celular;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		this.Cep = cep;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		this.Endereco = endereco;
	}
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		this.Num = num;
	}
	public String getComplemento() {
		return Complemento;
	}
	public void setComplemento(String complemento) {
		this.Complemento = complemento;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		this.Bairro = bairro;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		this.Cidade = cidade;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		this.Estado = estado;
	}
	public String getConhecimento() {
		return Conhecimento;
	}
	public void setConhecimento(String conhecimento) {
		this.Conhecimento = conhecimento;
	}
	public String getPeriodo() {
		return Periodo;
	}
	public void setPeriodo(String periodo) {
		this.Periodo = periodo;
	}
	public int getCurso() {
		return Curso;
	}
	public void setCurso(int curso) {
		this.Curso = curso;
	}
	public int getTurma() {
		return Turma;
	}
	public void setTurma(int turma) {
		this.Turma = turma;
	}

}
