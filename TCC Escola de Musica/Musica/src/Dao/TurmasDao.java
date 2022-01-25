package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Cursos;
import Model.Funcionarios;
import Model.Turmas;
import Model.cNivel;
import Model.cPeriodo;

public class TurmasDao {

	ConexaoDao c = new ConexaoDao();
	

	public void Salvar(Turmas func) throws SQLException, ClassNotFoundException {
		try {
			String sql = "insert into TB_Funcionario(CPF,Nome_Func,Telefone,Celular,Email,"
					+ "Cep,Endereco,Num,Complemento,Bairro,Cidade,Estado,"
					+ "Categoria1,Categoria2,Categoria3,Categoria4,Cargo) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getCurso());
			ps.setString(2, func.getProfessor());
			ps.setString(3, func.getNivel());
			ps.setString(4, func.getTurma());
			ps.setString(5, func.getPeriodo());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void Excluir(Turmas func) throws SQLException, ClassNotFoundException {
		try {
			String sql = " delete TB_Funcionario where CPF = ? ";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getTurma());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

		public List<Funcionarios> recuperarFuncPorNome() throws SQLException, ClassNotFoundException {
			String Cargo = "Professor";
			String sql = "select Nome_Func from TB_Funcionario where cargo=?";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, Cargo);
			ResultSet rs = ps.executeQuery();

			List<Funcionarios> ListaFunc = new ArrayList<Funcionarios>();
	        while (rs.next()) {
	        	ListaFunc.add(recuperarObjetoFunc(rs));
	        }
	        rs.close();
	        ps.close();
	        return ListaFunc;
	    }
		private Funcionarios recuperarObjetoFunc(ResultSet rs) throws SQLException {

			Funcionarios func = new Funcionarios();
	    	func.setNome_Func(rs.getString("Nome_Func"));  
	        return func;
	    }
		
		public List<Cursos> recuperarCursoPorNome() throws SQLException, ClassNotFoundException {			
			String sql = "Select distinct Nome_Curso from TB_Curso";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			List<Cursos> ListaFunc = new ArrayList<Cursos>();
	        while (rs.next()) {
	        	ListaFunc.add(recuperarObjetoCurso(rs));
	        }
	        rs.close();
	        ps.close();
	        return ListaFunc;
	    }
		private Cursos recuperarObjetoCurso(ResultSet rs) throws SQLException {
			Cursos curso = new Cursos();
			curso.setNome_Curso(rs.getString("Nome_Curso"));  
	        return curso;
	    }
		
		public List<cPeriodo> recuperarPeriodoCurso() throws SQLException, ClassNotFoundException {
			Cursos curso = new Cursos();
			String sql = "select Periodo from TB_Curso where Nome_Curso=?";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, curso.getNome_Curso());
			ResultSet rs = ps.executeQuery();

			List<cPeriodo> ListaFunc = new ArrayList<cPeriodo>();
	        while (rs.next()) {
	        	ListaFunc.add(recuperarObjetoPeriodo(rs));
	        }
	        rs.close();
	        ps.close();
	        return ListaFunc;
	    }
		private cPeriodo recuperarObjetoPeriodo(ResultSet rs) throws SQLException {
			cPeriodo periodo = new cPeriodo();
	    	periodo.setPeriodo(rs.getString("Periodo").toString()); 
	        return periodo;
	    }
		
		public List<cNivel> recuperarNivelCurso() throws SQLException, ClassNotFoundException {
			Cursos curso = new Cursos();
			String sql = "select Nivel from TB_Curso where periodo = "
					+ "(select Periodo from TB_Curso where Nome_Curso=?) and Nome_curso=?";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, curso.getNome_Curso());
			ps.setString(2, curso.getNome_Curso());
			ResultSet rs = ps.executeQuery();

			List<cNivel> ListaFunc = new ArrayList<cNivel>();
	        while (rs.next()) {
	        	ListaFunc.add(recuperarObjetoNivel(rs));
	        }
	        rs.close();
	        ps.close();
	        return ListaFunc;
	    }
		private cNivel recuperarObjetoNivel(ResultSet rs) throws SQLException {
			cNivel nivel = new cNivel();
	    	nivel.setNivel(rs.getString("Nivel").toString());  
	        return nivel;
	    }

	

	public int ProximoCod() throws SQLException, ClassNotFoundException {
		try {
			String sql = "select IDENT_CURRENT('TB_Funcionario') + 1 as Proxima_Mat";
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

	public boolean jaExiste(Turmas func) throws SQLException, ClassNotFoundException {
		try {
			String sql = "select * from TB_Funcionario where CPF = ?";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getCod_turma());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}

}
