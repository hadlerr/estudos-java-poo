package br.com.hades.gestaoescolar;

public class Aluno {

    // --- ATRIBUTOS PRIVADOS ---
    // 'private' significa: SÓ a classe Aluno pode mexer aqui diretamente.
    private String nome;
    private double nota1;
    private double nota2;

    // --- CONSTRUTOR ---
    // Este metodo especial tem o MESMO NOME da classe e NÃO tem retorno (nem void).
    // Ele obriga quem for criar o aluno a passar os dados na hora.
    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        // DICA DE OURO: Usamos os Setters aqui dentro para aproveitar a validação!
        // Se a gente fizesse "this.nota1 = nota1", pularia a segurança do < 0 > 10.
        setNota1(nota1);
        setNota2(nota2);
    }

    // --- MÉTODOS DE ACESSO ---

    // GET: Serve para "ler" o valor
    public String getNome() {
        return nome;
    }

    // SET: Serve para "gravar" o valor
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    // O sistema só aceita a nota SE ela for válida.
    public void setNota1(double notaRecebida) {
        if (notaRecebida < 0 || notaRecebida > 10) {
            System.out.println("ERRO: Nota inválida! Foi atribuído nota 0.");
            this.nota1 = 0;
        } else {
            this.nota1 = notaRecebida;
        }
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double notaRecebida) {
        if (notaRecebida < 0 || notaRecebida > 10) {
            System.out.println("ERRO: Nota inválida! Foi atribuído nota 0.");
            this.nota2 = 0;
        } else {
            this.nota2 = notaRecebida;
        }
    }

    // COMPORTAMENTO calcularMedia
    public double calcularMedia() {
        return (nota1 + nota2) / 2.0;
    }
}




