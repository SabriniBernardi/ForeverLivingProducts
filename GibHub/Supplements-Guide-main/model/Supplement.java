package model;

import java.util.UUID;

public class Supplement {
    private UUID supplementId;
    private String supplementName;

    // Construtor para novo suplemento (gera novo UUID)
    public Supplement(String supplementName) {
        this.supplementId = UUID.randomUUID();
        this.supplementName = supplementName;
    }

    // Construtor para uso quando já se tem o UUID (ex: vindo do banco)
    public Supplement(UUID supplementId, String supplementName) {
        this.supplementId = supplementId;
        this.supplementName = supplementName;
    }

    public UUID getSupplementId() {
        return supplementId;
    }

    public String getSupplementName() {
        return supplementName;
    }

    @Override
    public String toString() {
        return supplementName;
    }
}