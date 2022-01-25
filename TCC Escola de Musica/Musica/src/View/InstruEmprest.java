package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class InstruEmprest {

	private JFrame frmEmprstimoDeInstrumentos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;
	private JTextField txtJefersonSabinoDos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstruEmprest window = new InstruEmprest();
					window.frmEmprstimoDeInstrumentos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InstruEmprest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmprstimoDeInstrumentos = new JFrame();
		frmEmprstimoDeInstrumentos.getContentPane().setBackground(SystemColor.controlHighlight);
		frmEmprstimoDeInstrumentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmprstimoDeInstrumentos.setResizable(false);
		frmEmprstimoDeInstrumentos.setTitle("Empr\u00E9stimo de Instrumentos");
		frmEmprstimoDeInstrumentos.setBounds(100, 100, 570, 500);
		frmEmprstimoDeInstrumentos.getContentPane().setLayout(null);
		frmEmprstimoDeInstrumentos.setLocationRelativeTo(null);
		
		JList list = new JList();
		list.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		list.setBounds(38, 154, 182, 283);
		frmEmprstimoDeInstrumentos.getContentPane().add(list);
		
		JRadioButton rdbtnCordas = new JRadioButton("Cordas");
		buttonGroup.add(rdbtnCordas);
		rdbtnCordas.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnCordas.setBackground(SystemColor.controlHighlight);
		rdbtnCordas.setBounds(38, 75, 73, 20);
		frmEmprstimoDeInstrumentos.getContentPane().add(rdbtnCordas);
		
		JRadioButton rdbtnTeclas = new JRadioButton("Teclas");
		buttonGroup.add(rdbtnTeclas);
		rdbtnTeclas.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnTeclas.setBackground(SystemColor.controlHighlight);
		rdbtnTeclas.setBounds(115, 75, 73, 20);
		frmEmprstimoDeInstrumentos.getContentPane().add(rdbtnTeclas);
		
		JRadioButton rdbtnSopro = new JRadioButton("Sopro");
		buttonGroup.add(rdbtnSopro);
		rdbtnSopro.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnSopro.setBackground(SystemColor.controlHighlight);
		rdbtnSopro.setBounds(38, 99, 73, 20);
		frmEmprstimoDeInstrumentos.getContentPane().add(rdbtnSopro);
		
		JRadioButton rdbtnPercussao = new JRadioButton("Percuss\u00E3o");
		buttonGroup.add(rdbtnPercussao);
		rdbtnPercussao.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnPercussao.setBackground(SystemColor.controlHighlight);
		rdbtnPercussao.setBounds(115, 99, 87, 20);
		frmEmprstimoDeInstrumentos.getContentPane().add(rdbtnPercussao);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria:");
		lblNewLabel_1.setBounds(38, 51, 66, 16);
		frmEmprstimoDeInstrumentos.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Instrumentos Dispon\u00EDveis:");
		lblNewLabel_1_1.setBounds(38, 134, 156, 16);
		frmEmprstimoDeInstrumentos.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnPegar = new JButton("Pegar");
		btnPegar.setBounds(249, 411, 86, 26);
		frmEmprstimoDeInstrumentos.getContentPane().add(btnPegar);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setEnabled(false);
		btnDevolver.setBounds(347, 411, 86, 26);
		frmEmprstimoDeInstrumentos.getContentPane().add(btnDevolver);
		
		JButton btnDeletar_1 = new JButton("Cancelar");
		btnDeletar_1.setBounds(445, 411, 86, 26);
		frmEmprstimoDeInstrumentos.getContentPane().add(btnDeletar_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(153, 180, 209), 1, true), "Dados do Instrumento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(249, 218, 282, 181);
		frmEmprstimoDeInstrumentos.getContentPane().add(panel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nome");
		lblNewLabel_1_2.setBounds(33, 60, 36, 16);
		panel.add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.control);
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(69, 58, 201, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setBounds(25, 88, 63, 16);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setBounds(90, 84, 180, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Marca");
		lblNewLabel_3.setBounds(25, 116, 36, 16);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.control);
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(69, 116, 201, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("Modelo");
		lblNewLabel_4.setBounds(25, 144, 46, 16);
		panel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.control);
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(69, 142, 201, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_4_1 = new JLabel("CI");
		lblNewLabel_4_1.setBounds(50, 30, 18, 16);
		panel.add(lblNewLabel_4_1);
		
		textField_4 = new JTextField();
		textField_4.setBackground(SystemColor.control);
		textField_4.setEnabled(false);
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setColumns(10);
		textField_4.setBounds(68, 28, 82, 20);
		panel.add(textField_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(153, 180, 209), 1, true), "Dados do Aluno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBounds(249, 51, 282, 165);
		frmEmprstimoDeInstrumentos.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(24, 25, 29, 16);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(54, 23, 125, 20);
		panel_1.add(textField);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.BOLD, 12));
		lblNome.setBounds(12, 57, 41, 16);
		panel_1.add(lblNome);
		
		txtJefersonSabinoDos = new JTextField();
		txtJefersonSabinoDos.setEnabled(false);
		txtJefersonSabinoDos.setForeground(SystemColor.desktop);
		txtJefersonSabinoDos.setBackground(SystemColor.control);
		txtJefersonSabinoDos.setFont(new Font("Arial", Font.PLAIN, 12));
		txtJefersonSabinoDos.setColumns(10);
		txtJefersonSabinoDos.setBounds(54, 55, 216, 20);
		panel_1.add(txtJefersonSabinoDos);
		
		JLabel lblNewLabel_5 = new JLabel("Curso");
		lblNewLabel_5.setBounds(12, 91, 41, 16);
		panel_1.add(lblNewLabel_5);
		
		JComboBox cmbCurso = new JComboBox();
		cmbCurso.setEnabled(false);
		cmbCurso.setFont(new Font("Arial", Font.BOLD, 12));
		cmbCurso.setBounds(53, 90, 217, 20);
		panel_1.add(cmbCurso);
		
		JLabel lblNewLabel_6_1 = new JLabel("Turma");
		lblNewLabel_6_1.setBounds(12, 123, 41, 16);
		panel_1.add(lblNewLabel_6_1);
		
		JComboBox cmbTurma = new JComboBox();
		cmbTurma.setEnabled(false);
		cmbTurma.setFont(new Font("Arial", Font.BOLD, 12));
		cmbTurma.setBounds(54, 122, 216, 20);
		panel_1.add(cmbTurma);
		
		JLabel lblCadastroDeFuncionrios_1 = new JLabel("Emprestimo de Instrumentos");
		lblCadastroDeFuncionrios_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastroDeFuncionrios_1.setFont(new Font("Arial", Font.BOLD, 22));
		lblCadastroDeFuncionrios_1.setBounds(111, 12, 307, 31);
		frmEmprstimoDeInstrumentos.getContentPane().add(lblCadastroDeFuncionrios_1);
	}
}
