package Dao;

import java.sql.*;
import java.util.*;
import Dao.CursosDao;
import Model.Cursos;

public class CursosDao{
	
	ConexaoDao c = new ConexaoDao(); 

	public void CadCursos(Cursos curso) throws SQLException, ClassNotFoundException{
		try {
			String sql = "insert into TB_Curso(Nome_curso,Categoria,Duracao,Nivel,Periodo) values(?,?,?,?,?)";
						PreparedStatement ps =  c.getConnection().prepareStatement(sql);
						ps.setString(1, curso.getNome_Curso());
						ps.setString(2, curso.getCategoria());
						ps.setInt(3, curso.getDuracao());
						ps.setString(4, curso.getNivel());
						ps.setString(5, curso.getPeriodo());
						ps.execute();
						ps.close();	
		} catch (SQLException e){
			 System.out.println("Erro no insert dos dados");		
		}
	}

	public void AltCursos(Cursos curso) throws SQLException, ClassNotFoundException {
		String sql = "update TB_Curso set Nome_curso = ?, Categoria = ? , Duracao = ? , Nivel = ? , Periodo = ?"
				+ "where Cod_curso = ? ";
		PreparedStatement ps = c.getConnection().prepareStatement(sql);
		ps.setString(1, curso.getNome_Curso());
		ps.setObject(2, curso.getCategoria());
		ps.setInt(3, curso.getDuracao());
		ps.setObject(4, curso.getNivel());
		ps.setObject(5, curso.getPeriodo());
		ps.setInt(6, curso.getCod_Curso());
		ps.execute();
		ps.close();		
	}

	public void ExcCursos(Cursos curso) throws SQLException, ClassNotFoundException {
		String sql = " delete TB_Curso where Cod_curso = ? ";
		PreparedStatement ps = c.getConnection().prepareStatement(sql);
		ps.setInt(1, curso.getCod_Curso());
		ps.execute();
		ps.close();		
	}

	
	
	public boolean jaExiste(Cursos curso) throws SQLException, ClassNotFoundException {
	    try {
	    	String sql = "select Cod_Curso from TB_Curso where Nome_curso = ? and Categoria = ? and Nivel = ? and Periodo = ?";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, curso.getNome_Curso());
			ps.setObject(2, curso.getCategoria());
			ps.setObject(3, curso.getNivel());
			ps.setObject(4, curso.getPeriodo());
			ResultSet rs = ps.executeQuery();
	        return rs.next();
	    } catch (SQLException u) {
	        throw new RuntimeException(u);
	    }
	    
	}

	public List<Cursos> ConsultaCursos() throws SQLException, ClassNotFoundException {
		List<Cursos> ListaCursos = new ArrayList<Cursos>();
		String sql = "select Cod_Curso, Nome_curso,Categoria,Duracao,Nivel,Periodo from TB_Curso";
		PreparedStatement ps = c.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Cursos curso = new Cursos();
			curso.setCod_Curso(rs.getInt("Cod_Curso"));
			curso.setNome_Curso(rs.getString("Nome_Curso"));
			curso.setCategoria(rs.getString("Categoria"));
			curso.setDuracao(rs.getInt("Duracao"));
			curso.setNivel(rs.getString("Nivel"));
			curso.setPeriodo(rs.getString("Periodo"));
			
			ListaCursos.add(curso);			
		}
		rs.close();
		ps.close();
		return ListaCursos;
	}

	public int ProximoCod() throws SQLException, ClassNotFoundException{
		try {
			String sql = "select IDENT_CURRENT('TB_Curso') + 1 as Proximo_Cod";
			PreparedStatement ps = c.getConnection().
			prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("proximo_cod");					
			}else {
				return 1;
			}
		} catch (SQLException e) {
			System.out.println("Erro Traz CodCurso");
		}
		return 0;
	}
	
	

}
