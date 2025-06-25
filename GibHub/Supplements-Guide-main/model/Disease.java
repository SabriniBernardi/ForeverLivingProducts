package model;

import java.util.List;
import java.util.UUID;

public class Disease {
    private UUID diseaseId;
    private String diseaseName;
    private List<Supplement> diseaseSupplements;

    // Construtor para novo Disease (gera novo UUID)
    public Disease(String diseaseName, List<Supplement> diseaseSupplements) {
        this.diseaseId = UUID.randomUUID();
        this.diseaseName = diseaseName;
        this.diseaseSupplements = diseaseSupplements;
    }

    // Construtor para uso quando já se tem o UUID (ex: vindo do banco)
    public Disease(UUID diseaseId, String diseaseName, List<Supplement> diseaseSupplements) {
        this.diseaseId = diseaseId;
        this.diseaseName = diseaseName;
        this.diseaseSupplements = diseaseSupplements;
    }

    public UUID getDiseaseId() {
        return diseaseId;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public List<Supplement> getDiseaseSupplements() {
        return diseaseSupplements;
    }

    @Override
    public String toString() {
        return diseaseName + " - Tratamentos: " + diseaseSupplements;
    }
}