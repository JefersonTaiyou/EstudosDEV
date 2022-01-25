package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Panel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Dao.FuncionariosDao;
import Model.Funcionarios;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JPanel panel;
	private JLabel painelLogo;

	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	Object[] options = { "Sim", "Não" };

	Funcionarios func = new Funcionarios();
	FuncionariosDao fDao = new FuncionariosDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {

		ImageIcon imageLogo = new ImageIcon(getClass().getResource("/Imagens/LogoRoxa.png"));
		imageLogo.setImage(imageLogo.getImage().getScaledInstance(232, 134, 0));

		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 346);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(77, 20, 52));
		panel.setBounds(1, 1, 412, 199);
		contentPane.add(panel);
		panel.setLayout(null);

		painelLogo = new JLabel();
		painelLogo.setIcon(imageLogo);
		painelLogo.setBackground(new Color(77, 20, 52));
		painelLogo.setBounds(89, 32, 232, 134);
		panel.add(painelLogo);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 413, 346);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnLogin = new JButton("Login");

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sPadrao = "Vazio";

				try {
					func.setLogin(txtLogin.getText());
					func.setSenha(String.valueOf(txtSenha.getPassword()));
					if (fDao.CheckLogin(func)) {
						if (func.getSenha() == sPadrao) {

							setVisible(false);
							NovaSenha home = new NovaSenha();
							home.frmSenha.setVisible(true);
						} else {
							/**
							 * 0 - Erro 1 - Informação 2 - Atenção 3 - Questionamento
							 */
							setVisible(false);
							HomePage home = new HomePage();
							home.frmHomePage.setVisible(true);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Dados Inválidos ", "Erro", 0);
						txtLogin.requestFocus();
					}
				} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(142, 286, 65, 23);
		panel_1.add(btnLogin);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Deseja Finalizar o Sistema", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
					System.exit(0);
				}
			}
		});
		btnSair.setBounds(226, 286, 65, 23);
		panel_1.add(btnSair);

		txtLogin = new JTextField();
		txtLogin.setBounds(142, 225, 149, 22);
		panel_1.add(txtLogin);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(142, 256, 149, 22);
		panel_1.add(txtSenha);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(96, 228, 46, 14);
		panel_1.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(96, 259, 46, 14);
		panel_1.add(lblSenha);
	}
}
