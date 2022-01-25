package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Dao.CursosDao;
import Model.Cursos;

public class CursosController {

	private JTable tbcursos;

	public CursosController(JTable tbCursos) {
		this.tbcursos = tbCursos;
	}
	public void TabelaCursos() throws SQLException, ClassNotFoundException {
		if (tbcursos != null) {
			DefaultTableModel modelo = (DefaultTableModel) tbcursos.getModel();

			if (modelo.getRowCount() > 0) {
				modelo.setRowCount(0);
			}
			try {
				CursosDao cDao = new CursosDao();
				List<Cursos> listCursos = cDao.ConsultaCursos();
				for (Cursos c : listCursos) {
					// cod,nome,categoria,nivel,periodo,duracao
					Object[] linha = new Object[6];
					linha[0] = c.getCod_Curso();
					linha[1] = c.getNome_Curso();
					linha[2] = c.getCategoria();
					linha[3] = c.getNivel();
					linha[4] = c.getPeriodo();
					linha[5] = c.getDuracao();

					modelo.addRow(linha);
				}
			} catch (SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		}
	}

}