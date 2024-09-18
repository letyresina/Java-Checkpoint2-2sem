package br.com.fiap.view;

import br.com.fiap.controller.FilmeController;

import javax.swing.*;

public class FilmeView {
    public static void main(String[] args) {
        String aux, titulo, genero, produtora;
        int codigo;
        String[] escolha = {"Inserir","Alterar","Excluir", "Listar Todos"};
        int opcao;
        FilmeController filmeController = new FilmeController();

        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um filme:", "ESCOLHA", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[0]);
                switch (opcao) {
                    case 0:
                        titulo = JOptionPane.showInputDialog(null, "Digite o título do filme: ");
                        genero = JOptionPane.showInputDialog(null, "Digite o gênero do filme: ");
                        produtora = JOptionPane.showInputDialog(null, "Digite a produtora do filme: ");
                        System.out.println(filmeController.inserirFilme(titulo, genero, produtora));
                        break;
                    case 1:
                        aux = JOptionPane.showInputDialog(null, "Digite o código do filme que deseja alterar: ");
                        codigo = Integer.parseInt(aux);
                        titulo = JOptionPane.showInputDialog(null, "Digite o NOVO título do filme: ");
                        genero = JOptionPane.showInputDialog(null, "Digite o NOVO gênero do filme: ");
                        produtora = JOptionPane.showInputDialog(null, "Digite a NOVA produtora do filme: ");
                        System.out.println(filmeController.alterarFilme(codigo, titulo, genero, produtora));
                        break;
                    case 2:
                        aux = JOptionPane.showInputDialog(null, "Digite o código do filme que deseja excluir: ");
                        codigo = Integer.parseInt(aux);
                        System.out.println(filmeController.excluirFilme(codigo));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, filmeController.listarTodosFilmes());
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                }
            } catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de programa!");
    }

}
