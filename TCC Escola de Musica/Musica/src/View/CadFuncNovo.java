package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import Controller.CursosController;
import Dao.ConexaoDao;
import Dao.CursosDao;
import Dao.FuncionariosDao;
import Model.Cursos;
import Model.Funcionarios;
import Model.TxtSomenteNum;
import Model.ValidaCPF;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.border.LineBorder;

public class CadFuncNovo extends JDialog {

	JDialog frmCadFunc;
	JTextField txtMat, txtNome, txtEmail, txtEndereco, txtBairro, txtCidade, txtNum, txtComp, txtUF;
	JFormattedTextField txtCPF, txtFone, txtCel, txtCEP;
	JComboBox cmbCargo;
	String fone, cel, foneM, celM, cep, cpf, cepM, cpfM, logradouro, bairro, cidade, uf, cargo, categoria1, categoria2,
			categoria3, categoria4;
	JButton btnConsultaCEP,btnSalvar, btnValidate, btnSair, btnExcluir;
	JCheckBox chkPercussao, chkSopro, chkTeclas, chkCordas;
	Object[] options = { "Sim", "Não" };
	ImageIcon imageBusca, imageValidate, imageSave, imageCancel, imageAlt, imageExcluir;

	ConexaoDao c = new ConexaoDao();
	Funcionarios func = new Funcionarios();
	FuncionariosDao fDao = new FuncionariosDao();
	private JPanel panel;
	private JLabel lblCadastroDeFuncionrios;
	private JLabel lblX;

	public CadFuncNovo(HomePage homePage, boolean modal) {
		super();
		initialize();
	}

	private void initialize() {

		frmCadFunc = new JDialog();
		frmCadFunc.setUndecorated(true);
		frmCadFunc.setAutoRequestFocus(false);
		frmCadFunc.getContentPane().setEnabled(false);
		frmCadFunc.setModal(true);
		frmCadFunc.setResizable(false);
		frmCadFunc.setTitle("Tela de Funcion\u00E1rios");
		frmCadFunc.getContentPane().setBackground(SystemColor.controlHighlight);
		frmCadFunc.setBounds(100, 100, 421, 455);
		frmCadFunc.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		frmCadFunc.getContentPane().setLayout(null);
		frmCadFunc.setLocationRelativeTo(null);

		// Icone dos botões ----------------------------------------
		imageBusca = new ImageIcon(getClass().getResource("/Imagens/binoculoo.png"));
		imageBusca.setImage(imageBusca.getImage().getScaledInstance(15, 15, 0));

		imageValidate = new ImageIcon(getClass().getResource("/Imagens/Validate.png"));
		imageValidate.setImage(imageValidate.getImage().getScaledInstance(15, 15, 0));

		imageSave = new ImageIcon(getClass().getResource("/Imagens/Save.png"));
		imageSave.setImage(imageSave.getImage().getScaledInstance(18, 18, 0));

		imageCancel = new ImageIcon(getClass().getResource("/Imagens/cancel.png"));
		imageCancel.setImage(imageCancel.getImage().getScaledInstance(15, 15, 0));

		// ImageIcon imageEdit = new
		// ImageIcon(getClass().getResource("/Imagens/Lapis.png"));
		// imageEdit.setImage(imageEdit.getImage().getScaledInstance(18, 18, 0));

		imageAlt = new ImageIcon(getClass().getResource("/Imagens/lapis.png"));
		imageAlt.setImage(imageAlt.getImage().getScaledInstance(15, 15, 0));

		imageExcluir = new ImageIcon(getClass().getResource("/Imagens/lixeira.png"));
		imageExcluir.setImage(imageExcluir.getImage().getScaledInstance(15, 15, 0));
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Checkbox desabilitado só habilita quando o cargo professor é selecionado
		 */

		panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 421, 455);
		frmCadFunc.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCPF = new JLabel("*CPF");
		lblCPF.setBounds(39, 61, 30, 16);
		panel.add(lblCPF);
		lblCPF.setFont(new Font("Arial", Font.BOLD, 12));

