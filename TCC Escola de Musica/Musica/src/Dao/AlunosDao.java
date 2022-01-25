package Dao;

import java.sql.*;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Model.Alunos;
import Model.Funcionarios;


public class AlunosDao {

	ConexaoDao c = new ConexaoDao();

	public void Salvar(Alunos aluno) throws SQLException, ClassNotFoundException {
		try {
			String sql = "insert into TB_Aluno(CPF,Nome_aluno,Telefone,Celular,Email,"
					+ "Cep,Endereco,Num,Complemento,Bairro,Cidade,Estado,"
					+ "Conhecimento,Periodo,Curso,Turma) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, aluno.getCPF());
			ps.setString(2, aluno.getNome_Aluno());
			ps.setString(3, aluno.getTelefone());
			ps.setString(4, aluno.getCelular());
			ps.setString(5, aluno.getEmail());
			ps.setString(6, aluno.getCep());
			ps.setString(7, aluno.getEndereco());
			ps.setString(8, aluno.getNum());
			ps.setString(9, aluno.getComplemento());
			ps.setString(10, aluno.getBairro());
			ps.setString(11, aluno.getCidade());
			ps.setString(12, aluno.getEstado());
			ps.setString(13, aluno.getConhecimento());
			ps.setString(14, aluno.getPeriodo());
			ps.setInt(15, aluno.getCurso());
			ps.setInt(16, aluno.getTurma());			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro no insert dos dados");
		}
	}

	public void Alterar(Alunos aluno) throws SQLException, ClassNotFoundException {
		try {
			String sql = "update TB_Aluno Nome_aluno=?,Telefone=?,Celular=?,Email=?,"
					+ "Cep=?,Endereco=?,Num=?,Complemento=?,Bairro=?,Cidade=?,Estado=?,"
					+ "Conhecimento=?,Periodo=?,Curso=?,Turma=?" + "where CPF=? ";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, aluno.getNome_Aluno());
			ps.setString(2, aluno.getTelefone());
			ps.setString(3, aluno.getCelular());
			ps.setString(4, aluno.getEmail());
			ps.setString(5, aluno.getCep());
			ps.setString(6, aluno.getEndereco());
			ps.setString(7, aluno.getNum());
			ps.setString(8, aluno.getComplemento());
			ps.setString(9, aluno.getBairro());
			ps.setString(10, aluno.getCidade());
			ps.setString(11, aluno.getEstado());
			ps.setString(12, aluno.getConhecimento());
			ps.setString(13, aluno.getPeriodo());
			ps.setInt(14, aluno.getCurso());
			ps.setInt(15, aluno.getTurma());
			ps.setString(16, aluno.getCPF());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados");
		}

	}

	public void Excluir(Alunos aluno) throws SQLException, ClassNotFoundException {
		try {
			String sql = " delete TB_Aluno where CPF = ? ";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, aluno.getCPF());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados");
		}

	}
	
	 //Preenche tela quando consulta cpf --- Tela Funcionario
		public Alunos PreencheAluno(Alunos func) throws SQLException, ClassNotFoundException {
			
			try {
				String sql = "select Nome_Aluno,Matricula,Telefone,Celular,Email,"
						+ "Cep,Endereco,Num,Complemento,Bairro,Cidade,Estado from TB_Funcionario "
						+ "where CPF=?";
				PreparedStatement ps = c.getConnection().prepareStatement(sql);
				ps.setString(1, func.getCPF());
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {				
					func.setNome_Aluno(rs.getString("Nome_Aluno"));
					func.setMatricula(rs.getLong("Matricula"));		
					func.setTelefone(rs.getString("Telefone"));
					func.setCelular(rs.getString("Celular"));
					func.setEmail(rs.getString("Email"));
					func.setCep(rs.getString("Cep"));
					func.setEndereco(rs.getString("Endereco"));
					func.setNum(rs.getString("Num"));
					func.setComplemento(rs.getString("Complemento"));
					func.setBairro(rs.getString("Bairro"));
					func.setCidade(rs.getString("Cidade"));
					func.setEstado(rs.getString("Estado"));				
				}
				rs.close();
				ps.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
			return func;
		}

	public Alunos Consulta(Alunos aluno) throws SQLException, ClassNotFoundException {
		try {
			String sql = "select Aluno.Matricula as Matricula, Aluno.CPF as CPF,Aluno.Nome_aluno as Nome_aluno,"
					+ "Aluno.Telefone as Telefone,Aluno.Celular as Celular,Aluno.Email as Email,Aluno.Cep as CEP,"
					+ "Aluno.Endereco as Endereco,Aluno.Num as Num,Aluno.Complemento as Complemento,"
					+ "Aluno.Bairro as Bairro,Aluno.Cidade as Cidade,Aluno.Estado as Estado,"
					+ "Aluno.Conhecimento as Conhecimento,Aluno.Periodo as Periodo,Curso.Curso as Curso,"
					+ "Aluno.Turma as Turma FROM TB_Aluno AS Aluno INNER JOIN TB_Curso AS Curso "
					+ "ON Aluno.Curso = Curso.Cod_curso INNER JOIN  TB_Turma AS Turma "
					+ "ON Aluno.Turma = Turma.Cod_turma  WHERE Aluno.CPF=?";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, aluno.getCPF());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				aluno.setMatricula(rs.getInt("Matricula"));
				aluno.setCPF(rs.getString("CPF"));
				aluno.setNome_Aluno(rs.getString("Nome_aluno"));
				aluno.setTelefone(rs.getString("Telefone"));
				aluno.setCelular(rs.getString("Celular"));
				aluno.setEmail(rs.getString("Email"));
				aluno.setCep(rs.getString("Cep"));
				aluno.setEndereco(rs.getString("Endereco"));
				aluno.setNum(rs.getString("Num"));
				aluno.setComplemento(rs.getString("Complemento"));
				aluno.setBairro(rs.getString("Bairro"));
				aluno.setCidade(rs.getString("Cidade"));
				aluno.setEstado(rs.getString("Estado"));
				aluno.setConhecimento(rs.getString("Conhecimento"));
				aluno.setPeriodo(rs.getString("Periodo"));
				aluno.setCurso(rs.getInt("Curso"));
				aluno.setTurma(rs.getInt("Turma"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados");
		}
		return aluno;
	}

	public int ProximoCod() throws SQLException, ClassNotFoundException {
		try {
			String sql = "select IDENT_CURRENT('TB_Aluno') + 1 as Proxima_Mat";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt("Proxima_Mat");
			} else {
				return 1;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return 0;
	}

	public boolean jaExiste(Alunos aluno) throws SQLException, ClassNotFoundException {
		try {
			String sql = "select * from TB_Aluno where CPF = ?";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, aluno.getCPF());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}

	
}
