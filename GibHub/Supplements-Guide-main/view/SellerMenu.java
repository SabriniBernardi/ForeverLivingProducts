package view;

import model.Seller;

import java.util.List;
import java.util.Scanner;

public class SellerMenu {

    public Seller loginMenu(Scanner scan, List<Seller> sellers) {
        Seller loggedSeller = null;

        System.out.println("\n-----   SUPPLEMENTS GUIDE   -----\n");

        // Verifica se a lista foi passada corretamente
        if (sellers == null || sellers.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado no sistema.");
            return null;
        }

        while (loggedSeller == null) {
            System.out.print("Informe seu login: ");
            String sellerLoginIn = scan.nextLine().trim();

            System.out.print("Informe sua senha para acesso: ");
            String sellerPasswordIn = scan.nextLine().trim();

            // Uso do stream para buscar o vendedor (pode manter o for se preferir)
            loggedSeller = sellers.stream()
                    .filter(s -> s.getSellerLogin().equals(sellerLoginIn) && s.getSellerPassword().equals(sellerPasswordIn))
                    .findFirst()
                    .orElse(null);

            if (loggedSeller == null) {
                System.out.println("Login ou senha incorretos. Tente novamente.\n");
            } else {
                System.out.println("\nLogin realizado com sucesso! Bem-vindo(a), " + loggedSeller.getSellerName() + "!");
            }
        }
        return loggedSeller;
    }
}