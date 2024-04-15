package br.com.relatoriopessoas2;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class RelatorioPessoas2 {

    public void iniciar() {
        // Cria uma lista para armazenar as pessoas coletadas
        List<Pessoa> pessoas = new ArrayList<>();

        // Coleta de dados
        boolean continuar = true;
        while (continuar) {
            // Solicita as informações ao usuário
            String nome = JOptionPane.showInputDialog("Digite o nome:");
            String cargo = JOptionPane.showInputDialog("Digite o cargo:");
            String habilidades = JOptionPane.showInputDialog("Digite as habilidades:");
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:"));
            String sexo = JOptionPane.showInputDialog("Digite o sexo:");
            String endereco = JOptionPane.showInputDialog("Digite o endereço:");
            String cidade = JOptionPane.showInputDialog("Digite a cidade:");
            String estado = JOptionPane.showInputDialog("Digite o estado:");

            // Cria um objeto Pessoa com os dados coletados
            Pessoa pessoa = new Pessoa(nome, cargo, habilidades, idade, sexo, endereco, cidade, estado);
            pessoas.add(pessoa);

            // Pergunta ao usuário se deseja continuar
            int continuarInput = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Continuar?", JOptionPane.YES_NO_OPTION);
            continuar = continuarInput == JOptionPane.YES_OPTION;
        }

        // Menu para escolha do tipo de relatório
        boolean sair = false;
        while (!sair) {
            String[] opcoes = {
                "Filtrar por Cidade",
                "Filtrar por Cargo",
                "Filtrar por Sexo",
                "Filtrar por Estado",
                "Sair"
            };

            // Mostra um menu para o usuário escolher o filtro desejado
            int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo de relatório a ser gerado:",
                "Menu de Relatórios",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            // Realiza a ação com base na escolha do usuário
            switch (escolha) {
                case 0: // Filtrar por Cidade
                    gerarRelatorioPorCidade(pessoas);
                    break;
                case 1: // Filtrar por Cargo
                    gerarRelatorioPorCargo(pessoas);
                    break;
                case 2: // Filtrar por Sexo
                    gerarRelatorioPorSexo(pessoas);
                    break;
                case 3: // Filtrar por Estado
                    gerarRelatorioPorEstado(pessoas);
                    break;
                case 4: // Sair
                    sair = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }

    // Métodos para gerar relatórios por cidade, cargo, sexo e estado
    public void gerarRelatorioPorCidade(List<Pessoa> pessoas) {
        String cidadeFiltrada = JOptionPane.showInputDialog("Digite a cidade para filtrar:");
        List<Pessoa> pessoasFiltradas = pessoas.stream()
                .filter(p -> p.cidade.equalsIgnoreCase(cidadeFiltrada))
                .collect(Collectors.toList());

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório por cidade:\n");
        relatorio.append("\nCidade filtrada: ").append(cidadeFiltrada).append("\n");
        for (Pessoa pessoa : pessoasFiltradas) {
            relatorio.append(pessoa.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, relatorio.toString());
    }

    public void gerarRelatorioPorCargo(List<Pessoa> pessoas) {
        String cargoFiltrado = JOptionPane.showInputDialog("Digite o cargo para filtrar:");
        List<Pessoa> pessoasFiltradas = pessoas.stream()
                .filter(p -> p.cargo.equalsIgnoreCase(cargoFiltrado))
                .collect(Collectors.toList());

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório por cargo:\n");
        relatorio.append("\nCargo filtrado: ").append(cargoFiltrado).append("\n");
        for (Pessoa pessoa : pessoasFiltradas) {
            relatorio.append(pessoa.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, relatorio.toString());
    }

    public void gerarRelatorioPorSexo(List<Pessoa> pessoas) {
        String sexoFiltrado = JOptionPane.showInputDialog("Digite o sexo para filtrar:");
        List<Pessoa> pessoasFiltradas = pessoas.stream()
                .filter(p -> p.sexo.equalsIgnoreCase(sexoFiltrado))
                .collect(Collectors.toList());

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório por sexo:\n");
        relatorio.append("\nSexo filtrado: ").append(sexoFiltrado).append("\n");
        for (Pessoa pessoa : pessoasFiltradas) {
            relatorio.append(pessoa.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, relatorio.toString());
    }

    public void gerarRelatorioPorEstado(List<Pessoa> pessoas) {
        String estadoFiltrado = JOptionPane.showInputDialog("Digite o estado para filtrar:");
        List<Pessoa> pessoasFiltradas = pessoas.stream()
                .filter(p -> p.estado.equalsIgnoreCase(estadoFiltrado))
                .collect(Collectors.toList());

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório por estado:\n");
        relatorio.append("\nEstado filtrado: ").append(estadoFiltrado).append("\n");
        for (Pessoa pessoa : pessoasFiltradas) {
            relatorio.append(pessoa.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, relatorio.toString());
    }
}
