package model;

import java.util.UUID;

public class Client {

    private UUID clientId;
    private String clientName, clientDateOfBirth, clientGender, clientCPF, clientRG;
    private String clientPhone, clientEmail;
    private String clientHouseNumber, clientCEP, clientStreet, clientComplement, clientNeighborhood, clientCity, clientState;
    private Disease clientDisease;
    private Record clientRecord;

    // Construtor para criação de novo cliente (gera UUID novo)
    public Client(String clientName, String clientDateOfBirth, String clientGender, String clientCPF, String clientRG,
                  String clientPhone, String clientEmail, String clientCEP, String clientStreet, String clientHouseNumber,
                  String clientComplement, String clientNeighborhood, String clientCity, String clientState,
                  Disease clientDisease, Record clientRecord){
        this.clientId = UUID.randomUUID();
        this.clientName = clientName;
        this.clientDateOfBirth = clientDateOfBirth;
        this.clientGender = clientGender;
        this.clientCPF = clientCPF;
        this.clientRG = clientRG;
        this.clientPhone = clientPhone;
        this.clientEmail = clientEmail;
        this.clientCEP = clientCEP;
        this.clientStreet = clientStreet;
        this.clientHouseNumber = clientHouseNumber;
        this.clientComplement = clientComplement;
        this.clientNeighborhood = clientNeighborhood;
        this.clientCity = clientCity;
        this.clientState = clientState;
        this.clientDisease = clientDisease;
        this.clientRecord = clientRecord;
    }

    // Construtor para reconstrução de cliente a partir do banco (com UUID já existente)
    public Client(UUID clientId, String clientName, String clientDateOfBirth, String clientGender, String clientCPF, String clientRG,
                  String clientPhone, String clientEmail, String clientCEP, String clientStreet, String clientHouseNumber,
                  String clientComplement, String clientNeighborhood, String clientCity, String clientState,
                  Disease clientDisease, Record clientRecord){
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientDateOfBirth = clientDateOfBirth;
        this.clientGender = clientGender;
        this.clientCPF = clientCPF;
        this.clientRG = clientRG;
        this.clientPhone = clientPhone;
        this.clientEmail = clientEmail;
        this.clientCEP = clientCEP;
        this.clientStreet = clientStreet;
        this.clientHouseNumber = clientHouseNumber;
        this.clientComplement = clientComplement;
        this.clientNeighborhood = clientNeighborhood;
        this.clientCity = clientCity;
        this.clientState = clientState;
        this.clientDisease = clientDisease;
        this.clientRecord = clientRecord;
    }

    // Getters
    public UUID getClientId() { return clientId; }
    public String getClientName() { return clientName; }
    public String getClientDateOfBirth() { return clientDateOfBirth; }
    public String getClientGender() { return clientGender; }
    public String getClientCPF() { return clientCPF; }
    public String getClientRG() { return clientRG; }
    public String getClientPhone() { return clientPhone; }
    public String getClientEmail() { return clientEmail; }
    public String getClientHouseNumber() { return clientHouseNumber; }
    public String getClientCEP() { return clientCEP; }
    public String getClientStreet() { return clientStreet; }
    public String getClientComplement() { return clientComplement; }
    public String getClientNeighborhood() { return clientNeighborhood; }
    public String getClientCity() { return clientCity; }
    public String getClientState() { return clientState; }
    public Disease getClientDisease() { return clientDisease; }
    public Record getClientRecord() { return clientRecord; }

    @Override
    public String toString() {
        return "DADOS DO CLIENTE: \n" +
                "Nome: " + clientName + "\n" +
                "Data de Nascimento: " + clientDateOfBirth + "\n" +
                "Gênero: " + clientGender + "\n" +
                "CPF: " + clientCPF + "\n" +
                "RG: " + clientRG + "\n\n" +
                "CONTATO: \n" +
                "Telefone: " + clientPhone + "\n" +
                "E-mail: " + clientEmail + "\n\n" +
                "ENDEREÇO: \n" +
                "CEP: " + clientCEP + "\n" +
                "Rua: " + clientStreet + "\n" +
                "Número: " + clientHouseNumber + "\n" +
                "Complemento: " + clientComplement + "\n" +
                "Bairro: " + clientNeighborhood + "\n" +
                "Cidade: " + clientCity + "\n" +
                "Estado: " + clientState + "\n\n" +
                "INFORMAÇÕES MÉDICAS: \n" +
                "Doença: " + (clientDisease) + "\n" +
                "Histórico: " + (clientRecord != null ? clientRecord.toString() : "Nenhum");
    }
}