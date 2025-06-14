package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfDisciplinaCod;
	private JTextField tfDisciplinNome;
	private JTextField tfDisciplinaDiaSemana;
	private JTextField tfDisciplinaHorarioInicial;
	private JTextField tfDisciplinaQtHoras;
	private JTextField tfDisciplinaCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setTitle("Sistema acadêmico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 0, 616, 443);
		contentPane.add(tabbedPane);
		
		JPanel tabDisciplina = new JPanel();
		tabbedPane.addTab("Disciplina", null, tabDisciplina, "Cadastro de disciplina");
		tabDisciplina.setLayout(null);
		
		JLabel lblDisciplinaCod = new JLabel("Código da disciplina");
		lblDisciplinaCod.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblDisciplinaCod.setBounds(12, 10, 150, 33);
		tabDisciplina.add(lblDisciplinaCod);
		
		JLabel lblDisciplinaNome = new JLabel("Nome da disciplina");
		lblDisciplinaNome.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblDisciplinaNome.setBounds(12, 40, 150, 33);
		tabDisciplina.add(lblDisciplinaNome);
		
		JLabel lblDisciplinaDiaSemana = new JLabel("Dia da semana");
		lblDisciplinaDiaSemana.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblDisciplinaDiaSemana.setBounds(12, 70, 150, 33);
		tabDisciplina.add(lblDisciplinaDiaSemana);
		
		JLabel lblDisciplinaHorarioInicio = new JLabel("Horário de inicio");
		lblDisciplinaHorarioInicio.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblDisciplinaHorarioInicio.setBounds(12, 100, 150, 33);
		tabDisciplina.add(lblDisciplinaHorarioInicio);
		
		JLabel lblDisciplinaQtHoras = new JLabel("Quantidade de horas");
		lblDisciplinaQtHoras.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblDisciplinaQtHoras.setBounds(12, 130, 150, 33);
		tabDisciplina.add(lblDisciplinaQtHoras);
		
		JLabel lblDisciplinaCurso = new JLabel("Curso");
		lblDisciplinaCurso.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblDisciplinaCurso.setBounds(12, 160, 150, 33);
		tabDisciplina.add(lblDisciplinaCurso);
		
		tfDisciplinaCod = new JTextField();
		tfDisciplinaCod.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		tfDisciplinaCod.setBounds(186, 16, 120, 20);//x,y, width, height
		tabDisciplina.add(tfDisciplinaCod);
		tfDisciplinaCod.setColumns(10);
		
		tfDisciplinNome = new JTextField();
		tfDisciplinaCod.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		tfDisciplinNome.setBounds(186, 47, 120, 20);
		tabDisciplina.add(tfDisciplinNome);
		tfDisciplinNome.setColumns(10);
		
		tfDisciplinaDiaSemana = new JTextField();
		tfDisciplinaCod.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		tfDisciplinaDiaSemana.setBounds(186, 77, 120, 20);
		tabDisciplina.add(tfDisciplinaDiaSemana);
		tfDisciplinaDiaSemana.setColumns(10);
		
		tfDisciplinaHorarioInicial = new JTextField();
		tfDisciplinaCod.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		tfDisciplinaHorarioInicial.setBounds(186, 107, 120, 20);
		tabDisciplina.add(tfDisciplinaHorarioInicial);
		tfDisciplinaHorarioInicial.setColumns(10);
		
		tfDisciplinaQtHoras = new JTextField();
		tfDisciplinaCod.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		tfDisciplinaQtHoras.setBounds(186, 137, 120, 20);
		tabDisciplina.add(tfDisciplinaQtHoras);
		tfDisciplinaQtHoras.setColumns(10);
		
		tfDisciplinaCurso = new JTextField();
		tfDisciplinaCod.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		tfDisciplinaCurso.setBounds(186, 167, 120, 20);
		tabDisciplina.add(tfDisciplinaCurso);
		tfDisciplinaCurso.setColumns(10);
		
		JButton btnDisciplinaCadastrar = new JButton("Cadastrar");
		btnDisciplinaCadastrar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnDisciplinaCadastrar.setBounds(424, 14, 117, 25);
		tabDisciplina.add(btnDisciplinaCadastrar);
		
		JButton btnDisciplinaBuscar = new JButton("Buscar");
		btnDisciplinaCadastrar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnDisciplinaBuscar.setBounds(424, 61, 117, 25);
		tabDisciplina.add(btnDisciplinaBuscar);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Professor", null, panel, null);
		
		
	}
}
