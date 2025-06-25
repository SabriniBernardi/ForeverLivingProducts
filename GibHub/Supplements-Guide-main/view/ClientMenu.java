package view;

import model.Client;
import model.Disease;
import model.Record;
import model.Seller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClientMenu {

    private Scanner scan;
    private List<Disease> diseases;
    private List<Client> clients;

    public ClientMenu(Scanner scan, List<Disease> diseases, List<Client> clients) {
        this.scan = scan;
        this.diseases = diseases;
        this.clients = clients;
    }

    public void menuSystem(Seller seller) {
        int replySeller = -1;
        do {
            System.out.println("\n-----   SUPPLEMENTS GUIDE   -----\n");
            System.out.println("Bem-vindo, " + seller.getSellerName() + "\n");
            System.out.println("1 - Consultar tratamentos.");
            System.out.println("2 - Cadastrar cliente.");
            System.out.println("3 - Acessar histórico de clientes.");
            System.out.println("4 - Sair.");
            System.out.print("Opção: ");
            while (!scan.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                scan.next();
            }
            replySeller = scan.nextInt();
            scan.nextLine();

            switch (replySeller) {
                case 1:
                    consultarTratamentos();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    historicoClientes();
                    break;
                case 4:
                    System.out.println("Sessão encerrada!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (replySeller != 4);
    }

    private void consultarTratamentos() {
        System.out.println("\n===== DOENÇAS E TRATAMENTOS =====");
        for (int i = 0; i < diseases.size(); i++) {
            Disease d = diseases.get(i);
            System.out.print((i + 1) + ". " + d.getDiseaseName() + "\n   Suplementos: ");
            List<String> nomes = d.getDiseaseSupplements().stream().map(s -> s.getSupplementName()).toList();
            System.out.println(String.join(", ", nomes));
        }
    }

    private void cadastrarCliente() {
        System.out.println("\n===== CADASTRAR NOVO CLIENTE =====");
        try {
            System.out.print("Nome: ");
            String nome = scan.nextLine();

            System.out.print("Data de nascimento (AAAA-MM-DD): ");
            String dataNascimento = scan.nextLine();

            System.out.print("Gênero: ");
            String genero = scan.nextLine();

            System.out.print("CPF: ");
            String cpf = scan.nextLine();

            System.out.print("RG: ");
            String rg = scan.nextLine();

            System.out.print("Telefone: ");
            String telefone = scan.nextLine();

            System.out.print("E-mail: ");
            String email = scan.nextLine();

            System.out.print("CEP: ");
            String cep = scan.nextLine();

            System.out.print("Rua: ");
            String rua = scan.nextLine();

            System.out.print("Número: ");
            String numero = scan.nextLine();

            System.out.print("Complemento: ");
            String complemento = scan.nextLine();

            System.out.print("Bairro: ");
            String bairro = scan.nextLine();

            System.out.print("Cidade: ");
            String cidade = scan.nextLine();

            System.out.print("Estado: ");
            String estado = scan.nextLine();

            System.out.println("Selecione a doença do cliente:");
            for (int i = 0; i < diseases.size(); i++) {
                System.out.println((i + 1) + " - " + diseases.get(i).getDiseaseName());
            }
            int opcaoDoenca = -1;
            while (opcaoDoenca < 1 || opcaoDoenca > diseases.size()) {
                System.out.print("Opção: ");
                while (!scan.hasNextInt()) {
                    System.out.println("Digite um número válido!");
                    scan.next();
                }
                opcaoDoenca = scan.nextInt();
                scan.nextLine();
            }
            Disease doencaSelecionada = diseases.get(opcaoDoenca - 1);

            System.out.print("Descrição para o histórico do cliente: ");
            String descricaoRecord = scan.nextLine();
            Record record = new Record(descricaoRecord);

            Client novoCliente = new Client(
                    nome, dataNascimento, genero, cpf, rg,
                    telefone, email, cep, rua, numero, complemento, bairro, cidade, estado,
                    doencaSelecionada, record
            );
            clients.add(novoCliente);
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Erro nos dados digitados. Operação cancelada.");
            scan.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void historicoClientes() {
        System.out.println("\n===== HISTÓRICO DE CLIENTES CADASTRADOS =====");
        if (clients.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Client c : clients) {
                System.out.println(c);
                System.out.println("-----------------------------------------");
            }
        }
    }
}