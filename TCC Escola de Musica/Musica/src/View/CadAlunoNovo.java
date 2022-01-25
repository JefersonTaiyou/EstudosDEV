package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

import Dao.ConexaoDao;
import Dao.AlunosDao;

import javax.swing.border.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.text.ParseException;

import Model.Alunos;
import Model.TxtSomenteNum;
import Model.ValidaCPF;

public class CadAlunoNovo extends JDialog {

	JDialog frmAluno;
	JTextField txtMat, txtNome, txtEmail, txtEndereco, txtBairro, txtCidade, txtNum, txtComp, txtUF;
	JFormattedTextField txtCPF, txtFone, txtCel, txtCEP;
	JComboBox cmbCurso, cmbTurma, cmbPeriodo;
	JRadioButton rdbtnBasico, rdbtnMedio, rdbtnAvanc;
	JButton btnValidate, btnConsultaCEP, btnSalvar, btnExcluir, btnSair;
	JLabel lblX;
	ButtonGroup buttonGroup = new ButtonGroup();
	String fone, cel, foneM, celM, cep, cpf, cepM, cpfM, logradouro, bairro, cidade, uf, cargo, categoria1, categoria2,
			categoria3, categoria4;
	Object[] options = { "Sim", "Não" };
	ImageIcon imageBusca, imageValidate, imageSave, imageCancel, imageAlt, imageExcluir;

	ConexaoDao c = new ConexaoDao();
	Alunos func = new Alunos();
	AlunosDao fDao = new AlunosDao();

	public CadAlunoNovo(HomePage homePage, boolean modal) {
		super();
		initialize();
	}

