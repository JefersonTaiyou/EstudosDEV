package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.FuncionariosDao;
import Model.Cursos;
import Model.Funcionarios;

public class FuncionariosDao {

	ConexaoDao c = new ConexaoDao();

	public void Salvar(Funcionarios func) throws SQLException, ClassNotFoundException {
		try {
			String sql = "insert into TB_Funcionario(CPF,Nome_Func,Telefone,Celular,Email,"
					+ "Cep,Endereco,Num,Complemento,Bairro,Cidade,Estado,"
					+ "Categoria1,Categoria2,Categoria3,Categoria4,Cargo) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getCPF());
			ps.setString(2, func.getNome_Func());
			ps.setString(3, func.getTelefone());
			ps.setString(4, func.getCelular());
			ps.setString(5, func.getEmail());
			ps.setString(6, func.getCep());
			ps.setString(7, func.getEndereco());
			ps.setString(8, func.getNum());
			ps.setString(9, func.getComplemento());
			ps.setString(10, func.getBairro());
			ps.setString(11, func.getCidade());
			ps.setString(12, func.getEstado());
			ps.setString(13, func.getCategoria1());
			ps.setString(14, func.getCategoria2());
			ps.setString(15, func.getCategoria3());
			ps.setString(16, func.getCategoria4());
			ps.setString(17, func.getCargo());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void Alterar(Funcionarios func) throws SQLException, ClassNotFoundException {
		try {
			String sql = "update TB_Funcionario set Nome_Func=?,Telefone=?,Celular=?,Email=?,"
					+ "Cep=?,Endereco=?,Num=?,Complemento=?,Bairro=?,Cidade=?,Estado=? where CPF=? ";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getNome_Func());
			ps.setString(2, func.getTelefone());
			ps.setString(3, func.getCelular());
			ps.setString(4, func.getEmail());
			ps.setString(5, func.getCep());
			ps.setString(6, func.getEndereco());
			ps.setString(7, func.getNum());
			ps.setString(8, func.getComplemento());
			ps.setString(9, func.getBairro());
			ps.setString(10, func.getCidade());
			ps.setString(11, func.getEstado());
			ps.setString(12, func.getCPF());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void Excluir(Funcionarios func) throws SQLException, ClassNotFoundException {
		try {
			String sql = " delete TB_Funcionario where CPF = ? ";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getCPF());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	
	//List para preencher o combobox de funcionarios da tela User
	public List<Funcionarios> recuperarFuncPorNome() throws SQLException, ClassNotFoundException {
		String sql = "select Nome_Func from TB_Funcionario";
		PreparedStatement ps = c.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Funcionarios> ListaFunc = new ArrayList<Funcionarios>();
        while (rs.next()) {
        	ListaFunc.add(recuperarObjeto(rs));
        }
        rs.close();
        ps.close();
        return ListaFunc;
    }
	
	

    private Funcionarios recuperarObjeto(ResultSet rs) throws SQLException {
    	Funcionarios func = new Funcionarios();
    	func.setNome_Func(rs.getString("Nome_Func"));  
        return func;
    }
    
    //Preenche tela quando consulta cpf --- Tela Funcionario
	public Funcionarios PreencheFunc(Funcionarios func) throws SQLException, ClassNotFoundException {
		
		try {
			String sql = "select Nome_Func,Matricula,Telefone,Celular,Email,"
					+ "Cep,Endereco,Num,Complemento,Bairro,Cidade,Estado from TB_Funcionario "
					+ "where CPF=?";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getCPF());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {				
				func.setNome_Func(rs.getString("Nome_Func"));
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
	
	//Preenche tela pesquisando nome func na lista ---- Tela Home
	public Funcionarios PreencheDados(Funcionarios func) throws SQLException, ClassNotFoundException {
		
		try {
			String sql = "select CPF,Matricula,Telefone,Celular,Email,"
					+ "Cep,Endereco,Num,Complemento,Bairro,Cidade,Estado from TB_Funcionario "
					+ "where Nome_Func=?";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getNome_Func());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				func.setMatricula(rs.getLong("Matricula"));				
				func.setCPF(rs.getString("CPF"));			
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

	public boolean jaExiste(Funcionarios func) throws SQLException, ClassNotFoundException {
		try {
			String sql = "select * from TB_Funcionario where CPF = ?";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getCPF());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}
	public boolean jaExisteUser(Funcionarios func) throws SQLException, ClassNotFoundException {
		try {
			String sql = "SELECT U.CPF AS [CPF], F.MATRICULA AS [MATRICULA], F.CARGO AS [CARGO], U.USUARIO AS [USUARIO], U.SENHA AS [SENHA] "
					+ "FROM USUARIO AS U INNER JOIN TB_FUNCIONARIO AS F ON U.CPF = F.CPF WHERE F.NOME_FUNC= ?";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getNome_Func());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}

	public void SalvarUser(Funcionarios func) throws SQLException, ClassNotFoundException {
		try {
			String sql = "insert into Usuario(CPF,Usuario,Senha)"
					+ "values(?,?,?)";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getCPF());
			ps.setString(2, func.getLogin());
			ps.setString(3, func.getSenha());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e,"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void ExcluirUser(Funcionarios func) throws SQLException, ClassNotFoundException {
		try {
			String sql = " delete Usuario where CPF = ? ";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getCPF());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e,"Erro", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void ResetSenha(Funcionarios func) throws SQLException, ClassNotFoundException {
		try {
			String sql = "update Usuario set Senha='Vazio' where CPF=? ";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getCPF());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	
public Funcionarios PreencheUser(Funcionarios func) throws SQLException, ClassNotFoundException {
		
		try {
			String sql = "SELECT U.CPF AS [CPF], F.MATRICULA AS [MATRICULA], F.CARGO AS [CARGO], U.USUARIO AS [USUARIO], U.SENHA AS [SENHA] "
					+ "FROM USUARIO AS U INNER JOIN TB_FUNCIONARIO AS F ON U.CPF = F.CPF WHERE F.NOME_FUNC= ?";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ps.setString(1, func.getNome_Func());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
							
				func.setCPF(rs.getString("CPF"));
				func.setMatricula(rs.getLong("MATRICULA"));	
				func.setCargo(rs.getString("CARGO"));
				func.setLogin(rs.getString("USUARIO"));
				func.setSenha(rs.getString("SENHA"));
				
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return func;
	}

public List<Funcionarios> ConsultaUser() throws SQLException, ClassNotFoundException {
	List<Funcionarios> ListaUser = new ArrayList<Funcionarios>();
	String sql = "SELECT F.NOME_FUNC AS [NOME], U.CPF AS [CPF], F.MATRICULA AS [MATRICULA], F.CARGO AS [CARGO], U.USUARIO AS [USUARIO]"
			+ "FROM USUARIO AS U INNER JOIN TB_FUNCIONARIO AS F ON U.CPF = F.CPF";
	PreparedStatement ps = c.getConnection().prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		Funcionarios user = new Funcionarios();
		user.setNome_Func(rs.getString("NOME"));
		user.setCPF(rs.getString("CPF"));
		user.setMatricula(rs.getLong("MATRICULA"));
		user.setCargo(rs.getString("CARGO"));
		user.setLogin(rs.getString("USUARIO"));		
		ListaUser.add(user);			
	}
	rs.close();
	ps.close();
	return ListaUser;
}

public boolean CheckLogin(Funcionarios func) throws SQLException, ClassNotFoundException {
	try {
		String sql = "SELECT * FROM USUARIO WHERE USUARIO= ? AND SENHA=?";
		PreparedStatement ps = c.getConnection().prepareStatement(sql);
		ps.setString(1, func.getLogin());
		ps.setString(2, func.getSenha());
		ResultSet rs = ps.executeQuery();
		return rs.next();
	} catch (SQLException u) {
		throw new RuntimeException(u);
	}

}
	
}