		txtCPF = new TxtSomenteNum(26);
		try {
			txtCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		} catch (ParseException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		txtCPF.setBounds(78, 61, 121, 20);
		panel.add(txtCPF);
		txtCPF.setEditable(true);
		txtCPF.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lblRM = new JLabel("*Matricula");
		lblRM.setBounds(243, 60, 60, 16);
		panel.add(lblRM);

		txtMat = new JTextField();
		txtMat.setBounds(308, 59, 83, 20);
		panel.add(txtMat);
		txtMat.setEditable(false);
		txtMat.setBackground(SystemColor.control);
		txtMat.setFont(new Font("Arial", Font.PLAIN, 12));
		txtMat.setColumns(10);

		JLabel lblCPF_2 = new JLabel("*(Ser\u00E3o utilizado nas telas do sistema para consulta)");
		lblCPF_2.setBounds(125, 80, 266, 16);
		panel.add(lblCPF_2);
		lblCPF_2.setForeground(SystemColor.controlShadow);
		lblCPF_2.setFont(new Font("Arial", Font.BOLD, 10));
		lblCPF_2.setBackground(SystemColor.scrollbar);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(28, 97, 41, 16);
		panel.add(lblNome);
		lblNome.setFont(new Font("Arial", Font.BOLD, 12));

		txtNome = new JTextField();
		txtNome.setBounds(78, 97, 313, 20);
		panel.add(txtNome);
		txtNome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNome.setColumns(10);

		txtNome.setEditable(false);

		JLabel lblNome_2 = new JLabel("Tel Fixo");
		lblNome_2.setBounds(28, 121, 47, 16);
		panel.add(lblNome_2);

		txtFone = new TxtSomenteNum(25);
		txtFone.setBounds(78, 121, 121, 20);
		panel.add(txtFone);
		try {
			txtFone.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
		} catch (ParseException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		txtFone.setFont(new Font("Arial", Font.PLAIN, 12));
		txtFone.setEditable(false);

		JLabel lblNome_2_1 = new JLabel("Celular");
		lblNome_2_1.setBounds(217, 121, 47, 16);
		panel.add(lblNome_2_1);

		txtCel = new TxtSomenteNum(26);
		txtCel.setBounds(266, 120, 125, 20);
		panel.add(txtCel);
		try {
			txtCel.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)#####-####")));
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		txtCel.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCel.setEditable(false);

		JLabel lblNome_2_2 = new JLabel("E-mail");
		lblNome_2_2.setBounds(28, 145, 41, 16);
		panel.add(lblNome_2_2);

		txtEmail = new JTextField();
		txtEmail.setBounds(78, 145, 313, 20);
		panel.add(txtEmail);
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setEditable(false);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(78, 171, 313, 141);
		panel.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JLabel lblRM_1 = new JLabel("CEP");
		lblRM_1.setBounds(39, 12, 28, 16);
		panel_4.add(lblRM_1);

		txtCEP = new TxtSomenteNum(23);
		try {
			txtCEP.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		txtCEP.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCEP.setBounds(72, 11, 78, 20);
		panel_4.add(txtCEP);

		JLabel lblNome_1 = new JLabel("Endere\u00E7o");
		lblNome_1.setBounds(12, 36, 55, 16);
		panel_4.add(lblNome_1);

		txtEndereco = new JTextField();
		txtEndereco.setEditable(false);
		txtEndereco.setBackground(SystemColor.control);
		txtEndereco.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(72, 36, 217, 20);
		panel_4.add(txtEndereco);

		JLabel lblCPF_1_2 = new JLabel("Bairro");
		lblCPF_1_2.setBounds(25, 84, 42, 16);
		panel_4.add(lblCPF_1_2);

		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setBackground(SystemColor.control);
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 12));
		txtBairro.setColumns(10);
		txtBairro.setBounds(72, 84, 217, 20);
		panel_4.add(txtBairro);

		JLabel lblCPF_1_1_1 = new JLabel("Cidade");
		lblCPF_1_1_1.setBounds(25, 108, 42, 16);
		panel_4.add(lblCPF_1_1_1);

		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setBackground(SystemColor.control);
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCidade.setColumns(10);
		txtCidade.setBounds(72, 108, 78, 20);
		panel_4.add(txtCidade);

		JLabel lblCPF_1 = new JLabel("N\u00FAmero");
		lblCPF_1.setBounds(22, 60, 45, 16);
		panel_4.add(lblCPF_1);

		txtNum = new JTextField();
		txtNum.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNum.setColumns(10);
		txtNum.setBounds(72, 60, 55, 20);
		panel_4.add(txtNum);

		JLabel lblCPF_1_1 = new JLabel("UF");
		lblCPF_1_1.setBounds(193, 108, 28, 16);
		panel_4.add(lblCPF_1_1);

		JLabel lblCPF_1_1_1_1 = new JLabel("Compl.");
		lblCPF_1_1_1_1.setBounds(135, 60, 42, 16);
		panel_4.add(lblCPF_1_1_1_1);

		txtComp = new JTextField();
		txtComp.setFont(new Font("Arial", Font.PLAIN, 12));
		txtComp.setColumns(10);
		txtComp.setBounds(184, 58, 105, 20);
		panel_4.add(txtComp);

		txtUF = new JTextField();
		txtUF.setEditable(false);
		txtUF.setBackground(SystemColor.control);
		txtUF.setFont(new Font("Arial", Font.BOLD, 12));
		txtUF.setBounds(224, 108, 65, 20);
		panel_4.add(txtUF);

		btnConsultaCEP = new JButton("");

		btnConsultaCEP.setIcon(imageBusca);
		btnConsultaCEP.setBounds(152, 12, 20, 18);
		panel_4.add(btnConsultaCEP);
		txtCEP.setEditable(false);
		txtNum.setEditable(false);
		txtComp.setEditable(false);
		btnConsultaCEP.setEnabled(false);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(78, 405, 100, 26);
		panel.add(btnSalvar);
		btnSalvar.setIcon(imageSave);
		btnSalvar.setEnabled(false);

		btnSair = new JButton("Sair");
		btnSair.setBounds(308, 405, 83, 26);
		panel.add(btnSair);
		btnSair.setIcon(imageCancel);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(262, 324, 41, 16);
		panel.add(lblCargo);
		lblCargo.setFont(new Font("Arial", Font.BOLD, 12));

		cmbCargo = new JComboBox();
		cmbCargo.setBounds(270, 348, 121, 20);
		panel.add(cmbCargo);
		cmbCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargo = cmbCargo.getSelectedItem().toString();
			}
		});
		cmbCargo.setEnabled(false);
		cmbCargo.setModel(
				new DefaultComboBoxModel(new String[] { "---", "Administrador", "Professor", "Recepcionista" }));
		cmbCargo.setEnabled(false);

		chkCordas = new JCheckBox("Cordas");
		chkCordas.setBounds(88, 348, 71, 20);
		panel.add(chkCordas);
		chkCordas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkCordas.isSelected() == true) {
					categoria1 = chkCordas.getText();
				} else {
					categoria1 = "Vazio";
				}
			}
		});
		chkCordas.setBackground(SystemColor.controlHighlight);
		chkCordas.setEnabled(false);

		chkTeclas = new JCheckBox("Teclas");
		chkTeclas.setBounds(88, 370, 65, 20);
		panel.add(chkTeclas);
		chkTeclas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkTeclas.isSelected() == true) {
					categoria3 = chkTeclas.getText();
				} else {
					categoria3 = "Vazio";
				}
			}
		});
		chkTeclas.setBackground(SystemColor.controlHighlight);
		chkTeclas.setEnabled(false);

		chkSopro = new JCheckBox("Sopro");
		chkSopro.setBounds(162, 348, 65, 20);
		panel.add(chkSopro);
		chkSopro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkSopro.isSelected() == true) {
					categoria2 = chkSopro.getText();
				} else {
					categoria2 = "Vazio";
				}
			}
		});
		chkSopro.setBackground(SystemColor.controlHighlight);
		chkSopro.setEnabled(false);

		chkPercussao = new JCheckBox("Percuss\u00E3o");
		chkPercussao.setBounds(162, 370, 92, 20);
		panel.add(chkPercussao);
		chkPercussao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkPercussao.isSelected() == true) {
					categoria4 = chkPercussao.getText();
				} else {
					categoria4 = "Vazio";
				}
			}
		});
		chkPercussao.setBackground(SystemColor.controlHighlight);
		chkPercussao.setEnabled(false);

		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(78, 327, 83, 16);
		panel.add(lblEspecialidade);
		lblEspecialidade.setFont(new Font("Arial", Font.BOLD, 12));

		btnValidate = new JButton("");
		btnValidate.setBounds(200, 62, 20, 18);
		panel.add(btnValidate);

		btnValidate.setIcon(imageValidate);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(193, 405, 100, 26);
		panel.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Deseja realmente Excluir?", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
					cpfM = txtCPF.getText().replace(".", "").replace("-", "").replace(" ", "");
					cpf = (cpfM);
					func.setCPF(cpf);
					try {
						Excluir();
						txtCPF.setText(null);
						txtNome.setText(null);
						txtFone.setText(null);
						txtCel.setText(null);
						txtEmail.setText(null);
						txtCEP.setText(null);
						txtNum.setText(null);
						txtComp.setText(null);
						txtEndereco.setText(null);
						txtBairro.setText(null);
						txtCidade.setText(null);
						txtUF.setText(null);
						txtCPF.requestFocus();

						txtCPF.setEditable(true);
						txtNome.setEditable(false);
						txtFone.setEditable(false);
						txtCel.setEditable(false);
						txtEmail.setEditable(false);
						txtCEP.setEditable(false);
						txtNum.setEditable(false);
						txtComp.setEditable(false);

						btnConsultaCEP.setEnabled(false);
						btnSalvar.setEnabled(false);
						btnSalvar.setIcon(imageSave);
						btnExcluir.setEnabled(false);
						cmbCargo.setEnabled(false);
						btnValidate.setEnabled(true);
						cmbCargo.setSelectedIndex(0);

						chkCordas.setSelected(false);
						chkSopro.setSelected(false);
						chkTeclas.setSelected(false);
						chkPercussao.setSelected(false);

						// windowHome.PreencherList();

						ProximaMat();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setIcon(imageExcluir);

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
					try {
						frmCadFunc.setVisible(false);
						txtCPF.setText(null);
						txtNome.setText(null);
						txtFone.setText(null);
						txtCel.setText(null);
						txtEmail.setText(null);
						txtCEP.setText(null);
						txtNum.setText(null);
						txtComp.setText(null);
						txtEndereco.setText(null);
						txtBairro.setText(null);
						txtCidade.setText(null);
						txtUF.setText(null);
						txtCPF.requestFocus();

						txtCPF.setEditable(true);
						txtNome.setEditable(false);
						txtFone.setEditable(false);
						txtCel.setEditable(false);
						txtEmail.setEditable(false);
						txtCEP.setEditable(false);
						txtNum.setEditable(false);
						txtComp.setEditable(false);

						btnConsultaCEP.setEnabled(false);
						btnSalvar.setEnabled(false);
						btnSalvar.setText("Salvar");
						btnSalvar.setIcon(imageSave);
						btnExcluir.setEnabled(false);
						cmbCargo.setEnabled(false);
						btnValidate.setEnabled(true);
						cmbCargo.setSelectedIndex(0);

						chkCordas.setSelected(false);
						chkSopro.setSelected(false);
						chkTeclas.setSelected(false);
						chkPercussao.setSelected(false);
						ProximaMat();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					txtCPF.setText(null);
					txtCPF.requestFocus();
					txtCPF.setEditable(true);
				}

			}
		});
		lblX.setText("X");
		lblX.setOpaque(true);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 16));
		lblX.setBackground(new Color(77, 20, 52));
		lblX.setBounds(374, 0, 47, 35);
		panel.add(lblX);

		lblCadastroDeFuncionrios = new JLabel();
		lblCadastroDeFuncionrios.setText("Cadastro de Funcion\u00E1rios");
		lblCadastroDeFuncionrios.setOpaque(true);
		lblCadastroDeFuncionrios.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeFuncionrios.setForeground(Color.WHITE);
		lblCadastroDeFuncionrios.setFont(new Font("Arial", Font.BOLD, 20));
		lblCadastroDeFuncionrios.setBackground(new Color(77, 20, 52));
		lblCadastroDeFuncionrios.setBounds(0, 0, 421, 35);
		panel.add(lblCadastroDeFuncionrios);

		// Eventos ------------------------------

		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpfM = txtCPF.getText().replace(".", "").replace("-", "").replace(" ", "");
				if ((cpfM.trim()) != null) {
					if (ValidaCPF.isCPF(cpfM) == true) {
						cpf = (cpfM);
						func.setCPF(cpf);
						try {
							if (fDao.jaExiste(func)) {
								PreencherFuncionario();
								txtCPF.setEditable(false);
								btnValidate.setEnabled(false);

								txtNome.requestFocus();
								txtNome.setEditable(true);
								txtFone.setEditable(true);
								txtCel.setEditable(true);
								txtEmail.setEditable(true);
								txtCEP.setEditable(true);
								txtNum.setEditable(true);
								txtComp.setEditable(true);

								cmbCargo.setEnabled(true);
								btnConsultaCEP.setEnabled(true);
								btnSalvar.setEnabled(true);
								btnExcluir.setEnabled(true);

								btnSalvar.setText("Alterar");
								btnSalvar.setIcon(imageAlt);
							} else {
								txtCPF.setEditable(false);
								btnValidate.setEnabled(false);

								txtNome.requestFocus();
								txtNome.setEditable(true);
								txtFone.setEditable(true);
								txtCel.setEditable(true);
								txtEmail.setEditable(true);
								txtCEP.setEditable(true);
								txtNum.setEditable(true);
								txtComp.setEditable(true);

								cmbCargo.setEnabled(true);
								btnConsultaCEP.setEnabled(true);
								btnSalvar.setEnabled(true);
								btnSalvar.setText("Salvar");
								btnSalvar.setIcon(imageSave);
							}
						} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				} else {
					txtCPF.requestFocus();
					JOptionPane.showMessageDialog(null, "CPF inválido", "Erro", 0);
				}
			}
		});

		cmbCargo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cmbCargo.getSelectedItem() == "Professor") {
					chkCordas.setEnabled(true);
					chkSopro.setEnabled(true);
					chkPercussao.setEnabled(true);
					chkTeclas.setEnabled(true);
					categoria1 = "Vazio";
					categoria2 = "Vazio";
					categoria3 = "Vazio";
					categoria4 = "Vazio";
				} else {
					chkCordas.setSelected(false);
					chkSopro.setSelected(false);
					chkTeclas.setSelected(false);
					chkPercussao.setSelected(false);
					chkCordas.setEnabled(false);
					chkSopro.setEnabled(false);
					chkPercussao.setEnabled(false);
					chkTeclas.setEnabled(false);
					categoria1 = "Vazio";
					categoria2 = "Vazio";
					categoria3 = "Vazio";
					categoria4 = "Vazio";
				}
			}
		});

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Deseja realmente sair?", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
					try {
						frmCadFunc.setVisible(false);
						txtCPF.setText(null);
						txtNome.setText(null);
						txtFone.setText(null);
						txtCel.setText(null);
						txtEmail.setText(null);
						txtCEP.setText(null);
						txtNum.setText(null);
						txtComp.setText(null);
						txtEndereco.setText(null);
						txtBairro.setText(null);
						txtCidade.setText(null);
						txtUF.setText(null);
						txtCPF.requestFocus();

						txtCPF.setEditable(true);
						txtNome.setEditable(false);
						txtFone.setEditable(false);
						txtCel.setEditable(false);
						txtEmail.setEditable(false);
						txtCEP.setEditable(false);
						txtNum.setEditable(false);
						txtComp.setEditable(false);

						btnConsultaCEP.setEnabled(false);
						btnSalvar.setEnabled(false);
						btnSalvar.setText("Salvar");
						btnSalvar.setIcon(imageSave);
						btnExcluir.setEnabled(false);
						cmbCargo.setEnabled(false);
						btnValidate.setEnabled(true);
						cmbCargo.setSelectedIndex(0);

						chkCordas.setSelected(false);
						chkSopro.setSelected(false);
						chkTeclas.setSelected(false);
						chkPercussao.setSelected(false);
						ProximaMat();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					txtCPF.setText(null);
					txtCPF.requestFocus();
					txtCPF.setEditable(true);
				}

			}
		});

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionarios func = new Funcionarios();
				FuncionariosDao fDao = new FuncionariosDao();
				if ((txtNome.getText().isEmpty()) || cargo == "---" || cargo == null) {
					JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios", "Erro",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {

						cpfM = txtCPF.getText().replace(".", "").replace("-", "").replace(" ", "");
						cpf = (cpfM);
						cepM = txtCEP.getText().replace("-", "").replace(" ", "");
						cep = (cepM);
						foneM = txtFone.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
						fone = foneM;
						celM = txtCel.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
						cel = celM;

						if (btnSalvar.getText() == "Salvar") {
							Salvar();
							txtCPF.setText(null);
							txtNome.setText(null);
							txtFone.setText(null);
							txtCel.setText(null);
							txtEmail.setText(null);
							txtCEP.setText(null);
							txtNum.setText(null);
							txtComp.setText(null);
							txtEndereco.setText(null);
							txtBairro.setText(null);
							txtCidade.setText(null);
							txtUF.setText(null);
							txtCPF.requestFocus();

							txtCPF.setEditable(true);
							txtNome.setEditable(false);
							txtFone.setEditable(false);
							txtCel.setEditable(false);
							txtEmail.setEditable(false);
							txtCEP.setEditable(false);
							txtNum.setEditable(false);
							txtComp.setEditable(false);

							btnConsultaCEP.setEnabled(false);
							btnSalvar.setEnabled(false);
							btnSalvar.setIcon(imageSave);
							btnExcluir.setEnabled(false);
							cmbCargo.setEnabled(false);
							btnValidate.setEnabled(true);
							cmbCargo.setSelectedIndex(0);

							chkCordas.setSelected(false);
							chkSopro.setSelected(false);
							chkTeclas.setSelected(false);
							chkPercussao.setSelected(false);
							ProximaMat();

						} else {
							Alterar();
							txtCPF.setText(null);
							txtNome.setText(null);
							txtFone.setText(null);
							txtCel.setText(null);
							txtEmail.setText(null);
							txtCEP.setText(null);
							txtNum.setText(null);
							txtComp.setText(null);
							txtEndereco.setText(null);
							txtBairro.setText(null);
							txtCidade.setText(null);
							txtUF.setText(null);
							txtCPF.requestFocus();

							txtCPF.setEditable(true);
							txtNome.setEditable(false);
							txtFone.setEditable(false);
							txtCel.setEditable(false);
							txtEmail.setEditable(false);
							txtCEP.setEditable(false);
							txtNum.setEditable(false);
							txtComp.setEditable(false);

							btnConsultaCEP.setEnabled(false);
							btnSalvar.setEnabled(false);
							btnSalvar.setIcon(imageSave);
							btnExcluir.setEnabled(false);
							cmbCargo.setEnabled(false);
							btnValidate.setEnabled(true);
							cmbCargo.setSelectedIndex(0);

							chkCordas.setSelected(false);
							chkSopro.setSelected(false);
							chkTeclas.setSelected(false);
							chkPercussao.setSelected(false);
							ProximaMat();
						}

					} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnConsultaCEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cep = txtCEP.getText();
				if (Integer.parseInt((cep.replace("-", "").replace(" ", ""))) < 8) {
				} else {
					if ((cep.trim().replace("-", "").replace(" ", "")) != null) {
						buscarCep(cep);
					} else {
						JOptionPane.showMessageDialog(null, "CEP inválido", "Erro", 0);
						txtCEP.requestFocus();
					}
				}
			}
		});

		txtCPF.requestFocus();

		txtCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				cpfM = txtCPF.getText().replace(".", "").replace("-", "").replace(" ", "");
				if ((cpfM.trim()) != null) {
					if (ValidaCPF.isCPF(cpfM) == true) {
						cpf = (cpfM);
						func.setCPF(cpf);
						try {
							if (fDao.jaExiste(func)) {
								PreencherFuncionario();
								txtCPF.setEditable(false);
								btnValidate.setEnabled(false);

								txtNome.requestFocus();
								txtNome.setEditable(true);
								txtFone.setEditable(true);
								txtCel.setEditable(true);
								txtEmail.setEditable(true);
								txtCEP.setEditable(true);
								txtNum.setEditable(true);
								txtComp.setEditable(true);

								cmbCargo.setEnabled(false);
								btnConsultaCEP.setEnabled(true);
								btnSalvar.setEnabled(true);
								btnExcluir.setEnabled(true);

								btnSalvar.setText("Alterar");
								btnSalvar.setIcon(imageAlt);
							} else {
								txtCPF.setEditable(false);
								btnValidate.setEnabled(false);

								txtNome.requestFocus();
								txtNome.setEditable(true);
								txtFone.setEditable(true);
								txtCel.setEditable(true);
								txtEmail.setEditable(true);
								txtCEP.setEditable(true);
								txtNum.setEditable(true);
								txtComp.setEditable(true);

								cmbCargo.setEnabled(true);
								btnConsultaCEP.setEnabled(true);
								btnSalvar.setEnabled(true);
								btnSalvar.setText("Salvar");
								btnSalvar.setIcon(imageSave);
							}
						} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				} else {
					txtCPF.requestFocus();
					JOptionPane.showMessageDialog(null, "CPF inválido", "Erro", 0);
				}
			}
		});

		try {
			ProximaMat();
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		}
	}

	public int ProximaMat() throws SQLException, ClassNotFoundException {
		try {
			FuncionariosDao fDao = new FuncionariosDao();
			txtMat.setText(String.valueOf(fDao.ProximoCod()));
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro Matricula");
		}
		return 0;
	}

	public void buscarCep(String cep) {
		String json;
		Object estado;

		try {
			URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			StringBuilder jsonSb = new StringBuilder();

			br.lines().forEach(l -> jsonSb.append(l.trim()));
			json = jsonSb.toString();

			json = json.replaceAll("[{},:]", "");
			json = json.replaceAll("\"", "\n");
			String array[] = new String[30];
			array = json.split("\n");

			logradouro = array[7];
			bairro = array[15];
			cidade = array[19];
			uf = array[23];
			txtEndereco.setText(logradouro);
			txtBairro.setText(bairro);
			txtCidade.setText(cidade);
			txtUF.setText(uf);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void Salvar() {
		try {
			func.setCPF(cpf);
			func.setNome_Func(txtNome.getText());
			func.setTelefone(fone);
			func.setCelular(cel);
			func.setEmail(txtEmail.getText());
			func.setCep(cep);
			func.setEndereco(txtEndereco.getText());
			func.setNum(txtNum.getText());
			func.setComplemento(txtComp.getText());
			func.setBairro(txtBairro.getText());
			func.setCidade(txtCidade.getText());
			func.setEstado(txtUF.getText());
			func.setCategoria1(categoria1);
			func.setCategoria2(categoria2);
			func.setCategoria3(categoria3);
			func.setCategoria4(categoria4);
			func.setCargo(cargo);

			fDao.Salvar(func);
			JOptionPane.showMessageDialog(null, "Dados Cadastrados com sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void Alterar() {
		try {
			func.setCPF(cpf);
			func.setNome_Func(txtNome.getText());
			func.setTelefone(fone);
			func.setCelular(cel);
			func.setEmail(txtEmail.getText());
			func.setCep(cep);
			func.setEndereco(txtEndereco.getText());
			func.setNum(txtNum.getText());
			func.setComplemento(txtComp.getText());
			func.setBairro(txtBairro.getText());
			func.setCidade(txtCidade.getText());
			func.setEstado(txtUF.getText());
			func.setCategoria1(categoria1);
			func.setCategoria2(categoria2);
			func.setCategoria3(categoria3);
			func.setCategoria4(categoria4);
			func.setCargo(cargo);
			fDao.Alterar(func);
			JOptionPane.showMessageDialog(null, "Dados Alterados com sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void Excluir() {
		try {
			func.setCPF(cpf);
			fDao.ExcluirUser(func);
			fDao.Excluir(func);
			JOptionPane.showMessageDialog(null, "Dados Excluidos com sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void PreencherFuncionario() {
		try {
			fDao.PreencheFunc(func);
			txtMat.setText(String.valueOf(func.getMatricula()));
			txtNome.setText(func.getNome_Func());
			txtFone.setText(func.getTelefone());
			txtCel.setText(func.getCelular());
			txtEmail.setText(func.getEmail());
			txtCEP.setText(func.getCep());
			txtEndereco.setText(func.getEndereco());
			txtNum.setText(func.getNum());
			txtComp.setText(func.getComplemento());
			txtBairro.setText(func.getBairro());
			txtCidade.setText(func.getCidade());
			txtUF.setText(func.getEstado());

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}

	}
}
