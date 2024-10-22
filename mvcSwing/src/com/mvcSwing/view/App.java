package com.mvcSwing.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.mvcSwing.dao.AlunoDAO;
import com.mvcSwing.model.Aluno;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.awt.event.InputEvent;
import javax.swing.JRadioButtonMenuItem;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtRgm;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtMunicipio;
	private JTextField txtNota;
	private JTextField txtFaltas;
	private JTextField txtCampus;
	private JTextField txtCurso;
	private JTextField txtDisciplina;
	private JTextField txtCelular;
	private JTextField txtCpf;
	private JTextField txtData;
	
	private JRadioButton rdbtnMatutino;
	private JRadioButton rdbtnVespertino;
	private JRadioButton rdbtnNoturno;
	private JTextField txtBoletimRgm;
	
	private JComboBox<String> comboBoxUf;
	private JComboBox<String> comboBoxSemestre;
	
	private JRadioButton radioMatutino;
    private JRadioButton radioVespertino;
    private JRadioButton radioNoturno;
    private ButtonGroup buttonGroup;


	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public App() throws ParseException {
		ImageIcon icon = new ImageIcon("src/shroom.png");
		setIconImage(icon.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 548);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Aluno");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        salvarAluno();
		    }
		});

		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alterar");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        alterarAluno();
		    }
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exluir");
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String rgm = txtRgm.getText(); 

		        if (rgm.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Por favor, insira o RGM do aluno.", "Erro", JOptionPane.ERROR_MESSAGE);
		            return; 
		        }

		        AlunoDAO alunoDAO;
		        try {
		            alunoDAO = new AlunoDAO(); 
		            alunoDAO.deletarPorRgm(rgm); 
		        } catch (Exception ex) {
		            ex.printStackTrace(); 
		            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		
		
		JMenuItem mntmNewMenuItem_Consultar = new JMenuItem("Consultar");
		mnNewMenu.add(mntmNewMenuItem_Consultar);
		mntmNewMenuItem_Consultar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String rgm = txtRgm.getText();
		    	
		    	try {
		    		AlunoDAO alunoDAO = new AlunoDAO();
			    	Aluno alunoEncontrado = alunoDAO.consultarPorRgm(rgm);
			    	txtNome.setText(alunoEncontrado.getNome());
			    	txtData.setText(alunoEncontrado.getDataNascimento());
			    	txtCpf.setText(alunoEncontrado.getCpf());
			    	txtEmail.setText(alunoEncontrado.getEmail());
			    	txtEndereco.setText(alunoEncontrado.getEndereco());
			    	txtMunicipio.setText(alunoEncontrado.getMunicipio());
//			    	comboBoxUf.setText(alunoEncontrado.getUf());
			    	txtCelular.setText(alunoEncontrado.getCelular());
			    	txtCurso.setText(alunoEncontrado.getCurso());
			    	txtCampus.setText(alunoEncontrado.getCampus());
//			    	txtPeriodo.setText(alunoEncontrado.getPeriodo());
			    	txtDisciplina.setText(alunoEncontrado.getDisciplina());
//			    	txtSemestre.setText(alunoEncontrado.getSemestre());
			    	txtNota.setText(String.valueOf(alunoEncontrado.getNotas()));
			    	txtFaltas.setText(String.valueOf(alunoEncontrado.getFaltas()));
			    	
			    	
			    } catch (Exception ex) {
			        
			    }
		    	
		    	
		    }
		});
		
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Sair");
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_Sobre = new JMenuItem("Sobre");
		mnNewMenu_1.add(mntmNewMenuItem_Sobre);
		mntmNewMenuItem_Sobre.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	JOptionPane.showMessageDialog(null, "Criado por Gabriel Tavares Barsani");
		    }
		});
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.exit(1);
		    }
		});

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(32, 35, 518, 419);
		contentPane.add(tabbedPane);
		
		JPanel panel_DadosPessoais = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel_DadosPessoais, null);
		panel_DadosPessoais.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RGM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(20, 22, 50, 14);
		panel_DadosPessoais.add(lblNewLabel);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataDeNascimento.setBounds(20, 98, 158, 14);
		panel_DadosPessoais.add(lblDataDeNascimento);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(20, 57, 50, 14);
		panel_DadosPessoais.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpf.setBounds(20, 137, 37, 14);
		panel_DadosPessoais.add(lblCpf);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(20, 177, 110, 14);
		panel_DadosPessoais.add(lblEmail);
		
		JLabel lblEnd = new JLabel("End.");
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnd.setBounds(20, 217, 110, 14);
		panel_DadosPessoais.add(lblEnd);
		
		JLabel lblMunicpio = new JLabel("Município");
		lblMunicpio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMunicpio.setBounds(20, 252, 79, 26);
		panel_DadosPessoais.add(lblMunicpio);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUf.setBounds(374, 258, 22, 14);
		panel_DadosPessoais.add(lblUf);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelular.setBounds(20, 292, 58, 14);
		panel_DadosPessoais.add(lblCelular);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(80, 54, 245, 26);
		panel_DadosPessoais.add(txtNome);
		
		txtRgm = new JTextField();
		txtRgm.setColumns(10);
		txtRgm.setBounds(80, 19, 260, 26);
		panel_DadosPessoais.add(txtRgm);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(77, 174, 248, 26);
		panel_DadosPessoais.add(txtEmail);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(77, 214, 248, 26);
		panel_DadosPessoais.add(txtEndereco);
		
		txtMunicipio = new JTextField();
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(109, 252, 248, 26);
		panel_DadosPessoais.add(txtMunicipio);
		
