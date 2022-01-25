package View;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;

import Dao.ConexaoDao;
import Dao.CursosDao;
import Model.Cursos;
import javax.swing.table.DefaultTableModel;

import Controller.CursosController;

public class CadCursoNovo extends JDialog {

	JDialog frmCadastroDeCurso;
	private JTextField txtDuracao, txtNome, txtCod;
	private JTable tblCursos;
	private JComboBox cmbPeriodo, cmbCategoria, cmbNivel;
	private JButton btnSalvar, btnAlterar, btnDeletar, btnCancel;
	String categoria, periodo, nivel;
	CursosController cControlerTab = new CursosController(tblCursos);
	Object[] options = { "Sim", "Não" };
	ImageIcon imageSave, imageCancel, imageAlt, imageExcluir;

	public CadCursoNovo(HomePage homePage, boolean modal) {
		super();
		initialize();
	}

	private void initialize() {
		ConexaoDao c = new ConexaoDao();
		try {
			c.getConnection();
		} catch (ClassNotFoundException e3) {
			e3.printStackTrace();
		}
		
		frmCadastroDeCurso = new JDialog();
		frmCadastroDeCurso.setUndecorated(true);
		frmCadastroDeCurso.setResizable(false);
		frmCadastroDeCurso.setModal(true);
		frmCadastroDeCurso.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		frmCadastroDeCurso.setAutoRequestFocus(false);
		frmCadastroDeCurso.setTitle("Cursos");
		frmCadastroDeCurso.getContentPane().setBackground(SystemColor.controlHighlight);
		frmCadastroDeCurso.setBounds(100, 100, 812, 352);
		frmCadastroDeCurso.getContentPane().setLayout(null);
		frmCadastroDeCurso.setLocationRelativeTo(null);
		
		imageSave = new ImageIcon(getClass().getResource("/Imagens/Save.png"));
		imageSave.setImage(imageSave.getImage().getScaledInstance(18, 18, 0));

		imageCancel = new ImageIcon(getClass().getResource("/Imagens/cancel.png"));
		imageCancel.setImage(imageCancel.getImage().getScaledInstance(15, 15, 0));

		imageAlt = new ImageIcon(getClass().getResource("/Imagens/lapis.png"));
		imageAlt.setImage(imageAlt.getImage().getScaledInstance(15, 15, 0));

		imageExcluir = new ImageIcon(getClass().getResource("/Imagens/lixeira.png"));
		imageExcluir.setImage(imageExcluir.getImage().getScaledInstance(15, 15, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(34, 73, 277, 204);
		frmCadastroDeCurso.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(11, 36, 46, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setBounds(12, 85, 63, 16);
		panel.add(lblNewLabel_2);

		JComboBox cmbCategoria = new JComboBox();
		cmbCategoria.setModel(
				new DefaultComboBoxModel(new String[] { "---", "Cordas", "Sopro", "Teclas", "Percuss\u00E3o" }));
		cmbCategoria.setBounds(12, 103, 111, 20);
		panel.add(cmbCategoria);
		cmbCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				categoria = cmbCategoria.getSelectedItem().toString();
			}
		});

		JComboBox cmbNivel = new JComboBox();
		cmbNivel.setModel(
				new DefaultComboBoxModel(new String[] { "---", "B\u00E1sico", "Intermedi\u00E1rio", "Avan\u00E7ado" }));
		cmbNivel.setBounds(12, 152, 111, 20);
		panel.add(cmbNivel);

		cmbNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nivel = cmbNivel.getSelectedItem().toString();
			}
		});

		JLabel lblNewLabel_2_1 = new JLabel("Nivel");
		lblNewLabel_2_1.setBounds(12, 134, 34, 16);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1 = new JLabel("Dura\u00E7\u00E3o Aproximada");
		lblNewLabel_1_1.setBounds(131, 85, 122, 14);
		panel.add(lblNewLabel_1_1);

		txtDuracao = new JTextField();
		txtDuracao.setColumns(10);
		txtDuracao.setBounds(141, 103, 63, 20);
		panel.add(txtDuracao);

		JLabel lblNewLabel_1_1_1 = new JLabel("minutos");
		lblNewLabel_1_1_1.setBounds(204, 106, 50, 14);
		panel.add(lblNewLabel_1_1_1);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(11, 53, 242, 20);
		panel.add(txtNome);

		JLabel lblNewLabel_2_1_1 = new JLabel("Per\u00EDodo");
		lblNewLabel_2_1_1.setBounds(131, 134, 46, 16);
		panel.add(lblNewLabel_2_1_1);

		JComboBox cmbPeriodo = new JComboBox();
		cmbPeriodo.setModel(new DefaultComboBoxModel(new String[] { "---", "Manh\u00E3", "Tarde", "Noite" }));
		cmbPeriodo.setBounds(141, 152, 111, 20);
		panel.add(cmbPeriodo);

		cmbPeriodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				periodo = cmbPeriodo.getSelectedItem().toString();
			}
		});

		JLabel lblNewLabel_1_2 = new JLabel("C\u00F3digo");
		lblNewLabel_1_2.setBounds(142, 24, 46, 14);
		panel.add(lblNewLabel_1_2);

		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setColumns(10);
		txtCod.setBounds(190, 21, 63, 20);
		panel.add(txtCod);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(imageSave);

		btnSalvar.setBounds(189, 296, 107, 26);
		frmCadastroDeCurso.getContentPane().add(btnSalvar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(imageAlt);

		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(333, 296, 107, 26);
		frmCadastroDeCurso.getContentPane().add(btnAlterar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(imageExcluir);

		btnDeletar.setEnabled(false);
		btnDeletar.setBounds(478, 296, 107, 26);
		frmCadastroDeCurso.getContentPane().add(btnDeletar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 59, 459, 218);
		frmCadastroDeCurso.getContentPane().add(scrollPane);

		tblCursos = new JTable();
		tblCursos.setAutoCreateRowSorter(true);
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Cod", "Nome", "Categoria", "N\u00EDvel", "Per\u00EDodo", "Dura\u00E7\u00E3o" });
		scrollPane.setViewportView(tblCursos);
		tblCursos.setModel(modelo);
		tblCursos.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblCursos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblCursos.getColumnModel().getColumn(2).setPreferredWidth(80);
		tblCursos.getColumnModel().getColumn(3).setPreferredWidth(90);
		tblCursos.getColumnModel().getColumn(4).setPreferredWidth(65);
		tblCursos.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		btnCancel = new JButton("Cancelar");
		btnCancel.setIcon(imageCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CursosController cControlerTab = new CursosController(tblCursos);
				if (JOptionPane.showOptionDialog(null, "Deseja mesmo sair?", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
					try {
						frmCadastroDeCurso.dispose();
						btnSalvar.setEnabled(true);
						btnAlterar.setEnabled(false);
						btnDeletar.setEnabled(false);
						LimparCampos();
						cmbPeriodo.setSelectedIndex(0);
						cmbNivel.setSelectedIndex(0);
						cmbCategoria.setSelectedIndex(0);
						ProximoCod();
						cControlerTab.TabelaCursos();

					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnCancel.setBounds(623, 296, 107, 26);
		frmCadastroDeCurso.getContentPane().add(btnCancel);

		try {
			ProximoCod();
		} catch (ClassNotFoundException | SQLException e4) {
			e4.printStackTrace();
		}

		JButton btnNovo = new JButton("Novo");

		btnNovo.setBounds(61, 296, 86, 26);
		frmCadastroDeCurso.getContentPane().add(btnNovo);
		try {
			CursosController cControlerTab = new CursosController(tblCursos);
			
			JLabel lblX = new JLabel();
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblX.setBackground(Color.RED);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblX.setBackground(new Color(77, 20, 52));
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if (JOptionPane.showOptionDialog(null, "Deseja mesmo sair?", "Informação",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
						try {
							frmCadastroDeCurso.dispose();
							btnSalvar.setEnabled(true);
							btnAlterar.setEnabled(false);
							btnDeletar.setEnabled(false);
							LimparCampos();
							cmbPeriodo.setSelectedIndex(0);
							cmbNivel.setSelectedIndex(0);
							cmbCategoria.setSelectedIndex(0);
							ProximoCod();
							cControlerTab.TabelaCursos();

						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				}

		});
			
			lblX.setText("X");
			lblX.setOpaque(true);
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setForeground(Color.WHITE);
			lblX.setFont(new Font("Arial", Font.BOLD, 16));
			lblX.setBackground(new Color(77, 20, 52));
			lblX.setBounds(765, 0, 47, 35);
			frmCadastroDeCurso.getContentPane().add(lblX);
			
			JLabel lblCadastroDeTurmas = new JLabel();
			lblCadastroDeTurmas.setText("Cadastro de Turmas");
			lblCadastroDeTurmas.setOpaque(true);
			lblCadastroDeTurmas.setHorizontalAlignment(SwingConstants.CENTER);
			lblCadastroDeTurmas.setForeground(Color.WHITE);
			lblCadastroDeTurmas.setFont(new Font("Arial", Font.BOLD, 20));
			lblCadastroDeTurmas.setBackground(new Color(77, 20, 52));
			lblCadastroDeTurmas.setBounds(0, 0, 812, 35);
			frmCadastroDeCurso.getContentPane().add(lblCadastroDeTurmas);
			cControlerTab.TabelaCursos();
		} catch (ClassNotFoundException | SQLException e3) {
			e3.printStackTrace();
		}

		tblCursos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tblCursos.getSelectedRow(); // retorna a linha selecionada pelo usuario
				// cod,nome,categoria,nivel,periodo,duracao
				txtCod.setText(tblCursos.getValueAt(linha, 0).toString());
				txtNome.setText(tblCursos.getValueAt(linha, 1).toString());
				cmbCategoria.setSelectedItem(tblCursos.getValueAt(linha, 2).toString());
				cmbNivel.setSelectedItem(tblCursos.getValueAt(linha, 3).toString());
				cmbPeriodo.setSelectedItem(tblCursos.getValueAt(linha, 4).toString());
				txtDuracao.setText(tblCursos.getValueAt(linha, 5).toString());

				btnSalvar.setEnabled(false);
				btnAlterar.setEnabled(true);
				btnDeletar.setEnabled(true);
			}
		});
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Deseja realizar um novo cadastro?", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
					try {
						btnSalvar.setEnabled(true);
						btnAlterar.setEnabled(false);
						btnDeletar.setEnabled(false);
						LimparCampos();
						cmbPeriodo.setSelectedIndex(0);
						cmbNivel.setSelectedIndex(0);
						cmbCategoria.setSelectedIndex(0);
						ProximoCod();

						CursosController cControlerTab = new CursosController(tblCursos);
						cControlerTab.TabelaCursos();

					} catch (ClassNotFoundException | SQLException e2) {
						e2.printStackTrace();
					}
				}
			}
		});

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cursos curso = new Cursos();
				CursosDao cDao = new CursosDao();
				if ((txtNome.getText().isEmpty()) || (txtDuracao.getText().isEmpty()) || nivel == "---"
						|| periodo == "---" || categoria == "---" || nivel == null || periodo == null
						|| categoria == null) {
					JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios", "Erro",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						Salvar();
						LimparCampos();
						cmbPeriodo.setSelectedIndex(0);
						cmbNivel.setSelectedIndex(0);
						cmbCategoria.setSelectedIndex(0);
						ProximoCod();
						CursosController cControlerTab = new CursosController(tblCursos);
						cControlerTab.TabelaCursos();
					} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Deseja Alterar este Cadastro?", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
					if ((txtNome.getText().isEmpty()) || (txtDuracao.getText().isEmpty()) || nivel == "---"
							|| periodo == "---" || categoria == "---" || nivel == null || periodo == null
							|| categoria == null) {
						JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios", "Erro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							Alterar();
							btnSalvar.setEnabled(true);
							btnAlterar.setEnabled(false);
							btnDeletar.setEnabled(false);
							LimparCampos();
							cmbPeriodo.setSelectedIndex(0);
							cmbNivel.setSelectedIndex(0);
							cmbCategoria.setSelectedIndex(0);
							ProximoCod();

							CursosController cControlerTab = new CursosController(tblCursos);
							cControlerTab.TabelaCursos();
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});

		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Deseja excluir este cadastro?", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
					if ((txtNome.getText().isEmpty()) || (txtDuracao.getText().isEmpty()) || nivel == "---"
							|| periodo == "---" || categoria == "---" || nivel == null || periodo == null
							|| categoria == null) {
						JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios", "Erro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							Excluir();
							btnSalvar.setEnabled(true);
							btnAlterar.setEnabled(false);
							btnDeletar.setEnabled(false);
							LimparCampos();
							cmbPeriodo.setSelectedIndex(0);
							cmbNivel.setSelectedIndex(0);
							cmbCategoria.setSelectedIndex(0);
							ProximoCod();

							CursosController cControlerTab = new CursosController(tblCursos);
							cControlerTab.TabelaCursos();
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}

			}
		});

	}

	public int ProximoCod() throws SQLException, ClassNotFoundException {
		try {
			CursosDao cDao = new CursosDao();
			txtCod.setText(String.valueOf(cDao.ProximoCod()));
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro Traz CodCurso");
		}
		return 0;
	}

	private void LimparCampos() {
		txtNome.setText("");
		txtDuracao.setText("");
	}

	private void Salvar() {
		try {
			Cursos curso = new Cursos();
			CursosDao cDao = new CursosDao();
			curso.setNome_Curso(txtNome.getText());
			curso.setCategoria(categoria);
			curso.setDuracao(Integer.parseInt(txtDuracao.getText()));
			curso.setNivel(nivel);
			curso.setPeriodo(periodo);

			if (cDao.jaExiste(curso)) {
				JOptionPane.showMessageDialog(null, "Dados já Cadastrados", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				cDao.CadCursos(curso);
			}

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}

	private void Alterar() {
		try {
			Cursos curso = new Cursos();
			curso.setCod_Curso(Integer.parseInt(txtCod.getText()));
			curso.setNome_Curso(txtNome.getText());
			curso.setCategoria(categoria);
			curso.setDuracao(Integer.parseInt(txtDuracao.getText()));
			curso.setNivel(nivel);
			curso.setPeriodo(periodo);

			CursosDao cDao = new CursosDao();
			cDao.AltCursos(curso);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}

	private void Excluir() {
		try {
			Cursos curso = new Cursos();
			curso.setCod_Curso(Integer.parseInt(txtCod.getText()));

			CursosDao cDao = new CursosDao();
			cDao.ExcCursos(curso);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}
}
