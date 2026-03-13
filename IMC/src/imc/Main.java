package imc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pessoa[] pessoas = new Pessoa[10];

        int total = 0;

        while (total < 10) {

            String nome = sc.next();
            String sobrenome = sc.next();

            if (total > 0) {

                Pessoa anterior = pessoas[total - 1];

                if (nome.equals(anterior.getNome()) && sobrenome.equals(anterior.getSobrenome())) {
                    break;
                }
            }

            int dia = sc.nextInt();
            int mes = sc.nextInt();
            int ano = sc.nextInt();

            double peso = sc.nextDouble();
            double altura = sc.nextDouble();

            Data d = new Data(dia, mes, ano);

            Pessoa p = new Pessoa(nome, sobrenome, d, altura, peso);

            p.calcularIMC();

            pessoas[total] = p;

            total++;
        }

        for (int i = 0; i < total; i++) {

            Pessoa p = pessoas[i];

            String nomeCompleto = p.getNome() + " " + p.getSobrenome();

            String nomeRef = p.getSobrenome() + ", " + p.getNome().toUpperCase();

            System.out.println("Cadastro " + (i + 1) + ":");
            System.out.println("Nome completo: " + nomeCompleto);
            System.out.println("Nome de referencia: " + nomeRef);
            System.out.println("Idade: " + p.calculaIdade());
            System.out.println("Peso: " + p.getPeso());
            System.out.println("Altura: " + p.getAltura());
            System.out.println("IMC: " + p.getImc());
            System.out.println("Classificacao: " + p.informaObesidade());
            System.out.println();
        }

    }
}