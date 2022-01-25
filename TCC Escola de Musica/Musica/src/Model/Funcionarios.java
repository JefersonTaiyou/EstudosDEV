package Model;

public class Funcionarios {

	private long Matricula;
	private String CPF,Nome_Func, Telefone, Celular, Email,
	Cep, Endereco,Num,Complemento,Bairro,Cidade,Estado,Categoria1,
	Categoria2,Categoria3,Categoria4,Cargo,Login,Senha;
	
	@Override
	public String toString() {
		return Nome_Func;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		this.CPF = cPF;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		this.Login = login;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		this.Senha = senha;
	}
	public long getMatricula() {
		return Matricula;
	}
	public void setMatricula(long matricula) {
		this.Matricula = matricula;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		this.Cep = cep;
	}
	public String getNome_Func() {
		return Nome_Func;
	}
	public void setNome_Func(String nome_Func) {
		this.Nome_Func = nome_Func;
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
	public String getCategoria1() {
		return Categoria1;
	}
	public void setCategoria1(String categoria1) {
		this.Categoria1 = categoria1;
	}
	public String getCategoria2() {
		return Categoria2;
	}
	public void setCategoria2(String categoria2) {
		this.Categoria2 = categoria2;
	}
	public String getCategoria3() {
		return Categoria3;
	}
	public void setCategoria3(String categoria3) {
		this.Categoria3 = categoria3;
	}
	public String getCategoria4() {
		return Categoria4;
	}
	public void setCategoria4(String categoria4) {
		this.Categoria4 = categoria4;
	}
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		this.Cargo = cargo;
	}
	
	
	
}
