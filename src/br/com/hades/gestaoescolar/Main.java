package br.com.hades.gestaoescolar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criando a Lista (O "Diário de Classe")
        List<Aluno> turma = new ArrayList<>();

        System.out.println("--- SISTEMA DE GESTÃO ESCOLAR 2.0 (FINAL) ---");
        System.out.println("Quantos alunos deseja cadastrar agora?");
        int quantidade = sc.nextInt();
        sc.nextLine(); // Limpeza de buffer obrigatória após ler número

        // LOOP DE CADASTRO
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nCadastrando aluno #" + (i + 1));

            // 1. Coleta de dados TEMPORÁRIA (Variáveis soltas)
            // Primeiro perguntamos tudo, depois criamos o objeto.

            System.out.print("Nome: ");
            String nomeTemp = sc.nextLine();

            System.out.print("Nota 1: ");
            double n1Temp = sc.nextDouble();

            System.out.print("Nota 2: ");
            double n2Temp = sc.nextDouble();
            sc.nextLine(); // Limpeza de buffer (O "Enter" fantasma)

            // 2. O NASCIMENTO (Construtor)
            // Aqui a mágica acontece: O aluno nasce JÁ com os dados e validados.
            // Se passar nota errada aqui, o Setter lá dentro vai transformar em 0.
            Aluno a = new Aluno(nomeTemp, n1Temp, n2Temp);

            // 3. PERSISTÊNCIA
            turma.add(a);

            // Note que usamos o GET para ler o nome, pois é privado!
            System.out.println("-> " + a.getNome() + " salvo com sucesso!");
        }

        // RELATÓRIO FINAL
        System.out.println("\n---------------------------------");
        System.out.println("       RELATÓRIO DA TURMA        ");
        System.out.println("---------------------------------");

        for (Aluno alunoDaVez : turma) {
            // Usamos printf para formatar. %.1f significa "1 casa decimal"
            // E usamos os GETTERS para acessar as informações blindadas
            System.out.printf("Aluno: %-15s | Média: %.1f\n",
                    alunoDaVez.getNome(),
                    alunoDaVez.calcularMedia());
        }

        System.out.println("---------------------------------");
        System.out.println("Total de registros: " + turma.size());

        sc.close();
    }
}





