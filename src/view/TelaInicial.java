package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CursoController;
import controller.DisciplinaController;
import controller.InscricaoController;
import controller.ProfessorController;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfDisciplinaCod;
	private JTextField tfDisciplinNome;
	private JTextField tfDisciplinaDiaSemana;
	private JTextField tfDisciplinaHorarioInicial;
	private JTextField tfDisciplinaQtHoras;
	private JTextField tfDisciplinaCurso;
	private JTextField tfCursoCod;
	private JTextField tfCursoNome;
	private JTextField tfCursoArea;
	private JTextField tfInscricaoCpfProfessor;
	private JTextField tfInscricaoCodDisciplina;
	private JTextField tfInscricaoCodProcesso;
	private JTextField tfProfessorCpf;
	private JTextField tfProfessorNome;
	private JTextField tfProfessorArea;
	private JTextField tfProfessorPontos;

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
		
		JLabel lblDisciplinaCod = new JLabel("Código da disciplina:");
		lblDisciplinaCod.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblDisciplinaCod.setBounds(12, 10, 150, 33);
		tabDisciplina.add(lblDisciplinaCod);
		
		JLabel lblDisciplinaNome = new JLabel("Nome da disciplina:");
		lblDisciplinaNome.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblDisciplinaNome.setBounds(12, 40, 150, 33);
		tabDisciplina.add(lblDisciplinaNome);
		
		JLabel lblDisciplinaDiaSemana = new JLabel("Dia da semana:");
		lblDisciplinaDiaSemana.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblDisciplinaDiaSemana.setBounds(12, 70, 150, 33);
		tabDisciplina.add(lblDisciplinaDiaSemana);
		
		JLabel lblDisciplinaHorarioInicio = new JLabel("Horário de inicio:");
		lblDisciplinaHorarioInicio.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblDisciplinaHorarioInicio.setBounds(12, 100, 150, 33);
		tabDisciplina.add(lblDisciplinaHorarioInicio);
		
		JLabel lblDisciplinaQtHoras = new JLabel("Quantidade de horas:");
		lblDisciplinaQtHoras.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblDisciplinaQtHoras.setBounds(12, 130, 150, 33);
		tabDisciplina.add(lblDisciplinaQtHoras);
		
		JLabel lblDisciplinaCurso = new JLabel("Curso:");
		lblDisciplinaCurso.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblDisciplinaCurso.setBounds(12, 160, 150, 33);
		tabDisciplina.add(lblDisciplinaCurso);
		
		tfDisciplinaCod = new JTextField();
		tfDisciplinaCod.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		tfDisciplinaCod.setBounds(186, 16, 120, 20);//x,y, width, height
		tabDisciplina.add(tfDisciplinaCod);
		tfDisciplinaCod.setColumns(10);
		
		tfDisciplinNome = new JTextField();
		tfDisciplinNome.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		tfDisciplinNome.setBounds(186, 47, 120, 20);
		tabDisciplina.add(tfDisciplinNome);
		tfDisciplinNome.setColumns(10);
		
		tfDisciplinaDiaSemana = new JTextField();
		tfDisciplinaDiaSemana.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		tfDisciplinaDiaSemana.setBounds(186, 77, 120, 20);
		tabDisciplina.add(tfDisciplinaDiaSemana);
		tfDisciplinaDiaSemana.setColumns(10);
		
		tfDisciplinaHorarioInicial = new JTextField();
		tfDisciplinaHorarioInicial.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		tfDisciplinaHorarioInicial.setBounds(186, 107, 120, 20);
		tabDisciplina.add(tfDisciplinaHorarioInicial);
		tfDisciplinaHorarioInicial.setColumns(10);
		
		tfDisciplinaQtHoras = new JTextField();
		tfDisciplinaQtHoras.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		tfDisciplinaQtHoras.setBounds(186, 137, 120, 20);
		tabDisciplina.add(tfDisciplinaQtHoras);
		tfDisciplinaQtHoras.setColumns(10);
		
		tfDisciplinaCurso = new JTextField();
		tfDisciplinaCurso.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		tfDisciplinaCurso.setBounds(186, 167, 120, 20);
		tabDisciplina.add(tfDisciplinaCurso);
		tfDisciplinaCurso.setColumns(10);
		
		JButton btnDisciplinaCadastrar = new JButton("Cadastrar");
		btnDisciplinaCadastrar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnDisciplinaCadastrar.setBounds(458, 15, 117, 25);
		tabDisciplina.add(btnDisciplinaCadastrar);
		
		JButton btnDisciplinaBuscar = new JButton("Buscar");
		btnDisciplinaBuscar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnDisciplinaBuscar.setBounds(458, 45, 117, 25);
		tabDisciplina.add(btnDisciplinaBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 205, 577, 199);
		tabDisciplina.add(scrollPane);
		
		JTextArea taDisciplina = new JTextArea();
		scrollPane.setViewportView(taDisciplina);
		taDisciplina.setFont(new Font("Adwaita Sans", Font.PLAIN, 14));
		
		JPanel tabProfessor = new JPanel();
		tabbedPane.addTab("Professor", null, tabProfessor, "Cadastro de professor");
		tabProfessor.setLayout(null);
		
		JLabel lblProfessorCpf = new JLabel("CPF: ");
		lblProfessorCpf.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblProfessorCpf.setBounds(12, 15, 70, 15);
		tabProfessor.add(lblProfessorCpf);
		
		JLabel lblProfessorNome = new JLabel("Nome: ");
		lblProfessorNome.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblProfessorNome.setBounds(12, 45, 70, 15);
		tabProfessor.add(lblProfessorNome);
		
		JLabel lblProfessorArea = new JLabel("Area: ");
		lblProfessorArea.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblProfessorArea.setBounds(12, 75, 70, 15);
		tabProfessor.add(lblProfessorArea);
		
		JLabel lblProfessorPontos = new JLabel("Pontos: ");
		lblProfessorPontos.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblProfessorPontos.setBounds(12, 105, 70, 15);
		tabProfessor.add(lblProfessorPontos);
		
		tfProfessorCpf = new JTextField();
		tfProfessorCpf.setBounds(234, 15, 150, 25);
		tabProfessor.add(tfProfessorCpf);
		tfProfessorCpf.setColumns(10);
		
		tfProfessorNome = new JTextField();
		tfProfessorNome.setBounds(234, 45, 150, 25);
		tabProfessor.add(tfProfessorNome);
		tfProfessorNome.setColumns(10);
		
		tfProfessorArea = new JTextField();
		tfProfessorArea.setBounds(234, 75, 150, 25);
		tabProfessor.add(tfProfessorArea);
		tfProfessorArea.setColumns(10);
		
		tfProfessorPontos = new JTextField();
		tfProfessorPontos.setBounds(234, 105, 150, 25);
		tabProfessor.add(tfProfessorPontos);
		tfProfessorPontos.setColumns(10);
		
		JButton btnProfessorCadastrar = new JButton("Cadastrar");
		btnProfessorCadastrar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnProfessorCadastrar.setBounds(458, 15, 117, 25);
		tabProfessor.add(btnProfessorCadastrar);
		
		JButton btnProfessorAtualizar = new JButton("Atualizar");
		btnProfessorAtualizar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnProfessorAtualizar.setBounds(458, 45, 117, 25);
		tabProfessor.add(btnProfessorAtualizar);
		
		JButton btnProfessorBuscar = new JButton("Buscar");
		btnProfessorBuscar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnProfessorBuscar.setBounds(458, 75, 117, 25);
		tabProfessor.add(btnProfessorBuscar);
		
		JButton btnProfessorRemover = new JButton("Remover");
		btnProfessorRemover.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnProfessorRemover.setBounds(458, 105, 117, 25);
		tabProfessor.add(btnProfessorRemover);
		
		JButton btnDisciplinaRemover = new JButton("Remover");
		btnDisciplinaRemover.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnDisciplinaRemover.setBounds(458, 105, 117, 25);
		tabDisciplina.add(btnDisciplinaRemover);
		
		JPanel tabCurso = new JPanel();
		tabbedPane.addTab("Curso", null, tabCurso, "Cadastro de curso");
		tabCurso.setLayout(null);
		
		JLabel lblCursoCod = new JLabel("Código do curso:");
		lblCursoCod.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblCursoCod.setBounds(12, 15, 200, 25);
		tabCurso.add(lblCursoCod);
		
		JLabel lblCursoNome = new JLabel("Nome: ");
		lblCursoNome.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblCursoNome.setBounds(12, 45, 200, 25);
		tabCurso.add(lblCursoNome);
		
		JLabel lblCursoArea = new JLabel("Area: ");
		lblCursoArea.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblCursoArea.setBounds(12, 75, 200, 25);
		tabCurso.add(lblCursoArea);
		
		tfCursoCod = new JTextField();
		tfCursoCod.setBounds(234, 15, 150, 25);
		tabCurso.add(tfCursoCod);
		tfCursoCod.setColumns(10);
		
		tfCursoNome = new JTextField();
		tfCursoNome.setBounds(234, 45, 150, 25);
		tabCurso.add(tfCursoNome);
		tfCursoNome.setColumns(10);
		
		tfCursoArea = new JTextField();
		tfCursoArea.setBounds(234, 75, 150, 25);
		tabCurso.add(tfCursoArea);
		tfCursoArea.setColumns(10);
		
		JButton btnCursoCadastrar = new JButton("Cadastrar");
		btnCursoCadastrar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnCursoCadastrar.setBounds(458, 15, 117, 25);
		tabCurso.add(btnCursoCadastrar);
		
		JButton btnCursoAtualizar = new JButton("Atualizar");
		btnCursoAtualizar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnCursoAtualizar.setBounds(458, 45, 117, 25);
		tabCurso.add(btnCursoAtualizar);
		
		JButton btnCursoRemover = new JButton("Remover");
		btnCursoRemover.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnCursoRemover.setBounds(458, 75, 117, 25);
		tabCurso.add(btnCursoRemover);
		
		JButton btnCursoPesquisar = new JButton("Buscar");
		btnCursoPesquisar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnCursoPesquisar.setBounds(458, 105, 117, 25);
		tabCurso.add(btnCursoPesquisar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 141, 587, 263);
		tabCurso.add(scrollPane_1);
		
		JTextArea taCurso = new JTextArea();
		scrollPane_1.setViewportView(taCurso);
		
		JPanel tabInscricao = new JPanel();
		tabbedPane.addTab("Inscrição", null, tabInscricao, "Cadastrar inscrição");
		tabInscricao.setLayout(null);
		
		JLabel lblCpfDoProfessor = new JLabel("CPF do professor: ");
		lblCpfDoProfessor.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblCpfDoProfessor.setBounds(12, 15, 200, 25);
		tabInscricao.add(lblCpfDoProfessor);
		
		JLabel lblCdigoDaDisciplina = new JLabel("Código da disciplina:");
		lblCdigoDaDisciplina.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblCdigoDaDisciplina.setBounds(12, 45, 200, 25);
		tabInscricao.add(lblCdigoDaDisciplina);
		
		JLabel lblCdigoDeProcesso = new JLabel("Código de processo:");
		lblCdigoDeProcesso.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		lblCdigoDeProcesso.setBounds(12, 75, 200, 25);
		tabInscricao.add(lblCdigoDeProcesso);
		
		tfInscricaoCpfProfessor = new JTextField();
		tfInscricaoCpfProfessor.setBounds(234, 15, 150, 25);
		tabInscricao.add(tfInscricaoCpfProfessor);
		tfInscricaoCpfProfessor.setColumns(10);
		
		tfInscricaoCodDisciplina = new JTextField();
		tfInscricaoCodDisciplina.setBounds(234, 45, 150, 25);
		tabInscricao.add(tfInscricaoCodDisciplina);
		tfInscricaoCodDisciplina.setColumns(10);
		
		tfInscricaoCodProcesso = new JTextField();
		tfInscricaoCodProcesso.setBounds(234, 75, 150, 25);
		tabInscricao.add(tfInscricaoCodProcesso);
		tfInscricaoCodProcesso.setColumns(10);
		
		JButton btnInscricaoCadastrar = new JButton("Cadastrar");
		btnInscricaoCadastrar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnInscricaoCadastrar.setBounds(458, 15, 117, 25);
		tabInscricao.add(btnInscricaoCadastrar);
		
		JButton btnInscricaoAtualizar = new JButton("Atualizar");
		btnInscricaoAtualizar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnInscricaoAtualizar.setBounds(458, 45, 117, 25);
		tabInscricao.add(btnInscricaoAtualizar);
		
		JButton btnInscricaoBuscar = new JButton("Buscar");
		btnInscricaoBuscar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnInscricaoBuscar.setBounds(458, 75, 117, 25);
		tabInscricao.add(btnInscricaoBuscar);
		
		JButton btnInscricaoRemover = new JButton("Remover");
		btnInscricaoRemover.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnInscricaoRemover.setBounds(458, 105, 117, 25);
		tabInscricao.add(btnInscricaoRemover);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 152, 587, 252);
		tabProfessor.add(scrollPane_2);
		
		JTextArea taProfessor = new JTextArea();
		scrollPane_2.setViewportView(taProfessor);
		
		
		
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 148, 587, 256);
		tabInscricao.add(scrollPane_3);
		
		JTextArea taInscricao = new JTextArea();
		scrollPane_3.setViewportView(taInscricao);
		
		
		CursoController cursoController = new CursoController(tfCursoCod, tfCursoNome, tfCursoArea, taCurso);
		DisciplinaController disciplinaController = new DisciplinaController(
			tfDisciplinaCod, 
			tfDisciplinNome, 
			tfDisciplinaDiaSemana, 
			tfDisciplinaHorarioInicial, 
			tfDisciplinaQtHoras, 
			tfDisciplinaCurso, 
			taDisciplina
		);
		
		JButton btnDisciplinaAtualizar = new JButton("Atualizar");
		btnDisciplinaAtualizar.setFont(new Font("Adwaita Sans", Font.BOLD, 14));
		btnDisciplinaAtualizar.setBounds(458, 75, 117, 25);
		tabDisciplina.add(btnDisciplinaAtualizar);
		ProfessorController professorController = new ProfessorController(
			tfProfessorCpf, 
			tfProfessorNome, 
			tfProfessorArea, 
			tfProfessorPontos
		);
		InscricaoController inscricaoController = new InscricaoController(
			tfInscricaoCpfProfessor, 
			tfInscricaoCodDisciplina, 
			tfInscricaoCodProcesso, 
			taInscricao
		);
		
		btnDisciplinaCadastrar.addActionListener(disciplinaController);
		btnDisciplinaBuscar.addActionListener(disciplinaController);
		btnDisciplinaRemover.addActionListener(disciplinaController);
		btnDisciplinaAtualizar.addActionListener(disciplinaController);
		
		btnInscricaoCadastrar.addActionListener(inscricaoController);
		btnInscricaoBuscar.addActionListener(inscricaoController);
		btnInscricaoRemover.addActionListener(inscricaoController);
		btnInscricaoAtualizar.addActionListener(inscricaoController);
		
		btnCursoCadastrar.addActionListener(cursoController);
		btnCursoPesquisar.addActionListener(cursoController);
		btnCursoRemover.addActionListener(cursoController);
		btnCursoAtualizar.addActionListener(cursoController);
		
		btnProfessorCadastrar.addActionListener(professorController);
		btnProfessorBuscar.addActionListener(professorController);
		btnProfessorAtualizar.addActionListener(professorController);
		btnProfessorRemover.addActionListener(professorController);
		
	}
}
