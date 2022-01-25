package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Dao.FuncionariosDao;
import Model.Funcionarios;
import Model.ValidaCPF;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NovaSenha extends JFrame {
	private JPasswordField txtSenha;
	private JPanel panel;
	private JLabel painelLogo;

	JFrame frmSenha;
	private JTextField textField;
	private JPasswordField passwordField;
	Object[] options = { "Sim", "Não" };

	Funcionarios func = new Funcionarios();
	FuncionariosDao fDao = new FuncionariosDao();

	private JPanel contentPane;
	private JPasswordField txtRepet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaSenha frame = new NovaSenha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NovaSenha() {
		ImageIcon imageLogo = new ImageIcon(getClass().getResource("/Imagens/LogoRoxa.png"));
		imageLogo.setImage(imageLogo.getImage().getScaledInstance(232, 134, 0));
		
		ImageIcon imageValidate = new ImageIcon(getClass().getResource("/Imagens/Validate.png"));
		imageValidate.setImage(imageValidate.getImage().getScaledInstance(15, 15, 0));
		
		ImageIcon imageSave = new ImageIcon(getClass().getResource("/Imagens/Save.png"));
		imageSave.setImage(imageSave.getImage().getScaledInstance(18, 18, 0));
			
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 374);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(77,20,52));
		panel.setBounds(1, 1, 412, 199);
		contentPane.add(panel);
		panel.setLayout(null);
		
		painelLogo = new JLabel();
		painelLogo.setIcon(imageLogo);
		painelLogo.setBackground(new Color(77,20,52));
		painelLogo.setBounds(89, 32, 232, 134);
		panel.add(painelLogo);
				
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 413, 374);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtSenha = new JPasswordField();
		txtSenha.setEditable(false);
		txtSenha.setBounds(148, 261, 149, 22);
		panel_1.add(txtSenha);
		
		JButton btnValidate = new JButton("");
		btnValidate.setIcon(imageValidate);
		btnValidate.setBounds(308, 261, 20, 18);
		panel_1.add(btnValidate);
		
		JLabel lblSenha = new JLabel("Nova Senha");
		lblSenha.setBounds(74, 264, 74, 14);
		panel_1.add(lblSenha);
		
		JTextPane txtpnTesteDeTexto = new JTextPane();
		txtpnTesteDeTexto.setFont(new Font("Arial", Font.PLAIN, 12));
		txtpnTesteDeTexto.setBounds(40, 214, 157, 38);
		panel_1.add(txtpnTesteDeTexto);
		txtpnTesteDeTexto.setForeground(Color.GRAY);
		txtpnTesteDeTexto.setText("     Por favor, escolha uma nova senha para o usu\u00E1rio");
		
		JLabel lblUser = new JLabel("Kamille.16");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(204, 223, 93, 16);
		panel_1.add(lblUser);
		
		JLabel lblRepitaSenha = new JLabel("Repita Senha");
		lblRepitaSenha.setBounds(65, 298, 83, 14);
		panel_1.add(lblRepitaSenha);
		
		txtRepet = new JPasswordField();
		txtRepet.setEditable(false);
		txtRepet.setBounds(148, 295, 149, 22);
		panel_1.add(txtRepet);
		
	}
}
