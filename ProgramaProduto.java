package aplicacao;

import entidade.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramaProduto {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        List<Produto> lista = new ArrayList<>();

        System.out.println("######## Cadastro de Produtos #######");

        System.out.println();
        System.out.print("Quantos produtos serão cadastrados? ");
        int quantidade = sc.nextInt();

        for(int i = 0; i < quantidade; i++){
            System.out.println();
            System.out.println("Produto " + (i + 1));

            System.out.print("Código: ");
            int codigo = sc.nextInt();

            while (existeCodigo(lista, codigo)){
                System.out.print("Código já existente! Digite novamente: ");
                codigo = sc.nextInt();
            }

            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Preço: R$ ");
            double preco = sc.nextDouble();

            lista.add(new Produto(codigo, nome, preco));
        }

        System.out.println();
        System.out.print("Digite o código do produto que terá aumento de preço: ");
        int codigo = sc.nextInt();

        Produto prod = lista.stream()
                .filter(x -> x.getCodigo() == codigo)
                .findFirst()
                .orElse(null);

        if (prod == null) {
            System.out.println("Este código não existe!");
        }
        else {
            System.out.print("Informe a porcentagem de aumento: ");
            double porcentagem = sc.nextDouble();
            prod.aumentarPreco(porcentagem);
        }

        System.out.println("--------------------------------------");
        System.out.println("Lista de Produtos:");
        for(Produto obj : lista){
            System.out.println(obj);
        }

        sc.close();
    }

    public static boolean existeCodigo(List<Produto> lista, int codigo){
        Produto prod = lista.stream()
                .filter(x -> x.getCodigo() == codigo)
                .findFirst()
                .orElse(null);

        return prod != null;
    }
}