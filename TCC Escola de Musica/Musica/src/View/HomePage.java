package View;

import javax.swing.*;
import javax.swing.border.*;

import Controller.CursosController;
import Dao.AlunosDao;
import Dao.ConexaoDao;
import Dao.FuncionariosDao;
import Model.Alunos;
import Model.Cursos;
import Model.Funcionarios;
import Model.ValidaCPF;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class HomePage {

	JFrame frmHomePage;
	JTextField txtBuscFunc, txtCPFFunc, txtMatFunc, txtNomeFunc, txtFoneFunc, txtCelFunc, txtEmailFunc, txtCepFunc,
			txtEndFunc, txtBairroFunc, txtCidadeFunc, txtUFFunc, txtNumFunc, txtCompFunc, txtMatAluno, txtNomeAluno,
			txtEmailAluno, txtEndAluno, txtBairroAluno, txtCidadeAluno, txtNumAluno, txtCompAluno, txtUFAluno,
			txtBuscAluno, txtTurma, txtLimite, txtBuscTurma;
	JTable tblListTurma;
	JList<String> lstFunc, lstAlunos;
	JCheckBox chkCordas, chkSopro, chkPercussao, chkTeclas;
	JComboBox cmbCargo;
	DefaultListModel model;

	JButton btnNovoFunc, btnNovoAluno;

	Object[] options = { "Sim", "Não" };
	ConexaoDao c = new ConexaoDao();
	Funcionarios func = new Funcionarios();
	FuncionariosDao fDao = new FuncionariosDao();
	Alunos aluno = new Alunos();
	AlunosDao aDao = new AlunosDao();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmHomePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomePage() {
		initialize();
	}

	private void initialize() {
		CadAlunoNovo windowCadAluno = new CadAlunoNovo(this, true);
		CadFuncNovo windowCadFunc = new CadFuncNovo(this, true);
		CadCursoNovo windowCadCurso = new CadCursoNovo(this, true);
		CadTurmaNovo windowCadTurma = new CadTurmaNovo(this, true);
		CadUser windowCadUser = new CadUser(this, true);

		Login windowLogin = new Login();

		frmHomePage = new JFrame();
		frmHomePage.setTitle("Escola de M\u00FAsica");
		frmHomePage.setResizable(false);
		frmHomePage.getContentPane().setBackground(SystemColor.control);
		frmHomePage.setBounds(100, 100, 976, 647);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);
		frmHomePage.setUndecorated(true);
		frmHomePage.setLocationRelativeTo(null);

		// Icone dos botões -----------------------------------------
		ImageIcon imageBusca = new ImageIcon(getClass().getResource("/Imagens/binoculoo.png"));
		imageBusca.setImage(imageBusca.getImage().getScaledInstance(20, 20, 0));

		ImageIcon imageAdd = new ImageIcon(getClass().getResource("/Imagens/red plus.png"));
		imageAdd.setImage(imageAdd.getImage().getScaledInstance(15, 15, 0));

		ImageIcon imageAlt = new ImageIcon(getClass().getResource("/Imagens/lapis.png"));
		imageAlt.setImage(imageAlt.getImage().getScaledInstance(15, 15, 0));

		ImageIcon imageExcluir = new ImageIcon(getClass().getResource("/Imagens/lixeira.png"));
		imageExcluir.setImage(imageExcluir.getImage().getScaledInstance(15, 15, 0));

		ImageIcon imageLogo = new ImageIcon(getClass().getResource("/Imagens/LogoRoxaMenorzin.png"));
		imageLogo.setImage(imageLogo.getImage().getScaledInstance(93, 55, 0));

		// Painel ----------------------------------------
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 92, 954, 543);
		frmHomePage.getContentPane().add(tabbedPane);

		// Layout Painel Alunos
		JPanel pnlAluno = new JPanel();
		pnlAluno.setBackground(SystemColor.control);
		tabbedPane.addTab("Alunos", null, pnlAluno, null);
		pnlAluno.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Consulte CPF");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(161, 47, 82, 16);
		pnlAluno.add(lblNewLabel_1);

		lstAlunos = new JList();
		lstAlunos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String nomeFunc = String.valueOf(lstAlunos.getSelectedValue());
				func.setNome_Func(nomeFunc);
				PreencherFuncionario();
			}
		});
		lstAlunos.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		lstAlunos.setBounds(96, 70, 234, 351);
		pnlAluno.add(lstAlunos);

		JLabel lblCadastroDeFuncionrios_1 = new JLabel("Cadastro de Alunos");
		lblCadastroDeFuncionrios_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastroDeFuncionrios_1.setFont(new Font("Arial", Font.BOLD, 22));
		lblCadastroDeFuncionrios_1.setBounds(364, 12, 216, 31);
		pnlAluno.add(lblCadastroDeFuncionrios_1);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(SystemColor.control);
		panel_4_2.setLayout(null);
		panel_4_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_4_2.setBounds(364, 46, 389, 375);
		pnlAluno.add(panel_4_2);

		JLabel lblCPF_2 = new JLabel("*CPF");
		lblCPF_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblCPF_2.setEnabled(false);
		lblCPF_2.setBounds(23, 14, 30, 16);
		panel_4_2.add(lblCPF_2);

		JFormattedTextField txtCPFAluno = new JFormattedTextField();
		txtCPFAluno.setBackground(SystemColor.control);
		txtCPFAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCPFAluno.setEnabled(false);
		txtCPFAluno.setBounds(62, 14, 147, 20);
		panel_4_2.add(txtCPFAluno);

		JLabel lblRM_2 = new JLabel("*Matricula");
		lblRM_2.setEnabled(false);
		lblRM_2.setBounds(227, 13, 60, 16);
		panel_4_2.add(lblRM_2);

		txtMatAluno = new JTextField();
		txtMatAluno.setBackground(SystemColor.control);
		txtMatAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		txtMatAluno.setEnabled(false);
		txtMatAluno.setColumns(10);
		txtMatAluno.setBounds(292, 12, 83, 20);
		panel_4_2.add(txtMatAluno);

		JLabel lblNome_3 = new JLabel("Nome");
		lblNome_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNome_3.setEnabled(false);
		lblNome_3.setBounds(12, 50, 41, 16);
		panel_4_2.add(lblNome_3);

		txtNomeAluno = new JTextField();
		txtNomeAluno.setBackground(SystemColor.control);
		txtNomeAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNomeAluno.setEnabled(false);
		txtNomeAluno.setColumns(10);
		txtNomeAluno.setBounds(62, 50, 313, 20);
		panel_4_2.add(txtNomeAluno);

		JLabel lblNome_2_3 = new JLabel("Tel Fixo");
		lblNome_2_3.setEnabled(false);
		lblNome_2_3.setBounds(12, 74, 47, 16);
		panel_4_2.add(lblNome_2_3);

		JFormattedTextField txtFoneAluno = new JFormattedTextField();
		txtFoneAluno.setBackground(SystemColor.control);
		txtFoneAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		txtFoneAluno.setEnabled(false);
		txtFoneAluno.setBounds(62, 74, 121, 20);
		panel_4_2.add(txtFoneAluno);

		JLabel lblNome_2_1_1 = new JLabel("Celular");
		lblNome_2_1_1.setEnabled(false);
		lblNome_2_1_1.setBounds(201, 74, 47, 16);
		panel_4_2.add(lblNome_2_1_1);

		JFormattedTextField txtCelAluno = new JFormattedTextField();
		txtCelAluno.setBackground(SystemColor.control);
		txtCelAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCelAluno.setEnabled(false);
		txtCelAluno.setBounds(250, 73, 125, 20);
		panel_4_2.add(txtCelAluno);

		JLabel lblNome_2_2_1 = new JLabel("E-mail");
		lblNome_2_2_1.setEnabled(false);
		lblNome_2_2_1.setBounds(12, 98, 41, 16);
		panel_4_2.add(lblNome_2_2_1);

		txtEmailAluno = new JTextField();
		txtEmailAluno.setBackground(SystemColor.control);
		txtEmailAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmailAluno.setEnabled(false);
		txtEmailAluno.setColumns(10);
		txtEmailAluno.setBounds(62, 98, 313, 20);
		panel_4_2.add(txtEmailAluno);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setBackground(SystemColor.control);
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_4_1_1.setBounds(62, 124, 313, 141);
		panel_4_2.add(panel_4_1_1);

		JLabel lblRM_1_1 = new JLabel("CEP");
		lblRM_1_1.setEnabled(false);
		lblRM_1_1.setBounds(39, 12, 28, 16);
		panel_4_1_1.add(lblRM_1_1);

		JFormattedTextField txtCepAluno = new JFormattedTextField();
		txtCepAluno.setBackground(SystemColor.control);
		txtCepAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCepAluno.setEnabled(false);
		txtCepAluno.setBounds(72, 11, 78, 20);
		panel_4_1_1.add(txtCepAluno);

		JLabel lblNome_1_1 = new JLabel("Endere\u00E7o");
		lblNome_1_1.setEnabled(false);
		lblNome_1_1.setBounds(12, 36, 55, 16);
		panel_4_1_1.add(lblNome_1_1);

		txtEndAluno = new JTextField();
		txtEndAluno.setBackground(SystemColor.control);
		txtEndAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEndAluno.setEnabled(false);
		txtEndAluno.setColumns(10);
		txtEndAluno.setBounds(72, 36, 217, 20);
		panel_4_1_1.add(txtEndAluno);

		JLabel lblCPF_1_2_1 = new JLabel("Bairro");
		lblCPF_1_2_1.setEnabled(false);
		lblCPF_1_2_1.setBounds(25, 84, 42, 16);
		panel_4_1_1.add(lblCPF_1_2_1);

		txtBairroAluno = new JTextField();
		txtBairroAluno.setBackground(SystemColor.control);
		txtBairroAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		txtBairroAluno.setEnabled(false);
		txtBairroAluno.setColumns(10);
		txtBairroAluno.setBounds(72, 84, 217, 20);
		panel_4_1_1.add(txtBairroAluno);

		JLabel lblCPF_1_1_1_2 = new JLabel("Cidade");
		lblCPF_1_1_1_2.setEnabled(false);
		lblCPF_1_1_1_2.setBounds(25, 108, 42, 16);
		panel_4_1_1.add(lblCPF_1_1_1_2);

		txtCidadeAluno = new JTextField();
		txtCidadeAluno.setBackground(SystemColor.control);
		txtCidadeAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCidadeAluno.setEnabled(false);
		txtCidadeAluno.setColumns(10);
		txtCidadeAluno.setBounds(72, 108, 78, 20);
		panel_4_1_1.add(txtCidadeAluno);

		JLabel lblCPF_1_3 = new JLabel("N\u00FAmero");
		lblCPF_1_3.setEnabled(false);
		lblCPF_1_3.setBounds(22, 60, 45, 16);
		panel_4_1_1.add(lblCPF_1_3);

		txtNumAluno = new JTextField();
		txtNumAluno.setBackground(SystemColor.control);
		txtNumAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNumAluno.setEnabled(false);
		txtNumAluno.setColumns(10);
		txtNumAluno.setBounds(72, 60, 55, 20);
		panel_4_1_1.add(txtNumAluno);

		JLabel lblCPF_1_1_2 = new JLabel("UF");
		lblCPF_1_1_2.setEnabled(false);
		lblCPF_1_1_2.setBounds(193, 108, 28, 16);
		panel_4_1_1.add(lblCPF_1_1_2);

		JLabel lblCPF_1_1_1_1_1 = new JLabel("Compl.");
		lblCPF_1_1_1_1_1.setEnabled(false);
		lblCPF_1_1_1_1_1.setBounds(135, 60, 42, 16);
		panel_4_1_1.add(lblCPF_1_1_1_1_1);

		txtCompAluno = new JTextField();
		txtCompAluno.setBackground(SystemColor.control);
		txtCompAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCompAluno.setEnabled(false);
		txtCompAluno.setColumns(10);
		txtCompAluno.setBounds(184, 58, 105, 20);
		panel_4_1_1.add(txtCompAluno);

		txtUFAluno = new JTextField();
		txtUFAluno.setBackground(SystemColor.control);
		txtUFAluno.setEnabled(false);
		txtUFAluno.setFont(new Font("Arial", Font.BOLD, 12));
		txtUFAluno.setBounds(224, 108, 65, 20);
		panel_4_1_1.add(txtUFAluno);

		JLabel lblNewLabel_4 = new JLabel("Conhecimento");
		lblNewLabel_4.setEnabled(false);
		lblNewLabel_4.setBounds(62, 275, 90, 16);
		panel_4_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Curso");
		lblNewLabel_5.setEnabled(false);
		lblNewLabel_5.setBounds(193, 275, 55, 16);
		panel_4_2.add(lblNewLabel_5);

		JRadioButton rdbtnBasico = new JRadioButton("B\u00E1sico");
		rdbtnBasico.setEnabled(false);
		rdbtnBasico.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnBasico.setBackground(SystemColor.control);
		rdbtnBasico.setBounds(99, 293, 64, 20);
		panel_4_2.add(rdbtnBasico);

		JComboBox cmbCurso = new JComboBox();
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] { "---" }));
		cmbCurso.setEnabled(false);
		cmbCurso.setFont(new Font("Arial", Font.BOLD, 12));
		cmbCurso.setBounds(203, 293, 172, 20);
		panel_4_2.add(cmbCurso);

		JRadioButton rdbtnMdio = new JRadioButton("M\u00E9dio");
		rdbtnMdio.setEnabled(false);
		rdbtnMdio.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnMdio.setBackground(SystemColor.control);
		rdbtnMdio.setBounds(99, 317, 64, 20);
		panel_4_2.add(rdbtnMdio);

		JLabel lblNewLabel_6 = new JLabel("Per\u00EDodo");
		lblNewLabel_6.setEnabled(false);
		lblNewLabel_6.setBounds(233, 319, 44, 16);
		panel_4_2.add(lblNewLabel_6);

		JComboBox cmbPeriodo = new JComboBox();
		cmbPeriodo.setModel(new DefaultComboBoxModel(new String[] { "---" }));
		cmbPeriodo.setEnabled(false);
		cmbPeriodo.setFont(new Font("Arial", Font.BOLD, 12));
		cmbPeriodo.setBounds(285, 319, 90, 20);
		panel_4_2.add(cmbPeriodo);

		JRadioButton rdbtnAvanc = new JRadioButton("Avan\u00E7ado");
		rdbtnAvanc.setEnabled(false);
		rdbtnAvanc.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnAvanc.setBackground(SystemColor.control);
		rdbtnAvanc.setBounds(99, 342, 81, 20);
		panel_4_2.add(rdbtnAvanc);

		JLabel lblNewLabel_6_1 = new JLabel("Turma");
		lblNewLabel_6_1.setEnabled(false);
		lblNewLabel_6_1.setBounds(236, 343, 41, 16);
		panel_4_2.add(lblNewLabel_6_1);

		JComboBox cmbTurma = new JComboBox();
		cmbTurma.setModel(new DefaultComboBoxModel(new String[] { "---" }));
		cmbTurma.setEnabled(false);
		cmbTurma.setFont(new Font("Arial", Font.BOLD, 12));
		cmbTurma.setBounds(285, 343, 90, 20);
		panel_4_2.add(cmbTurma);

		btnNovoAluno = new JButton("Acessar");
		btnNovoAluno.setIcon(imageAdd);
		btnNovoAluno.setBounds(515, 433, 102, 26);
		pnlAluno.add(btnNovoAluno);

		txtBuscAluno = new JTextField();
		txtBuscAluno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				String cpf = txtBuscAluno.getText();
				Long cpfInt = Long.parseLong(cpf);

				if (cpfInt >= 11) {
					if (ValidaCPF.isCPF(cpf) == true) {
						aluno.setCPF(txtBuscAluno.getText());
						try {
							String sql = "select Nome_Aluno from TB_Aluno where CPF = ?";
							PreparedStatement ps = c.getConnection().prepareStatement(sql);
							ps.setString(1, aluno.getCPF());
							ResultSet rs = ps.executeQuery();

							while (rs.next()) {
								model = new DefaultListModel();
								model.addElement(rs.getString("Nome_Aluno"));
								lstAlunos.setModel(model);
							}
							rs.close();
							ps.close();

						} catch (SQLException | ClassNotFoundException e1) {
							e1.printStackTrace();
						}
					}
				} else {
					try {
						String sql = "select Nome_Aluno from TB_Aluno";
						PreparedStatement ps = c.getConnection().prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						DefaultListModel model = new DefaultListModel();

						while (rs.next()) {

							model.addElement(rs.getString("Nome_Aluno"));

						}
						rs.close();
						ps.close();
						lstAlunos.setModel(model);

					} catch (SQLException | ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		txtBuscAluno.setFont(new Font("Arial", Font.BOLD, 12));
		txtBuscAluno.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBuscAluno.setBackground(new Color(204, 204, 255));
		txtBuscAluno.setColumns(10);
		txtBuscAluno.setBounds(248, 46, 82, 20);
		pnlAluno.add(txtBuscAluno);

		JLabel lblListaDeTurmas_1_1_1 = new JLabel();
		lblListaDeTurmas_1_1_1.setIcon(imageBusca);
		lblListaDeTurmas_1_1_1.setBounds(334, 48, 24, 16);
		pnlAluno.add(lblListaDeTurmas_1_1_1);

		// Layout Painel Funcionários
		JPanel pnlFunc = new JPanel();
		pnlFunc.setBackground(SystemColor.control);
		tabbedPane.addTab("Funcion\u00E1rios", null, pnlFunc, null);
		pnlFunc.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.control);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_4.setBounds(364, 46, 389, 375);
		pnlFunc.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblCPF = new JLabel("*CPF");
		lblCPF.setEnabled(false);
		lblCPF.setFont(new Font("Arial", Font.BOLD, 12));
		lblCPF.setBounds(23, 14, 30, 16);
		panel_4.add(lblCPF);

		txtCPFFunc = new JTextField();
		txtCPFFunc.setEnabled(false);
		txtCPFFunc.setEditable(false);
		txtCPFFunc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCPFFunc.setBounds(62, 14, 147, 20);
		panel_4.add(txtCPFFunc);

		JLabel lblRM = new JLabel("*Matricula");
		lblRM.setEnabled(false);
		lblRM.setBounds(227, 13, 60, 16);
		panel_4.add(lblRM);

		txtMatFunc = new JTextField();
		txtMatFunc.setBackground(SystemColor.control);
		txtMatFunc.setEnabled(false);
		txtMatFunc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtMatFunc.setColumns(10);
		txtMatFunc.setBounds(292, 12, 83, 20);
		panel_4.add(txtMatFunc);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setEnabled(false);
		lblNome.setFont(new Font("Arial", Font.BOLD, 12));
		lblNome.setBounds(12, 50, 41, 16);
		panel_4.add(lblNome);

		txtNomeFunc = new JTextField();
		txtNomeFunc.setBackground(SystemColor.control);
		txtNomeFunc.setEnabled(false);
		txtNomeFunc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNomeFunc.setColumns(10);
		txtNomeFunc.setBounds(62, 50, 313, 20);
		panel_4.add(txtNomeFunc);

		JLabel lblNome_2 = new JLabel("Tel Fixo");
		lblNome_2.setEnabled(false);
		lblNome_2.setBounds(12, 74, 47, 16);
		panel_4.add(lblNome_2);

		txtFoneFunc = new JTextField();
		txtFoneFunc.setBackground(SystemColor.control);
		txtFoneFunc.setEnabled(false);
		txtFoneFunc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtFoneFunc.setBounds(62, 74, 121, 20);
		panel_4.add(txtFoneFunc);

		JLabel lblNome_2_1 = new JLabel("Celular");
		lblNome_2_1.setEnabled(false);
		lblNome_2_1.setBounds(201, 74, 47, 16);
		panel_4.add(lblNome_2_1);

		txtCelFunc = new JTextField();
		txtCelFunc.setBackground(SystemColor.control);
		txtCelFunc.setEnabled(false);
		txtCelFunc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCelFunc.setBounds(250, 73, 125, 20);
		panel_4.add(txtCelFunc);

		JLabel lblNome_2_2 = new JLabel("E-mail");
		lblNome_2_2.setEnabled(false);
		lblNome_2_2.setBounds(12, 98, 41, 16);
		panel_4.add(lblNome_2_2);

		txtEmailFunc = new JTextField();
		txtEmailFunc.setBackground(SystemColor.control);
		txtEmailFunc.setEnabled(false);
		txtEmailFunc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmailFunc.setColumns(10);
		txtEmailFunc.setBounds(62, 98, 313, 20);
		panel_4.add(txtEmailFunc);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(SystemColor.control);
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_4_1.setBounds(62, 124, 313, 141);
		panel_4.add(panel_4_1);

		JLabel lblRM_1 = new JLabel("CEP");
		lblRM_1.setEnabled(false);
		lblRM_1.setBounds(39, 12, 28, 16);
		panel_4_1.add(lblRM_1);

		txtCepFunc = new JTextField();
		txtCepFunc.setBackground(SystemColor.control);
		txtCepFunc.setEnabled(false);
		txtCepFunc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCepFunc.setBounds(72, 11, 78, 20);
		panel_4_1.add(txtCepFunc);

		JLabel lblNome_1 = new JLabel("Endere\u00E7o");
		lblNome_1.setEnabled(false);
		lblNome_1.setBounds(12, 36, 55, 16);
		panel_4_1.add(lblNome_1);

		txtEndFunc = new JTextField();
		txtEndFunc.setBackground(SystemColor.control);
		txtEndFunc.setEnabled(false);
		txtEndFunc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEndFunc.setColumns(10);
		txtEndFunc.setBounds(72, 36, 217, 20);
		panel_4_1.add(txtEndFunc);

		JLabel lblCPF_1_2 = new JLabel("Bairro");
		lblCPF_1_2.setEnabled(false);
		lblCPF_1_2.setBounds(25, 84, 42, 16);
		panel_4_1.add(lblCPF_1_2);

		txtBairroFunc = new JTextField();
		txtBairroFunc.setBackground(SystemColor.control);
		txtBairroFunc.setEnabled(false);
		txtBairroFunc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtBairroFunc.setColumns(10);
		txtBairroFunc.setBounds(72, 84, 217, 20);
		panel_4_1.add(txtBairroFunc);

		JLabel lblCPF_1_1_1 = new JLabel("Cidade");
		lblCPF_1_1_1.setEnabled(false);
		lblCPF_1_1_1.setBounds(25, 108, 42, 16);
		panel_4_1.add(lblCPF_1_1_1);

		txtCidadeFunc = new JTextField();
		txtCidadeFunc.setBackground(SystemColor.control);
		txtCidadeFunc.setEnabled(false);
		txtCidadeFunc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCidadeFunc.setColumns(10);
		txtCidadeFunc.setBounds(72, 108, 78, 20);
		panel_4_1.add(txtCidadeFunc);

		JLabel lblCPF_1 = new JLabel("N\u00FAmero");
		lblCPF_1.setEnabled(false);
		lblCPF_1.setBounds(22, 60, 45, 16);
		panel_4_1.add(lblCPF_1);

		txtNumFunc = new JTextField();
		txtNumFunc.setBackground(SystemColor.control);
		txtNumFunc.setEnabled(false);
		txtNumFunc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNumFunc.setColumns(10);
		txtNumFunc.setBounds(72, 60, 55, 20);
		panel_4_1.add(txtNumFunc);

		JLabel lblCPF_1_1 = new JLabel("UF");
		lblCPF_1_1.setEnabled(false);
		lblCPF_1_1.setBounds(193, 108, 28, 16);
		panel_4_1.add(lblCPF_1_1);

		JLabel lblCPF_1_1_1_1 = new JLabel("Compl.");
		lblCPF_1_1_1_1.setEnabled(false);
		lblCPF_1_1_1_1.setBounds(135, 60, 42, 16);
		panel_4_1.add(lblCPF_1_1_1_1);

		txtCompFunc = new JTextField();
		txtCompFunc.setBackground(SystemColor.control);
		txtCompFunc.setEnabled(false);
		txtCompFunc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCompFunc.setColumns(10);
		txtCompFunc.setBounds(184, 58, 105, 20);
		panel_4_1.add(txtCompFunc);

		txtUFFunc = new JTextField();
		txtUFFunc.setBackground(SystemColor.control);
		txtUFFunc.setEnabled(false);
		txtUFFunc.setFont(new Font("Arial", Font.BOLD, 12));
		txtUFFunc.setBounds(224, 108, 65, 20);
		panel_4_1.add(txtUFFunc);

		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setEnabled(false);
		lblEspecialidade.setFont(new Font("Arial", Font.BOLD, 12));
		lblEspecialidade.setBounds(62, 276, 83, 16);
		panel_4.add(lblEspecialidade);

		chkCordas = new JCheckBox("Cordas");
		chkCordas.setEnabled(false);
		chkCordas.setBackground(SystemColor.control);
		chkCordas.setBounds(72, 297, 71, 20);
		panel_4.add(chkCordas);

		chkTeclas = new JCheckBox("Teclas");
		chkTeclas.setEnabled(false);
		chkTeclas.setBackground(SystemColor.control);
		chkTeclas.setBounds(72, 319, 65, 20);
		panel_4.add(chkTeclas);

		chkSopro = new JCheckBox("Sopro");
		chkSopro.setEnabled(false);
		chkSopro.setBackground(SystemColor.control);
		chkSopro.setBounds(146, 297, 65, 20);
		panel_4.add(chkSopro);

		chkPercussao = new JCheckBox("Percuss\u00E3o");
		chkPercussao.setEnabled(false);
		chkPercussao.setBackground(SystemColor.control);
		chkPercussao.setBounds(146, 319, 92, 20);
		panel_4.add(chkPercussao);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setEnabled(false);
		lblCargo.setFont(new Font("Arial", Font.BOLD, 12));
		lblCargo.setBounds(246, 273, 41, 16);
		panel_4.add(lblCargo);

		JComboBox cmbCargo = new JComboBox();
		cmbCargo.setModel(
				new DefaultComboBoxModel(new String[] { "---", "Administrador", "Professor", "Recepcionista" }));
		cmbCargo.setEnabled(false);
		cmbCargo.setBounds(254, 297, 121, 20);
		panel_4.add(cmbCargo);

		lstFunc = new JList();
		lstFunc.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String nomeFunc = String.valueOf(lstFunc.getSelectedValue());
				func.setNome_Func(nomeFunc);
				PreencherFuncionario();
			}
		});
		lstFunc.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		lstFunc.setBounds(96, 70, 234, 351);
		pnlFunc.add(lstFunc);

		JLabel lblCadastroDeFuncionrios = new JLabel("Cadastro de Funcion\u00E1rios");
		lblCadastroDeFuncionrios.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastroDeFuncionrios.setFont(new Font("Arial", Font.BOLD, 22));
		lblCadastroDeFuncionrios.setBounds(364, 12, 276, 31);
		pnlFunc.add(lblCadastroDeFuncionrios);

		btnNovoFunc = new JButton("Acessar");
		btnNovoFunc.setIcon(imageAdd);
		btnNovoFunc.setBounds(515, 433, 102, 26);
		pnlFunc.add(btnNovoFunc);

		txtBuscFunc = new JTextField();
		txtBuscFunc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				String cpf = txtBuscFunc.getText();
				Long cpfInt = Long.parseLong(cpf);

				if (cpfInt >= 11) {
					if (ValidaCPF.isCPF(cpf) == true) {
						func.setCPF(txtBuscFunc.getText());
						try {
							String sql = "select Nome_Func from TB_Funcionario where CPF = ?";
							PreparedStatement ps = c.getConnection().prepareStatement(sql);
							ps.setString(1, func.getCPF());
							ResultSet rs = ps.executeQuery();

							while (rs.next()) {
								model = new DefaultListModel();
								model.addElement(rs.getString("Nome_Func"));
								lstFunc.setModel(model);
							}
							rs.close();
							ps.close();

						} catch (SQLException | ClassNotFoundException e1) {
							e1.printStackTrace();
						}
					}
				} else {
					try {
						String sql = "select Nome_Func from TB_Funcionario";
						PreparedStatement ps = c.getConnection().prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						DefaultListModel model = new DefaultListModel();

						while (rs.next()) {

							model.addElement(rs.getString("Nome_Func"));

						}
						rs.close();
						ps.close();
						lstFunc.setModel(model);

					} catch (SQLException | ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		txtBuscFunc.setFont(new Font("Arial", Font.BOLD, 12));
		txtBuscFunc.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBuscFunc.setBackground(new Color(204, 204, 255));
		txtBuscFunc.setBounds(248, 46, 82, 20);
		pnlFunc.add(txtBuscFunc);
		txtBuscFunc.setColumns(10);

		JLabel lblListaDeTurmas_1_1 = new JLabel();
		lblListaDeTurmas_1_1.setIcon(imageBusca);
		lblListaDeTurmas_1_1.setBounds(334, 48, 24, 16);
		pnlFunc.add(lblListaDeTurmas_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("Consulte CPF");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(161, 47, 82, 16);
		pnlFunc.add(lblNewLabel_1_1);

		// Painel -----------------------
		// Aluno ------------------
		btnNovoAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowCadAluno.frmAluno.setVisible(true);
			}
		});
		// Funcionário ------------
		btnNovoFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtCPFFunc.getText()!=null) {
					windowCadFunc.frmCadFunc.setVisible(true);

					windowCadFunc.txtCPF.setText(txtCPFFunc.getText());	

				}else {
					
				}
				
			}
		});

		// Turma ------------------

		// -----------------------------------------------------------

		// Painel Turma
		JPanel pnlTurma = new JPanel();
		pnlTurma.setBackground(SystemColor.control);
		tabbedPane.addTab("Turmas", null, pnlTurma, null);
		pnlTurma.setLayout(null);

		JPanel panel_4_3 = new JPanel();
		panel_4_3.setLayout(null);
		panel_4_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_4_3.setBackground(SystemColor.menu);
		panel_4_3.setBounds(45, 86, 324, 208);
		pnlTurma.add(panel_4_3);

		JLabel lblNewLabel_5_1 = new JLabel("Turma");
		lblNewLabel_5_1.setEnabled(false);
		lblNewLabel_5_1.setBounds(55, 38, 37, 16);
		panel_4_3.add(lblNewLabel_5_1);

		txtTurma = new JTextField();
		txtTurma.setBackground(SystemColor.control);
		txtTurma.setEnabled(false);
		txtTurma.setColumns(10);
		txtTurma.setBounds(101, 36, 64, 20);
		panel_4_3.add(txtTurma);

		JLabel lblNewLabel_5_3 = new JLabel("Limite");
		lblNewLabel_5_3.setEnabled(false);
		lblNewLabel_5_3.setBounds(171, 38, 37, 16);
		panel_4_3.add(lblNewLabel_5_3);

		txtLimite = new JTextField();
		txtLimite.setBackground(SystemColor.control);
		txtLimite.setEnabled(false);
		txtLimite.setColumns(10);
		txtLimite.setBounds(212, 36, 55, 20);
		panel_4_3.add(txtLimite);

		JLabel lblNewLabel_5_2 = new JLabel("Curso");
		lblNewLabel_5_2.setEnabled(false);
		lblNewLabel_5_2.setBounds(55, 67, 37, 16);
		panel_4_3.add(lblNewLabel_5_2);

		JComboBox cmbCursoTurma = new JComboBox();
		cmbCursoTurma.setEnabled(false);
		cmbCursoTurma.setFont(new Font("Arial", Font.BOLD, 12));
		cmbCursoTurma.setBounds(95, 66, 172, 20);
		panel_4_3.add(cmbCursoTurma);

		JLabel lblNewLabel_6_2 = new JLabel("Per\u00EDodo");
		lblNewLabel_6_2.setEnabled(false);
		lblNewLabel_6_2.setBounds(105, 95, 44, 16);
		panel_4_3.add(lblNewLabel_6_2);

		JComboBox cmbPeriodoTurma = new JComboBox();
		cmbPeriodoTurma.setEnabled(false);
		cmbPeriodoTurma.setFont(new Font("Arial", Font.BOLD, 12));
		cmbPeriodoTurma.setBounds(154, 95, 113, 20);
		panel_4_3.add(cmbPeriodoTurma);

		JLabel lblNewLabel_4_1 = new JLabel("N\u00EDvel");
		lblNewLabel_4_1.setEnabled(false);
		lblNewLabel_4_1.setBounds(115, 124, 37, 16);
		panel_4_3.add(lblNewLabel_4_1);

		JComboBox cmbNvlTurma = new JComboBox();
		cmbNvlTurma.setEnabled(false);
		cmbNvlTurma.setFont(new Font("Arial", Font.BOLD, 12));
		cmbNvlTurma.setBounds(154, 123, 113, 20);
		panel_4_3.add(cmbNvlTurma);

		JLabel lblNewLabel_5_2_1 = new JLabel("Professor");
		lblNewLabel_5_2_1.setEnabled(false);
		lblNewLabel_5_2_1.setBounds(55, 152, 64, 16);
		panel_4_3.add(lblNewLabel_5_2_1);

		JComboBox cmbProfTurma = new JComboBox();
		cmbProfTurma.setEnabled(false);
		cmbProfTurma.setFont(new Font("Arial", Font.BOLD, 12));
		cmbProfTurma.setBounds(115, 152, 152, 20);
		panel_4_3.add(cmbProfTurma);

		JLabel lblListaDeTurmas = new JLabel("Turmas:");
		lblListaDeTurmas.setBounds(410, 67, 77, 16);
		pnlTurma.add(lblListaDeTurmas);

		JButton btnNovaTurma = new JButton("Acessar");
		btnNovaTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowCadTurma.frmTurmas.setVisible(true);
			}
		});
		btnNovaTurma.setIcon(imageAdd);
		btnNovaTurma.setBounds(157, 306, 102, 26);
		pnlTurma.add(btnNovaTurma);

		JLabel lblCadastroDeTurmas = new JLabel("Cadastro de Turmas");
		lblCadastroDeTurmas.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastroDeTurmas.setFont(new Font("Arial", Font.BOLD, 22));
		lblCadastroDeTurmas.setBounds(45, 52, 225, 31);
		pnlTurma.add(lblCadastroDeTurmas);

		tblListTurma = new JTable();
		tblListTurma.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		tblListTurma.setBounds(410, 87, 487, 345);
		pnlTurma.add(tblListTurma);

		txtBuscTurma = new JTextField();
		txtBuscTurma.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBuscTurma.setFont(new Font("Arial", Font.BOLD, 12));
		txtBuscTurma.setColumns(10);
		txtBuscTurma.setBackground(new Color(204, 204, 255));
		txtBuscTurma.setBounds(489, 64, 98, 20);
		pnlTurma.add(txtBuscTurma);

		JLabel lblListaDeTurmas_1 = new JLabel();
		lblListaDeTurmas_1.setIcon(imageBusca);
		lblListaDeTurmas_1.setBounds(592, 67, 24, 16);
		pnlTurma.add(lblListaDeTurmas_1);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 976, 75);
		frmHomePage.getContentPane().add(panel);
		panel.setLayout(null);

		// -----------------------------------------------------------

		// Criação da Tela ------------------------------------------

		// Menus --------------------------------------------
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(77, 20, 52));
		menuBar.setBounds(0, 55, 976, 23);
		panel.add(menuBar);
		JMenu mnCurso = new JMenu("Curso");
		mnCurso.setForeground(Color.WHITE);
		menuBar.add(mnCurso);
		JMenuItem mnCadCurso = new JMenuItem("Cadastro");
		mnCurso.add(mnCadCurso);
		JMenu mnSystem = new JMenu("Sistema");
		mnSystem.setForeground(Color.WHITE);
		menuBar.add(mnSystem);

		JMenuItem mnCadUser = new JMenuItem("Cadastrar Usu\u00E1rio");
		mnCadUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowCadUser.frmCadUser.setVisible(true);
			}
		});
		mnSystem.add(mnCadUser);

		JLabel lblCadastroDeTurmas_1 = new JLabel();
		lblCadastroDeTurmas_1.setForeground(Color.WHITE);
		lblCadastroDeTurmas_1.setText("Sistema Escola de M\u00FAsica");
		lblCadastroDeTurmas_1.setOpaque(true);
		lblCadastroDeTurmas_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeTurmas_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblCadastroDeTurmas_1.setBackground(new Color(77, 20, 52));
		lblCadastroDeTurmas_1.setBounds(0, 0, 886, 54);
		panel.add(lblCadastroDeTurmas_1);

		JLabel lblCadastroDeTurmas_1_1 = new JLabel();
		lblCadastroDeTurmas_1_1.setOpaque(true);
		lblCadastroDeTurmas_1_1.setIcon(imageLogo);
		lblCadastroDeTurmas_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastroDeTurmas_1_1.setFont(new Font("Arial", Font.BOLD, 22));
		lblCadastroDeTurmas_1_1.setBackground(new Color(77, 20, 52));
		lblCadastroDeTurmas_1_1.setBounds(885, 0, 91, 54);
		panel.add(lblCadastroDeTurmas_1_1);

		lblCadastroDeTurmas_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				frmHomePage.setVisible(false);
				windowLogin.setVisible(true);
			}
		});

		// -----------------------------------------------------------

		// Função dos botões ----------------------------------------
		// Menus ----------------------
		mnCadCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowCadCurso.frmCadastroDeCurso.setVisible(true);
			}
		});

		try {
			String sql = "select Nome_Func from TB_Funcionario";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			model = new DefaultListModel();

			while (rs.next()) {

				model.addElement(rs.getString("Nome_Func"));

			}
			rs.close();
			ps.close();
			lstFunc.setModel(model);

		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			String sql = "select Nome_Aluno from TB_Aluno";
			PreparedStatement ps = c.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			model = new DefaultListModel();

			while (rs.next()) {

				model.addElement(rs.getString("Nome_Aluno"));

			}
			rs.close();
			ps.close();
			lstAlunos.setModel(model);

		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	public void PreencherFuncionario() {
		try {
			fDao.PreencheDados(func);
			txtMatFunc.setText(String.valueOf(func.getMatricula()));
			txtCPFFunc.setText(func.getCPF());
			txtNomeFunc.setText(func.getNome_Func());
			txtFoneFunc.setText(func.getTelefone());
			txtCelFunc.setText(func.getCelular());
			txtEmailFunc.setText(func.getEmail());
			txtCepFunc.setText(func.getCep());
			txtEndFunc.setText(func.getEndereco());
			txtNumFunc.setText(func.getNum());
			txtCompFunc.setText(func.getComplemento());
			txtBairroFunc.setText(func.getBairro());
			txtCidadeFunc.setText(func.getCidade());
			txtUFFunc.setText(func.getEstado());

			if (func.getCategoria1() == "Cordas") {
				chkCordas.setSelected(true);
			} else {
				chkCordas.setSelected(false);
			}

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}

	}
}