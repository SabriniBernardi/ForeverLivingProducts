import model.*;
import view.ClientMenu;
import view.SellerMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ApplicationMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Suplementos
        Supplement aloeVeraGel = new Supplement("Aloe Vera Gel");
        Supplement aloeFreedom = new Supplement("Aloe Freedom");
        Supplement articSeaOmega3 = new Supplement("Artic Sea Omega 3");
        Supplement garlicThyme = new Supplement("Garlic Thyme (Alho & Tomilho)");
        Supplement absorbentC = new Supplement("Absorbent C");
        Supplement ginkgoPlus = new Supplement("Ginkgo Plus Tablets");
        Supplement geleiaReal = new Supplement("Geleia Real Tablets");
        Supplement aBetaCare = new Supplement("A-beta Care");
        Supplement argi = new Supplement("Argi");
        Supplement cardioHealth = new Supplement("Cardio Health");
        Supplement immublend = new Supplement("Immublend");
        Supplement fieldsOfGreens = new Supplement("Fields of Greens");
        Supplement foreverDaily = new Supplement("Forever Daily");
        Supplement aloeBerryNectar = new Supplement("Aloe Berry Néctar");
        Supplement vitolizeMan = new Supplement("Vitolize Man");
        Supplement vitolizeWoman = new Supplement("Vitolize Woman");
        Supplement polen = new Supplement("Pólen");
        Supplement natureMin = new Supplement("Nature Min");
        Supplement activeProbiotic = new Supplement("Active Probiotic");
        Supplement royalJelly = new Supplement("Royal Jelly");
        Supplement b12Plus = new Supplement("B12 Plus");
        Supplement lyciumPlus = new Supplement("Lycium Plus");
        Supplement propolisComp = new Supplement("Própolis Comp.");
        Supplement aloeBitsNPeaches = new Supplement("Aloe Bits N'peaches");
        Supplement kids = new Supplement("Kids");

        // Doenças e tratamentos
        Disease avc = new Disease("Acidente Vascular Cerebral (AVC)", Arrays.asList(
                aloeVeraGel, aloeFreedom, articSeaOmega3, garlicThyme, absorbentC
        ));
        Disease alzheimer = new Disease("Alzheimer", Arrays.asList(
                ginkgoPlus, geleiaReal, garlicThyme, aBetaCare, absorbentC
        ));
        Disease infarto = new Disease("Infarto", Arrays.asList(
                argi, cardioHealth, immublend, garlicThyme, articSeaOmega3, absorbentC
        ));
        Disease hipertensao = new Disease("Hipertensão", Arrays.asList(
                aloeVeraGel, argi, articSeaOmega3, garlicThyme, fieldsOfGreens, aBetaCare
        ));
        Disease parkinson = new Disease("Mal de Parkinson", Arrays.asList(
                aloeFreedom, articSeaOmega3, foreverDaily, absorbentC, garlicThyme, argi
        ));
        Disease prostata = new Disease("Problemas na Próstata", Arrays.asList(
                aloeBerryNectar, vitolizeMan, polen, natureMin
        ));
        Disease cancer = new Disease("Câncer", Arrays.asList(
                aloeVeraGel, argi, articSeaOmega3, absorbentC, natureMin, fieldsOfGreens, activeProbiotic, royalJelly
        ));
        Disease infertilidadeFem = new Disease("Infertilidade Feminina", Arrays.asList(
                aloeBerryNectar, vitolizeWoman, garlicThyme, royalJelly
        ));
        Disease infertilidadeMasc = new Disease("Infertilidade Masculina", Arrays.asList(
                aloeBerryNectar, vitolizeMan, b12Plus, royalJelly
        ));
        Disease pedraRins = new Disease("Pedra nos Rins", Arrays.asList(
                aloeBerryNectar, lyciumPlus, propolisComp, polen
        ));
        Disease tdah = new Disease("TDAH", Arrays.asList(
                aloeBitsNPeaches, articSeaOmega3, kids, royalJelly
        ));

        List<Disease> diseases = new ArrayList<>(Arrays.asList(
                avc, alzheimer, infarto, hipertensao, parkinson, prostata, cancer,
                infertilidadeFem, infertilidadeMasc, pedraRins, tdah
        ));

        // Vendedores
        List<Seller> sellers = new ArrayList<>();
        sellers.add(new Seller("Sabrini", "sabrini.FL", "Forever1234"));
        sellers.add(new Seller("Matheus", "matheus.FL", "Forever1234"));

        // Lista de clientes
        List<Client> clients = new ArrayList<>();

        // Login e menus
        SellerMenu sellerMenu = new SellerMenu();
        Seller loggedSeller = sellerMenu.loginMenu(scanner, sellers);

        ClientMenu clientMenu = new ClientMenu(scanner, diseases, clients);
        clientMenu.menuSystem(loggedSeller);

        System.out.println("Obrigado por usar o Supplements Guide!");
        scanner.close();
    }
}