package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Dao.FuncionariosDao;
import Model.Funcionarios;

public class UserController {

	private JTable tbUser;

	public UserController(JTable tbuser) {
		this.tbUser = tbuser;
	}
	public void TabelaUser() throws SQLException, ClassNotFoundException {
		if (tbUser != null) {
			DefaultTableModel modelo = (DefaultTableModel) tbUser.getModel();

			if (modelo.getRowCount() > 0) {
				modelo.setRowCount(0);
			}
			try {
				FuncionariosDao fDao = new FuncionariosDao();
				List<Funcionarios> listUser = fDao.ConsultaUser();
				for (Funcionarios u : listUser) {
					// nome,cpf,matricula,cargo,login
					Object[] linha = new Object[5];
					linha[0] = u.getNome_Func();
					linha[1] = u.getCPF();
					linha[2] = u.getMatricula();
					linha[3] = u.getCargo();
					linha[4] = u.getLogin();
					modelo.addRow(linha);
				}
			} catch (SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		}
	}

}