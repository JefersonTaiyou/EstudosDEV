package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import Controller.CursosController;
import Controller.UserController;
import Dao.ConexaoDao;
import Dao.FuncionariosDao;
import Model.Funcionarios;
import Model.TxtSomenteNum;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CadUser extends JDialog {

	JDialog frmCadUser;
	private JTextField txtLogin, txtSenha, txtMat, txtCPF, txtCargo;
	private JComboBox cmbFunc;
	private JTable tbUser;
	private JButton btnSalvar, btnReset, btnExcluir;
	private DefaultComboBoxModel defaultComboBox;
	String Funcionario;

	ConexaoDao c = new ConexaoDao();
	Funcionarios func = new Funcionarios();
	FuncionariosDao fDao = new FuncionariosDao();
	private JLabel lblCadastroDeTurmas;
	private JLabel lblX;
	private ImageIcon imageAdd, imageAlt, imageExcluir, imageSave, imageBack;

	public CadUser(HomePage homePage, boolean modal) {
		super();
		initialize();
	}

	private void initialize() {
		frmCadUser = new JDialog();
		frmCadUser.setUndecorated(true);
		frmCadUser.setAutoRequestFocus(false);
		frmCadUser.getContentPane().setEnabled(false);
		frmCadUser.setModal(true);
		frmCadUser.setResizable(false);
		frmCadUser.setBounds(0, -14, 721, 306);
		frmCadUser.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		frmCadUser.getContentPane().setLayout(null);
		frmCadUser.setLocationRelativeTo(null);

		// Icone dos botões -----------------------------------------

		imageAdd = new ImageIcon(getClass().getResource("/Imagens/red plus.png"));
		imageAdd.setImage(imageAdd.getImage().getScaledInstance(15, 15, 0));

		imageBack = new ImageIcon(getClass().getResource("/Imagens/Fundo2.png"));
		imageBack.setImage(imageBack.getImage().getScaledInstance(393, 290, 0));

		imageSave = new ImageIcon(getClass().getResource("/Imagens/Save.png"));
		imageSave.setImage(imageSave.getImage().getScaledInstance(18, 18, 0));

		imageAlt = new ImageIcon(getClass().getResource("/Imagens/lapis.png"));
		imageAlt.setImage(imageAlt.getImage().getScaledInstance(15, 15, 0));

		imageExcluir = new ImageIcon(getClass().getResource("/Imagens/lixeira.png"));
		imageExcluir.setImage(imageExcluir.getImage().getScaledInstance(15, 15, 0));

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "CPF", "Mat", "Cargo", "Login" });

		PreencherList();

		try {

			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlHighlight);
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBounds(0, 0, 721, 306);
			frmCadUser.getContentPane().add(panel);
			panel.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(355, 81, 332, 172);
			panel.add(scrollPane);

			tbUser = new JTable();
			tbUser.setFillsViewportHeight(true);
			tbUser.setAutoCreateRowSorter(true);
			scrollPane.setViewportView(tbUser);
			tbUser.setModel(modelo);
			tbUser.getColumnModel().getColumn(0).setPreferredWidth(120);
			tbUser.getColumnModel().getColumn(1).setPreferredWidth(100);
			tbUser.getColumnModel().getColumn(2).setPreferredWidth(50);
			tbUser.getColumnModel().getColumn(3).setPreferredWidth(90);
			tbUser.getColumnModel().getColumn(4).setPreferredWidth(65);
			tbUser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

			tbUser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int linha = tbUser.getSelectedRow(); // retorna a linha selecionada pelo usuario
					// nome,cpf,matricula,cargo,login
					cmbFunc.setSelectedItem(tbUser.getValueAt(linha, 0).toString());
					txtCPF.setText(tbUser.getValueAt(linha, 1).toString());
					txtMat.setText(tbUser.getValueAt(linha, 2).toString());
					txtCargo.setText(tbUser.getValueAt(linha, 3).toString());
					txtLogin.setText(tbUser.getValueAt(linha, 4).toString());
					btnSalvar.setText("Salvar");
					btnSalvar.setIcon(imageSave);
					btnSalvar.setEnabled(false);
					btnExcluir.setEnabled(true);
					btnReset.setVisible(true);
				}
			});
			UserController cControlerTab = new UserController(tbUser);

			btnSalvar = new JButton("Novo");
			btnSalvar.setBounds(355, 265, 102, 26);
			panel.add(btnSalvar);

			btnExcluir = new JButton("Excluir");
			btnExcluir.setBounds(475, 265, 102, 26);
			btnExcluir.setIcon(imageExcluir);
			panel.add(btnExcluir);
			btnExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Excluir();
						UserController cControlerTab = new UserController(tbUser);
						cControlerTab.TabelaUser();
						Limpar();
					} catch (ClassNotFoundException | SQLException e3) {
						e3.printStackTrace();
					}
				}
			});
			btnExcluir.setEnabled(false);

			JPanel panel_4 = new JPanel();
			panel_4.setBackground(SystemColor.controlHighlight);
			panel_4.setBounds(27, 81, 306, 181);
			panel.add(panel_4);
			panel_4.setLayout(null);
			panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

			JLabel lblNewLabel = new JLabel("Login");
			lblNewLabel.setBounds(28, 126, 46, 14);
			panel_4.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Senha");
			lblNewLabel_1.setBounds(28, 153, 46, 14);
			panel_4.add(lblNewLabel_1);

			JLabel lblNewLabel_3_1 = new JLabel("Matricula");
			lblNewLabel_3_1.setBounds(28, 65, 60, 14);
			panel_4.add(lblNewLabel_3_1);

			txtLogin = new JTextField();
			txtLogin.setEditable(false);
			txtLogin.setBounds(112, 123, 100, 20);
			panel_4.add(txtLogin);
			txtLogin.setColumns(10);

			txtSenha = new JPasswordField();
			txtSenha.setEditable(false);
			txtSenha.setBounds(112, 150, 100, 20);
			panel_4.add(txtSenha);
			txtSenha.setColumns(10);

			txtMat = new JTextField();
			txtMat.setText("26802");
			txtMat.setBounds(112, 64, 100, 20);
			panel_4.add(txtMat);
			txtMat.setEditable(false);
			txtMat.setColumns(10);

			btnReset = new JButton("Resetar");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ResetSenha();
					PreencherUser();
				}
			});
			btnReset.setBounds(217, 151, 77, 18);
			panel_4.add(btnReset);
			btnReset.setHorizontalAlignment(SwingConstants.LEFT);
			btnReset.setFont(new Font("Dialog", Font.BOLD, 11));
			btnReset.setVisible(false);

			cmbFunc = new JComboBox();
			cmbFunc.setBounds(112, 12, 150, 20);
			panel_4.add(cmbFunc);
			cmbFunc.setModel(defaultComboBox);

			JLabel lblNewLabel_3 = new JLabel("Vinculo");
			lblNewLabel_3.setBounds(28, 12, 60, 14);
			panel_4.add(lblNewLabel_3);

			JLabel lblNewLabel_3_1_1 = new JLabel("CPF");
			lblNewLabel_3_1_1.setBounds(28, 39, 28, 14);
			panel_4.add(lblNewLabel_3_1_1);

			txtCPF = new JTextField();
			txtCPF.setEditable(false);
			txtCPF.setColumns(10);
			txtCPF.setBounds(112, 38, 100, 20);
			panel_4.add(txtCPF);

			txtCargo = new JTextField();
			txtCargo.setColumns(10);
			txtCargo.setEditable(false);
			txtCargo.setBounds(112, 93, 150, 20);
			panel_4.add(txtCargo);

			JLabel lblNewLabel_2 = new JLabel("Tipo de Conta");
			lblNewLabel_2.setBounds(28, 96, 77, 14);
			panel_4.add(lblNewLabel_2);
			

			JLabel lblCadastroDeFuncionrios_1_1 = new JLabel("Lista de Usu\u00E1rios Cadastrados");
			lblCadastroDeFuncionrios_1_1.setBounds(505, 57, 182, 21);
			panel.add(lblCadastroDeFuncionrios_1_1);
			lblCadastroDeFuncionrios_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCadastroDeFuncionrios_1_1.setFont(new Font("Arial", Font.BOLD, 12));

			lblX = new JLabel();
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
					Object[] options = { "Sim", "Não" };

					if (JOptionPane.showOptionDialog(null, "Deseja realmente sair?", "Informação",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {

						frmCadUser.setVisible(false);
						Limpar();
					}
				}
			});
			lblX.setText("X");
			lblX.setOpaque(true);
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setForeground(Color.WHITE);
			lblX.setFont(new Font("Arial", Font.BOLD, 16));
			lblX.setBackground(new Color(77, 20, 52));
			lblX.setBounds(674, 0, 47, 35);
			panel.add(lblX);

			lblCadastroDeTurmas = new JLabel();
			lblCadastroDeTurmas.setText("Cadastro de Usu\u00E1rios");
			lblCadastroDeTurmas.setOpaque(true);
			lblCadastroDeTurmas.setHorizontalAlignment(SwingConstants.CENTER);
			lblCadastroDeTurmas.setForeground(Color.WHITE);
			lblCadastroDeTurmas.setFont(new Font("Arial", Font.BOLD, 20));
			lblCadastroDeTurmas.setBackground(new Color(77, 20, 52));
			lblCadastroDeTurmas.setBounds(0, 0, 721, 35);
			panel.add(lblCadastroDeTurmas);

			cmbFunc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Funcionario = String.valueOf(cmbFunc.getSelectedItem().toString());
					func.setNome_Func(Funcionario);
					if (cmbFunc.getSelectedItem() == "---" || cmbFunc.getSelectedItem() == null) {
						btnSalvar.setText("Novo");
						btnExcluir.setEnabled(false);
						btnExcluir.setEnabled(false);
						txtLogin.setText(null);

					} else {
						try {
							if (fDao.jaExisteUser(func)) {

								btnSalvar.setText("Salvar");
								btnSalvar.setEnabled(false);
								btnExcluir.setEnabled(true);
								btnReset.setVisible(true);
								PreencherUser();
								btnSalvar.setIcon(imageSave);
							} else {
								func.setSenha("Vazio");
								btnSalvar.setText("Salvar");
								btnSalvar.setEnabled(true);
								btnExcluir.setEnabled(false);
								btnReset.setVisible(false);
								PreencherUser();
								CriarUser();
								btnSalvar.setIcon(imageSave);
							}
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			cmbFunc.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					Funcionario = String.valueOf(cmbFunc.getSelectedItem().toString());
					func.setNome_Func(Funcionario);
					if (cmbFunc.getSelectedItem() == "---" || cmbFunc.getSelectedItem() == null) {
						btnSalvar.setText("Novo");
						btnExcluir.setEnabled(false);
						btnExcluir.setEnabled(false);
						txtLogin.setText(null);

					} else {
						try {
							if (fDao.jaExisteUser(func)) {

								btnSalvar.setText("Salvar");
								btnSalvar.setEnabled(false);
								btnExcluir.setEnabled(true);
								btnReset.setVisible(true);
								PreencherUser();
								btnSalvar.setIcon(imageSave);
							} else {
								func.setSenha("Vazio");
								btnSalvar.setText("Salvar");
								btnSalvar.setEnabled(true);
								btnExcluir.setEnabled(false);
								btnReset.setVisible(false);
								PreencherUser();
								CriarUser();
								btnSalvar.setIcon(imageSave);
							}
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}

				}
			});
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btnSalvar.getText() == "Novo") {
						JOptionPane.showMessageDialog(null, "Selecione um Funcionário para Continuar");
					} else {
						try {
							Salvar();
							UserController cControlerTab = new UserController(tbUser);
							cControlerTab.TabelaUser();
							Limpar();
						} catch (ClassNotFoundException | SQLException e3) {
							e3.printStackTrace();
						}
					}
				}
			});
			cControlerTab.TabelaUser();
		} catch (ClassNotFoundException | SQLException e3) {
			e3.printStackTrace();
		}

		Limpar();

	}

	public void Limpar() {
		btnSalvar.setText("Novo");
		btnSalvar.setIcon(imageAdd);
		btnSalvar.setEnabled(true);
		btnExcluir.setEnabled(false);
		btnReset.setVisible(false);
		txtMat.setText("-----");
		txtCPF.setText("-----");
		txtCargo.setText("-----");
		txtLogin.setText("-----");
		txtSenha.setText("Vazio");
	}

	public void CriarUser() {
		String linha = Funcionario; // Funcionário está recebendo o nome selecionado do combobox

		String pattern = "\\S+"; // o \\S faz o match com caracteres que não sejam espaços e
									// o + serve para ir pegando os caracteres até que a condição não seja mais
									// satisfeita.

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(linha);
		if (m.find()) {
			txtLogin.setText(m.group(0) + "." + txtMat.getText());
		}
	}

	public void PreencherList() {
		try {
			List<Funcionarios> lFunc = fDao.recuperarFuncPorNome();

			defaultComboBox = new DefaultComboBoxModel(lFunc.toArray());

		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public void PreencherUser() {
		try {
			fDao.PreencheUser(func);
			fDao.PreencheDados(func);
			txtMat.setText(String.valueOf(func.getMatricula()));
			txtCPF.setText(func.getCPF());
			txtCargo.setText(func.getCargo());
			txtLogin.setText(func.getLogin());
			txtSenha.setText(func.getSenha());

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}

	}

	public void Salvar() {
		try {
			func.setCPF(txtCPF.getText());
			func.setLogin(txtLogin.getText());
			func.setSenha(txtSenha.getText());

			fDao.SalvarUser(func);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void Excluir() {
		try {
			func.setCPF(txtCPF.getText());
			fDao.ExcluirUser(func);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void ResetSenha() {
		try {
			func.setCPF(txtCPF.getText());
			fDao.ResetSenha(func);
			JOptionPane.showMessageDialog(null, "Reset Efetuado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}
}
