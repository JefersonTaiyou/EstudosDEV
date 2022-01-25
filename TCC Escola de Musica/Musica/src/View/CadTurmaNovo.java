package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.awt.Font;
import java.awt.HeadlessException;

import java.awt.SystemColor;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import Dao.ConexaoDao;
import Dao.CursosDao;
import Dao.FuncionariosDao;
import Dao.TurmasDao;
import Model.Cursos;
import Model.Funcionarios;
import Model.Turmas;
import Model.cNivel;
import Model.cPeriodo;

import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CadTurmaNovo extends JDialog {

	JDialog frmTurmas;
	JTextField txtTurma;
	DefaultComboBoxModel defaultCmbFunc, defaultCmbCurso, defaultCmbPeriodo, defaultCmbNivel;
	JComboBox cmbPeriodo, cmbNivel, cmbCurso, cmbProfessor;
	String curso;
	JPanel panel_4;
	ImageIcon imageSave, imageCancel;
	JButton btnSalvar, btnSair;

	ConexaoDao c = new ConexaoDao();
	Funcionarios func = new Funcionarios();
	Cursos cursos = new Cursos();
	FuncionariosDao fDao = new FuncionariosDao();
	Turmas turma = new Turmas();
	TurmasDao tDao = new TurmasDao();

	public CadTurmaNovo(HomePage homePage, boolean modal) {
		super();
		initialize();
	}

	private void initialize() {
		frmTurmas = new JDialog();
		frmTurmas.setUndecorated(true);
		frmTurmas.setResizable(false);
		frmTurmas.setModal(true);
		frmTurmas.getContentPane().setBackground(SystemColor.controlHighlight);
		frmTurmas.setTitle("Turmas");
		frmTurmas.setBounds(100, 100, 379, 298);
		frmTurmas.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frmTurmas.getContentPane().setLayout(null);
		frmTurmas.setLocationRelativeTo(null);

		PreencherList();

		imageSave = new ImageIcon(getClass().getResource("/Imagens/Save.png"));
		imageSave.setImage(imageSave.getImage().getScaledInstance(18, 18, 0));

		imageCancel = new ImageIcon(getClass().getResource("/Imagens/cancel.png"));
		imageCancel.setImage(imageCancel.getImage().getScaledInstance(15, 15, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 379, 298);
		frmTurmas.getContentPane().add(panel);
		panel.setLayout(null);

		panel_4 = new JPanel();
		panel_4.setBounds(33, 47, 313, 195);
		panel.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblNewLabel_5_1 = new JLabel("Turma");
		lblNewLabel_5_1.setBounds(55, 32, 37, 16);
		panel_4.add(lblNewLabel_5_1);

		txtTurma = new JTextField();
		txtTurma.setBounds(101, 30, 64, 20);
		panel_4.add(txtTurma);
		txtTurma.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Curso");
		lblNewLabel_5.setBounds(55, 61, 37, 16);
		panel_4.add(lblNewLabel_5);

		cmbCurso = new JComboBox();
		cmbCurso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				curso = String.valueOf(cmbCurso.getSelectedItem().toString());
				PreencherPeriodo();
			}
		});
		cmbCurso.setBounds(95, 60, 172, 20);
		panel_4.add(cmbCurso);
		cmbCurso.setModel(defaultCmbCurso);

		JLabel lblNewLabel_5_2 = new JLabel("Professor");
		lblNewLabel_5_2.setBounds(55, 146, 64, 16);
		panel_4.add(lblNewLabel_5_2);

		cmbProfessor = new JComboBox();
		cmbProfessor.setBounds(115, 146, 152, 20);
		panel_4.add(cmbProfessor);
		cmbProfessor.setModel(defaultCmbFunc);
		cmbProfessor.setFont(new Font("Arial", Font.BOLD, 12));

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(86, 254, 98, 26);
		panel.add(btnSalvar);
		btnSalvar.setIcon(imageSave);

		btnSair = new JButton("Sair");
		btnSair.setBounds(206, 254, 98, 26);
		panel.add(btnSair);
		btnSair.setIcon(imageCancel);

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
				Object[] options = { "Sim", "Não" };

				if (JOptionPane.showOptionDialog(null, "Deseja realmente sair?", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {

					frmTurmas.setVisible(false);
				}
			}
		});
		lblX.setText("X");
		lblX.setOpaque(true);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 16));
		lblX.setBackground(new Color(77, 20, 52));
		lblX.setBounds(332, 0, 47, 35);
		panel.add(lblX);

		JLabel lblCadastroDeTurmas = new JLabel();
		lblCadastroDeTurmas.setText("Cadastro de Turmas");
		lblCadastroDeTurmas.setOpaque(true);
		lblCadastroDeTurmas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeTurmas.setForeground(Color.WHITE);
		lblCadastroDeTurmas.setFont(new Font("Arial", Font.BOLD, 20));
		lblCadastroDeTurmas.setBackground(new Color(77, 20, 52));
		lblCadastroDeTurmas.setBounds(0, 0, 379, 35);
		panel.add(lblCadastroDeTurmas);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Sim", "Não" };

				if (JOptionPane.showOptionDialog(null, "Deseja realmente sair?", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {

					frmTurmas.setVisible(false);
				}
			}
		});
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					txtTurma.setText(null);

					cmbCurso.setSelectedIndex(0);
					cmbPeriodo.setSelectedIndex(0);
					cmbNivel.setSelectedIndex(0);
					cmbProfessor.setSelectedIndex(0);

				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	public void PreencherList() {
		try {

			cursos.setNome_Curso(curso);
			List<Funcionarios> lFunc = tDao.recuperarFuncPorNome();
			defaultCmbFunc = new DefaultComboBoxModel(lFunc.toArray());

			List<Cursos> lCurso = tDao.recuperarCursoPorNome();
			defaultCmbCurso = new DefaultComboBoxModel(lCurso.toArray());

		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public void PreencherPeriodo() {
		try {

			cursos.setNome_Curso(curso);
			JOptionPane.showMessageDialog(null, cursos.getNome_Curso());

			List<cPeriodo> lPeriodo = tDao.recuperarPeriodoCurso();
			defaultCmbPeriodo = new DefaultComboBoxModel(lPeriodo.toArray());

			JLabel lblNewLabel_6 = new JLabel("Per\u00EDodo");
			lblNewLabel_6.setBounds(105, 89, 44, 16);
			panel_4.add(lblNewLabel_6);

			cmbPeriodo = new JComboBox();
			cmbPeriodo.setModel(defaultCmbPeriodo);
			cmbPeriodo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					PreencherNivel();
				}
			});
			cmbPeriodo.setBounds(154, 89, 113, 20);
			panel_4.add(cmbPeriodo);

			JOptionPane.showMessageDialog(null, defaultCmbPeriodo);

		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public void PreencherNivel() {
		try {

			List<cNivel> lNivel = tDao.recuperarNivelCurso();
			defaultCmbNivel = new DefaultComboBoxModel(lNivel.toArray());

			JLabel lblNewLabel_4 = new JLabel("N\u00EDvel");
			lblNewLabel_4.setBounds(115, 118, 37, 16);
			panel_4.add(lblNewLabel_4);

			cmbNivel = new JComboBox();
			cmbNivel.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {

				}
			});
			cmbNivel.setBounds(154, 117, 113, 20);
			panel_4.add(cmbNivel);
			cmbNivel.setModel(defaultCmbNivel);

		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public void Salvar() {
		// fDao.Salvar(func);
		JOptionPane.showMessageDialog(null, "Dados Cadastrados com sucesso", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