	private void initialize() {
		frmAluno = new JDialog();
		frmAluno.setUndecorated(true);
		frmAluno.setModal(true);
		frmAluno.setAutoRequestFocus(false);
		frmAluno.setTitle("Cadastro de Aluno");
		frmAluno.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		frmAluno.setResizable(false);
		frmAluno.getContentPane().setBackground(SystemColor.controlHighlight);
		frmAluno.setBounds(100, 100, 421, 464);
		frmAluno.setLocationRelativeTo(null);

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

		frmAluno.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(0, 0, 421, 464);
		frmAluno.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(24, 92, 41, 16);
		panel.add(lblNome);
		lblNome.setFont(new Font("Arial", Font.BOLD, 12));

		txtNome = new JTextField();
		txtNome.setBounds(74, 92, 313, 20);
		panel.add(txtNome);
		txtNome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNome.setColumns(10);

		txtNome.setEditable(false);

		JLabel lblNome_2 = new JLabel("Tel Fixo");
		lblNome_2.setBounds(24, 116, 47, 16);
		panel.add(lblNome_2);

		txtFone = new TxtSomenteNum(25);
		txtFone.setBounds(74, 116, 121, 20);
		panel.add(txtFone);
		try {
			txtFone.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		txtFone.setFont(new Font("Arial", Font.PLAIN, 12));
		txtFone.setEditable(false);

		JLabel lblNome_2_1 = new JLabel("Celular");
		lblNome_2_1.setBounds(213, 116, 47, 16);
		panel.add(lblNome_2_1);

		txtCel = new TxtSomenteNum(26);
		txtCel.setBounds(262, 115, 125, 20);
		panel.add(txtCel);
		try {
			txtCel.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)#####-####")));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		txtCel.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCel.setEditable(false);

		JLabel lblNome_2_2 = new JLabel("E-mail");
		lblNome_2_2.setBounds(24, 140, 47, 16);
		panel.add(lblNome_2_2);

		txtEmail = new JTextField();
		txtEmail.setBounds(74, 140, 313, 20);
		panel.add(txtEmail);
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setEditable(false);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(74, 166, 313, 141);
		panel.add(panel_4);
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_4.setLayout(null);

		JLabel lblRM_1 = new JLabel("CEP");
		lblRM_1.setBounds(39, 12, 28, 16);
		panel_4.add(lblRM_1);

		txtCEP = new TxtSomenteNum(23);
		try {
			txtCEP.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		txtCEP.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCEP.setBounds(72, 11, 78, 20);
		panel_4.add(txtCEP);

		JLabel lblNome_1 = new JLabel("Endere\u00E7o");
		lblNome_1.setBounds(12, 36, 55, 16);
		panel_4.add(lblNome_1);

		txtEndereco = new JTextField();
		txtEndereco.setEditable(false);
		txtEndereco.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEndereco.setBounds(72, 36, 217, 20);
		panel_4.add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblCPF_1_2 = new JLabel("Bairro");
		lblCPF_1_2.setBounds(25, 84, 42, 16);
		panel_4.add(lblCPF_1_2);

		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 12));
		txtBairro.setBounds(72, 84, 217, 20);
		panel_4.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCPF_1_1_1 = new JLabel("Cidade");
		lblCPF_1_1_1.setBounds(25, 108, 42, 16);
		panel_4.add(lblCPF_1_1_1);

		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCidade.setBounds(72, 108, 78, 20);
		panel_4.add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblCPF_1 = new JLabel("N\u00FAmero");
		lblCPF_1.setBounds(22, 60, 45, 16);
		panel_4.add(lblCPF_1);

		txtNum = new JTextField();
		txtNum.setEditable(false);
		txtNum.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNum.setBounds(72, 60, 55, 20);
		panel_4.add(txtNum);
		txtNum.setColumns(10);

		JLabel lblCPF_1_1 = new JLabel("UF");
		lblCPF_1_1.setBounds(193, 108, 28, 16);
		panel_4.add(lblCPF_1_1);

		JLabel lblCPF_1_1_1_1 = new JLabel("Compl.");
		lblCPF_1_1_1_1.setBounds(135, 60, 42, 16);
		panel_4.add(lblCPF_1_1_1_1);

		txtComp = new JTextField();
		txtComp.setEditable(false);
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
		btnConsultaCEP.setIcon(imageBusca);
		btnConsultaCEP.setEnabled(false);
		btnConsultaCEP.setBounds(152, 12, 20, 18);
		panel_4.add(btnConsultaCEP);
		txtCEP.setEditable(false);
		txtNum.setEditable(false);
		txtComp.setEditable(false);
		btnConsultaCEP.setEnabled(false);

		JLabel lblNewLabel_4 = new JLabel("Conhecimento");
		lblNewLabel_4.setBounds(74, 312, 90, 16);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Curso");
		lblNewLabel_5.setBounds(205, 312, 55, 16);
		panel.add(lblNewLabel_5);

		rdbtnBasico = new JRadioButton("B\u00E1sico");
		rdbtnBasico.setBounds(111, 330, 64, 20);
		panel.add(rdbtnBasico);
		rdbtnBasico.setEnabled(false);
		buttonGroup.add(rdbtnBasico);
		rdbtnBasico.setBackground(SystemColor.controlHighlight);
		rdbtnBasico.setFont(new Font("Arial", Font.BOLD, 12));

		cmbCurso = new JComboBox();
		cmbCurso.setEnabled(false);
		cmbCurso.setBounds(215, 330, 172, 20);
		panel.add(cmbCurso);
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] { "---" }));
		cmbCurso.setFont(new Font("Arial", Font.BOLD, 12));

		rdbtnMedio = new JRadioButton("Intermedi\u00E1rio");
		rdbtnMedio.setBounds(111, 354, 101, 20);
		panel.add(rdbtnMedio);
		rdbtnMedio.setEnabled(false);
		buttonGroup.add(rdbtnMedio);
		rdbtnMedio.setBackground(SystemColor.controlHighlight);
		rdbtnMedio.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblNewLabel_6 = new JLabel("Per\u00EDodo");
		lblNewLabel_6.setBounds(245, 356, 44, 16);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("Turma");
		lblNewLabel_6_1.setBounds(248, 380, 41, 16);
		panel.add(lblNewLabel_6_1);

		rdbtnAvanc = new JRadioButton("Avan\u00E7ado");
		rdbtnAvanc.setBounds(111, 379, 81, 20);
		panel.add(rdbtnAvanc);
		rdbtnAvanc.setEnabled(false);
		buttonGroup.add(rdbtnAvanc);
		rdbtnAvanc.setBackground(SystemColor.controlHighlight);
		rdbtnAvanc.setFont(new Font("Arial", Font.BOLD, 12));

		cmbPeriodo = new JComboBox();
		cmbPeriodo.setBounds(297, 356, 90, 20);
		panel.add(cmbPeriodo);
		cmbPeriodo.setEnabled(false);
		cmbPeriodo.setFont(new Font("Arial", Font.BOLD, 12));
		cmbPeriodo.setModel(new DefaultComboBoxModel(new String[] { "---", "Manh\u00E3", "Tarde", "Noite" }));

		cmbTurma = new JComboBox();
		cmbTurma.setBounds(297, 379, 90, 20);
		panel.add(cmbTurma);
		cmbTurma.setEnabled(false);
		cmbTurma.setModel(new DefaultComboBoxModel(new String[] { "---" }));
		cmbTurma.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblCPF = new JLabel("*CPF");
		lblCPF.setBounds(35, 56, 30, 16);
		panel.add(lblCPF);
		lblCPF.setFont(new Font("Arial", Font.BOLD, 12));

		txtCPF = new TxtSomenteNum(26);
		txtCPF.setBounds(74, 56, 121, 20);
		panel.add(txtCPF);
		try {
			txtCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		txtCPF.setFont(new Font("Arial", Font.PLAIN, 12));

		// -----------------------------------------------------------

		JLabel lblRM = new JLabel("*Matricula");
		lblRM.setBounds(239, 55, 64, 16);
		panel.add(lblRM);

		txtMat = new JTextField();
		txtMat.setBounds(304, 54, 83, 20);
		panel.add(txtMat);
		txtMat.setEditable(false);
		txtMat.setFont(new Font("Arial", Font.PLAIN, 12));
		txtMat.setColumns(10);

		btnValidate = new JButton("");
		btnValidate.setBounds(196, 57, 20, 18);
		panel.add(btnValidate);
		btnValidate.setIcon(imageValidate);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(74, 414, 100, 26);
		panel.add(btnSalvar);
		btnSalvar.setIcon(imageSave);
		btnSalvar.setEnabled(false);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Deseja realmente sair?", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
					try {
						frmAluno.setVisible(false);
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
						
						rdbtnBasico.setEnabled(false);
						rdbtnMedio.setEnabled(false);
						rdbtnAvanc.setEnabled(false);
						

						buttonGroup.clearSelection();

						cmbCurso.setSelectedIndex(0);
						cmbPeriodo.setSelectedIndex(0);
						cmbTurma.setSelectedIndex(0);

						cmbCurso.setEnabled(false);
						cmbPeriodo.setEnabled(false);
						cmbTurma.setEnabled(false);
						
						btnValidate.setEnabled(true);

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
		btnSair.setBounds(304, 414, 83, 26);
		panel.add(btnSair);
		btnSair.setIcon(imageCancel);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(189, 414, 100, 26);
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
						btnValidate.setEnabled(true);

						ProximaMat();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setIcon(imageExcluir);

		JLabel lblCPF_2 = new JLabel("*(Ser\u00E3o utilizado nas telas do sistema para consulta)");
		lblCPF_2.setBounds(121, 75, 266, 16);
		panel.add(lblCPF_2);
		lblCPF_2.setForeground(SystemColor.controlShadow);
		lblCPF_2.setBackground(SystemColor.scrollbar);
		lblCPF_2.setFont(new Font("Arial", Font.BOLD, 10));

		lblX = new JLabel();
		lblX.setText("X");
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
				if (JOptionPane.showOptionDialog(null, "Deseja realmente sair?", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
					try {
						frmAluno.setVisible(false);
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
						
						rdbtnBasico.setEnabled(false);
						rdbtnMedio.setEnabled(false);
						rdbtnAvanc.setEnabled(false);
						

						buttonGroup.clearSelection();

						cmbCurso.setSelectedIndex(0);
						cmbPeriodo.setSelectedIndex(0);
						cmbTurma.setSelectedIndex(0);

						cmbCurso.setEnabled(false);
						cmbPeriodo.setEnabled(false);
						cmbTurma.setEnabled(false);
						
						btnValidate.setEnabled(true);

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
		lblX.setOpaque(true);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 16));
		lblX.setBackground(new Color(77, 20, 52));
		lblX.setBounds(374, 0, 47, 35);
		panel.add(lblX);

		JLabel lblCadastroDeAlunos = new JLabel();
		lblCadastroDeAlunos.setText("Cadastro de Alunos");
		lblCadastroDeAlunos.setOpaque(true);
		lblCadastroDeAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeAlunos.setForeground(Color.WHITE);
		lblCadastroDeAlunos.setFont(new Font("Arial", Font.BOLD, 20));
		lblCadastroDeAlunos.setBackground(new Color(77, 20, 52));
		lblCadastroDeAlunos.setBounds(0, 0, 421, 35);
		panel.add(lblCadastroDeAlunos);

		

		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpfM = txtCPF.getText().replace(".", "").replace("-", "").replace(" ", "");
				if ((cpfM.trim()) != null) {
					if (ValidaCPF.isCPF(cpfM) == true) {
						cpf = (cpfM);
						func.setCPF(cpf);
						try {
							if (fDao.jaExiste(func)) {
								PreencherAluno();
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
								PreencherAluno();
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

								btnConsultaCEP.setEnabled(true);
								btnSalvar.setEnabled(true);
								btnExcluir.setEnabled(true);

								cmbCurso.setEnabled(true);
								cmbPeriodo.setEnabled(true);
								cmbTurma.setEnabled(true);

								buttonGroup.clearSelection();

								rdbtnBasico.setEnabled(true);
								rdbtnMedio.setEnabled(true);
								rdbtnAvanc.setEnabled(true);

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

								cmbCurso.setEnabled(true);
								cmbPeriodo.setEnabled(true);
								cmbTurma.setEnabled(true);

								buttonGroup.clearSelection();

								rdbtnBasico.setEnabled(true);
								rdbtnMedio.setEnabled(true);
								rdbtnAvanc.setEnabled(true);

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
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

	}

	public int ProximaMat() throws SQLException, ClassNotFoundException {
		try {
			AlunosDao fDao = new AlunosDao();
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
			func.setNome_Aluno(txtNome.getText());
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
			func.setNome_Aluno(txtNome.getText());
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
			fDao.Excluir(func);
			JOptionPane.showMessageDialog(null, "Dados Excluidos com sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void PreencherAluno() {
		try {
			fDao.PreencheAluno(func);
			txtMat.setText(String.valueOf(func.getMatricula()));
			txtNome.setText(func.getNome_Aluno());
			foneM = func.getTelefone().replace("(", "").replace(")", "").replace("-", "");
			// txtFone.setText(foneM);
			// txtCel.setText(func.getCelular());
			txtEmail.setText(func.getEmail());
			// txtCEP.setText(func.getCep());
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
