package imc;

import java.util.Calendar;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;
    private Data dataNascimento;

    public Pessoa(String nome, String sobrenome, Data dataNascimento, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public double getImc() {
        return imc;
    }

    public int calculaIdade() {

        Calendar hoje = Calendar.getInstance();

        int anoAtual = hoje.get(Calendar.YEAR);
        int mesAtual = hoje.get(Calendar.MONTH) + 1;
        int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);

        idade = anoAtual - dataNascimento.getAno();

        if (mesAtual < dataNascimento.getMes() ||
           (mesAtual == dataNascimento.getMes() && diaAtual < dataNascimento.getDia())) {
            idade--;
        }

        return idade;
    }

    public void calcularIMC() {
        imc = peso / (altura * altura);
    }

    public String informaObesidade() {

        if (imc < 18.5) return "Abaixo do peso";
        if (imc < 25) return "Peso normal";
        if (imc < 30) return "Sobrepeso";
        if (imc < 35) return "Obesidade grau 1";
        if (imc < 40) return "Obesidade grau 2";
        return "Obesidade grau 3";
    }
}s