//		JFormattedTextField txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
//		txtCpf.setBounds(80, 131, 245, 26);
//		panel_DadosPessoais.add(txtCpf);
//		
//		JFormattedTextField txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
//		txtData.setBounds(188, 91, 245, 27);
//		panel_DadosPessoais.add(txtData);
//		
//		JFormattedTextField txtCelular = new JFormattedTextField(new MaskFormatter("(##) ####-#####"));
//		txtCelular.setBounds(109, 289, 245, 26);
//		panel_DadosPessoais.add(txtCelular);
//		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Limpar todos os campos de texto
		        txtRgm.setText("");
		        txtNome.setText("");
		        txtEmail.setText("");
		        txtEndereco.setText("");
		        txtMunicipio.setText("");

		        // Limpar campos formatados
		        txtData.setText("");
		        txtCpf.setText("");
		        txtCelular.setText("");

		        // Resetar o JComboBox para o primeiro item
		        comboBoxUf.setSelectedIndex(0);
		        
		        txtCurso.setText("");
		        txtCampus.setText("");
		        
		        buttonGroup.clearSelection();
		        
		        txtDisciplina.setText("");
		        
		        comboBoxSemestre.setSelectedIndex(0);
		        
		        txtNota.setText("");
		        txtFaltas.setText("");
			}
		});
		btnLimpar.setForeground(Color.BLACK);
		btnLimpar.setBounds(20, 340, 89, 23);
		panel_DadosPessoais.add(btnLimpar);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(109, 292, 248, 26);
		panel_DadosPessoais.add(txtCelular);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(77, 134, 248, 26);
		panel_DadosPessoais.add(txtCpf);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(188, 95, 248, 26);
		panel_DadosPessoais.add(txtData);
		
		JLabel lblObrigatrioParaEfetuar = new JLabel("Obrigatório para efetuar operações");
		lblObrigatrioParaEfetuar.setForeground(new Color(255, 0, 0));
		lblObrigatrioParaEfetuar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblObrigatrioParaEfetuar.setBounds(345, 9, 207, 46);
		panel_DadosPessoais.add(lblObrigatrioParaEfetuar);
		
		comboBoxUf = new JComboBox<>();
		comboBoxUf.setModel(new DefaultComboBoxModel<>(new String[] {
		    "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", 
		    "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", 
		    "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", 
		    "SP", "SE", "TO"
		}));
		comboBoxUf.setBounds(403, 252, 50, 27);
        panel_DadosPessoais.add(comboBoxUf);

		
		JPanel panel_Curso = new JPanel();
		tabbedPane.addTab("Curso", null, panel_Curso, null);
		panel_Curso.setLayout(null);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurso.setBounds(36, 28, 50, 14);
		panel_Curso.add(lblCurso);
		
		JLabel lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCampus.setBounds(36, 76, 74, 22);
		panel_Curso.add(lblCampus);
		
		JLabel lblPerodo = new JLabel("Período");
		lblPerodo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPerodo.setBounds(36, 138, 74, 22);
		panel_Curso.add(lblPerodo);
		
		
		txtCampus = new JTextField();
		txtCampus.setColumns(10);
		txtCampus.setBounds(133, 77, 260, 26);
		panel_Curso.add(txtCampus);
		
		txtCurso = new JTextField();
		txtCurso.setColumns(10);
		txtCurso.setBounds(132, 25, 260, 26);
		panel_Curso.add(txtCurso);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMatutino);
		group.add(rdbtnVespertino);
		group.add(rdbtnNoturno);
		
		
		JPanel panel_NotasEFaltas = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_NotasEFaltas, null);
		panel_NotasEFaltas.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Disciplina");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(21, 24, 83, 26);
		panel_NotasEFaltas.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Semestre");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(23, 61, 83, 26);
		panel_NotasEFaltas.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Nota");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3_2.setBounds(23, 98, 83, 26);
		panel_NotasEFaltas.add(lblNewLabel_1_3_2);
		
		txtNota = new JTextField();
		txtNota.setColumns(10);
		txtNota.setBounds(83, 98, 164, 26);
		panel_NotasEFaltas.add(txtNota);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Faltas");
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3_2_1.setBounds(23, 135, 83, 26);
		panel_NotasEFaltas.add(lblNewLabel_1_3_2_1);
		
		txtFaltas = new JTextField();
		txtFaltas.setColumns(10);
		txtFaltas.setBounds(83, 135, 164, 26);
		panel_NotasEFaltas.add(txtFaltas);
		
		txtDisciplina = new JTextField();
		txtDisciplina.setColumns(10);
		txtDisciplina.setBounds(106, 27, 376, 26);
		panel_NotasEFaltas.add(txtDisciplina);
		
		JLabel lblNewLabel_boletimDisciplina_2_1_1 = new JLabel("____________________________________________");
		lblNewLabel_boletimDisciplina_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_boletimDisciplina_2_1_1.setBounds(33, 172, 450, 26);
		panel_NotasEFaltas.add(lblNewLabel_boletimDisciplina_2_1_1);
		
		
		comboBoxSemestre = new JComboBox<>();
        comboBoxSemestre.setModel(new DefaultComboBoxModel<>(new String[] {
            "1º Semestre", "2º Semestre", "3º Semestre", "4º Semestre",
            "5º Semestre", "6º Semestre", "7º Semestre", "8º Semestre"
        }));
        comboBoxSemestre.setBounds(106, 61, 120, 27); 
        panel_NotasEFaltas.add(comboBoxSemestre);
        
     // Create radio buttons
        radioMatutino = new JRadioButton("Matutino");
        radioMatutino.setBounds(116, 138, 100, 30);
        panel_Curso.add(radioMatutino);
        
        radioVespertino = new JRadioButton("Vespertino");
        radioVespertino.setBounds(218, 137, 100, 30);
        panel_Curso.add(radioVespertino);
        
        radioNoturno = new JRadioButton("Noturno");
        radioNoturno.setBounds(320, 137, 100, 30);
        panel_Curso.add(radioNoturno);
        
        // Group the radio buttons
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioMatutino);
        buttonGroup.add(radioVespertino);
        buttonGroup.add(radioNoturno);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("RGM");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(26, 27, 50, 14);
		panel_3.add(lblNewLabel_1_4);
		
		txtBoletimRgm = new JTextField();
		txtBoletimRgm.setColumns(10);
		txtBoletimRgm.setBounds(86, 24, 164, 26);
		panel_3.add(txtBoletimRgm);
		
		JButton btnGerarBoletim = new JButton("Gerar Boletim");

		btnGerarBoletim.setBounds(271, 26, 124, 23);
		panel_3.add(btnGerarBoletim);
		
		JLabel lblNewLabel_boletimNome = new JLabel("n/a");
		lblNewLabel_boletimNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_boletimNome.setBounds(187, 72, 481, 26);
		panel_3.add(lblNewLabel_boletimNome);
		
		JLabel lblNewLabel_boletimCurso = new JLabel("n/a");
		lblNewLabel_boletimCurso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_boletimCurso.setBounds(187, 109, 481, 26);
		panel_3.add(lblNewLabel_boletimCurso);
		
		JLabel lblNewLabel_boletimDisciplina = new JLabel("n/a");
		lblNewLabel_boletimDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_boletimDisciplina.setBounds(187, 146, 481, 26);
		panel_3.add(lblNewLabel_boletimDisciplina);
		
		JLabel lblNewLabel_boletimDisciplina_1 = new JLabel("Nota:");
		lblNewLabel_boletimDisciplina_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_boletimDisciplina_1.setBounds(26, 267, 59, 26);
		panel_3.add(lblNewLabel_boletimDisciplina_1);
		
		JLabel lblNewLabel_boletimDisciplina_1_1 = new JLabel("Faltas:");
		lblNewLabel_boletimDisciplina_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_boletimDisciplina_1_1.setBounds(26, 304, 59, 26);
		panel_3.add(lblNewLabel_boletimDisciplina_1_1);
		
		JLabel lblNewLabel_boletimNota = new JLabel("n/a");
		lblNewLabel_boletimNota.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_boletimNota.setBounds(111, 267, 59, 26);
		panel_3.add(lblNewLabel_boletimNota);
		
		JLabel lblNewLabel_boletimFaltas = new JLabel("n/a");
		lblNewLabel_boletimFaltas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_boletimFaltas.setBounds(111, 304, 59, 26);
		panel_3.add(lblNewLabel_boletimFaltas);
		
		JLabel lblNewLabel_boletimNome_1 = new JLabel("[Nome do Aluno]");
		lblNewLabel_boletimNome_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_boletimNome_1.setBounds(26, 72, 140, 26);
		panel_3.add(lblNewLabel_boletimNome_1);
		
		JLabel lblNewLabel_boletimCurso_1 = new JLabel("[Curso]");
		lblNewLabel_boletimCurso_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_boletimCurso_1.setBounds(26, 109, 72, 26);
		panel_3.add(lblNewLabel_boletimCurso_1);
		
		JLabel lblNewLabel_boletimDisciplina_2 = new JLabel("[Disciplina]");
		lblNewLabel_boletimDisciplina_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_boletimDisciplina_2.setBounds(26, 146, 93, 26);
		panel_3.add(lblNewLabel_boletimDisciplina_2);
		
		JLabel lblNewLabel_boletimDisciplina_2_1 = new JLabel("____________________________________________");
		lblNewLabel_boletimDisciplina_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_boletimDisciplina_2_1.setBounds(36, 200, 450, 26);
		panel_3.add(lblNewLabel_boletimDisciplina_2_1);
		
		JButton btnFechar = new JButton("Sair");
		btnFechar.setBackground(new Color(255, 121, 121));
		btnFechar.setBounds(440, 11, 110, 23);
		contentPane.add(btnFechar);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setForeground(new Color(255, 255, 255));
		
		btnGerarBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rgm = txtBoletimRgm.getText();
		    	
		    	try {
		    		AlunoDAO alunoDAO = new AlunoDAO();
			    	Aluno alunoEncontrado = alunoDAO.consultarPorRgm(rgm);
			    	
			    	lblNewLabel_boletimNome.setText(alunoEncontrado.getNome());
			    	lblNewLabel_boletimCurso.setText(alunoEncontrado.getCurso());
			    	lblNewLabel_boletimDisciplina.setText(alunoEncontrado.getDisciplina());
			    	lblNewLabel_boletimNota.setText(String.valueOf(alunoEncontrado.getNotas()));
			    	lblNewLabel_boletimFaltas.setText(String.valueOf(alunoEncontrado.getFaltas()));
			    	
			    } catch (Exception ex) {
			        
			    }
				
			}
		});
		
		
	}
	
	
	private void salvarAluno() {
	    // Coletar dados dos campos
	    String rgm = txtRgm.getText();
	    String nome = txtNome.getText();
	    String email = txtEmail.getText();
	    String endereco = txtEndereco.getText();
	    String municipio = txtMunicipio.getText();
	    String cpf = txtCpf.getText(); 
	    String celular = txtCelular.getText(); 
	    String dataNascimento = txtData.getText();
		String uf = (String) comboBoxUf.getSelectedItem();
	    String curso = txtCurso.getText(); 
	    String campus = txtCampus.getText(); 
	    
	    String periodo = "";
	    if (radioMatutino.isSelected()) {
	    	periodo = "Matutino";
        } else if (radioVespertino.isSelected()) {
        	periodo = "Vespertino";
        } else if (radioNoturno.isSelected()) {
        	periodo = "Noturno";
        }
   
	    String disciplina = txtDisciplina.getText();
	    String semestre = (String) comboBoxSemestre.getSelectedItem();;
	    
	    double nota = 0;
	    int faltas = 0;
	    
	    try {
	        nota = Double.parseDouble(txtNota.getText()); 
	        faltas = Integer.parseInt(txtFaltas.getText()); 
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para nota e faltas.", "Erro", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Criar uma instância de Aluno
	    Aluno aluno = new Aluno();
	    aluno.setRgm(rgm);
	    aluno.setNome(nome);
	    aluno.setDataNascimento(dataNascimento);
	    aluno.setCpf(cpf);
	    aluno.setEmail(email);
	    aluno.setEndereco(endereco);
	    aluno.setMunicipio(municipio);
	    aluno.setUf(uf);
	    aluno.setCelular(celular);
	    aluno.setCurso(curso);
	    aluno.setCampus(campus);
	    aluno.setPeriodo(periodo);
	    aluno.setDisciplina(disciplina);
	    aluno.setSemestre(semestre);
	    aluno.setNotas(nota);
	    aluno.setFaltas(faltas);

	    // Salvar no banco de dados
	    AlunoDAO alunoDAO = null;
	    try {
	        alunoDAO = new AlunoDAO();
	        
	        
	     // Check if the RGM already exists
	        if (alunoDAO.verificarRgm(rgm)) {
	            // Exibir mensagem de erro ao usuário
	            JOptionPane.showMessageDialog(this, "RGM já cadastrado. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        
	        alunoDAO.salvar(aluno);
	        JOptionPane.showMessageDialog(this, "Aluno salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Erro ao salvar aluno: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void alterarAluno() {
	    // Collect data from fields
	    String rgm = txtRgm.getText(); 
	    String nome = txtNome.getText();
	    String email = txtEmail.getText();
	    String endereco = txtEndereco.getText();
	    String municipio = txtMunicipio.getText();
	    String cpf = txtCpf.getText();
	    String celular = txtCelular.getText();
	    String dataNascimento = txtData.getText();
	    String uf = (String) comboBoxUf.getSelectedItem();
	    String curso = txtCurso.getText();
	    String campus = txtCampus.getText();
	    
	    String periodo = "";
	    if (radioMatutino.isSelected()) {
	    	periodo = "Matutino";
        } else if (radioVespertino.isSelected()) {
        	periodo = "Vespertino";
        } else if (radioNoturno.isSelected()) {
        	periodo = "Noturno";
        }
	    
	    String disciplina = txtDisciplina.getText();
	    String semestre = (String) comboBoxSemestre.getSelectedItem();;
	    double nota = 0; 
	    int faltas = 0; 
	    
	    try {
	        nota = Double.parseDouble(txtNota.getText()); 
	        faltas = Integer.parseInt(txtFaltas.getText()); 
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para nota e faltas.", "Erro", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Create an Aluno instance
	    Aluno aluno = new Aluno();
	    aluno.setRgm(rgm);
	    aluno.setNome(nome);
	    aluno.setDataNascimento(dataNascimento);
	    aluno.setCpf(cpf);
	    aluno.setEmail(email);
	    aluno.setEndereco(endereco);
	    aluno.setMunicipio(municipio);
	    aluno.setUf(uf);
	    aluno.setCelular(celular);
	    aluno.setCurso(curso);
	    aluno.setCampus(campus);
	    aluno.setPeriodo(periodo);
	    aluno.setDisciplina(disciplina);
	    aluno.setSemestre(semestre);
	    aluno.setNotas(nota);
	    aluno.setFaltas(faltas);

	    // Update in the database
	    AlunoDAO alunoDAO = null;
	    try {
	        alunoDAO = new AlunoDAO();
	        alunoDAO.alterar(aluno); 
	        JOptionPane.showMessageDialog(this, "Aluno atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Erro ao atualizar aluno: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	    }
	}
}


