package br.com.relatoriopessoas2;

class Pessoa {
    String nome;
    String cargo;
    String habilidades;
    int idade;
    String sexo;
    String endereco;
    String cidade;
    String estado;

    public Pessoa(String nome, String cargo, String habilidades, int idade, String sexo, String endereco, String cidade, String estado) {
        this.nome = nome;
        this.cargo = cargo;
        this.habilidades = habilidades;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
               "\nCargo: " + cargo +
               "\nHabilidades: " + habilidades +
               "\nIdade: " + idade +
               "\nSexo: " + sexo +
               "\nEndereço: " + endereco +
               "\nCidade: " + cidade +
               "\nEstado: " + estado + "\n";
    }
}