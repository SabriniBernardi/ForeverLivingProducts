package model;

import java.util.UUID;

public class Seller {
    private UUID sellerId;
    private String sellerName;
    private String sellerLogin;
    private String sellerPassword;

    // Construtor para novo Seller (gera novo UUID)
    public Seller(String sellerName, String sellerLogin, String sellerPassword){
        this.sellerId = UUID.randomUUID();
        this.sellerName = sellerName;
        this.sellerLogin = sellerLogin;
        this.sellerPassword = sellerPassword;
    }

    // Construtor para uso quando já se tem o UUID (ex: vindo do banco)
    public Seller(UUID sellerId, String sellerName, String sellerLogin, String sellerPassword){
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerLogin = sellerLogin;
        this.sellerPassword = sellerPassword;
    }

    public UUID getSellerId() {
        return sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerLogin() {
        return sellerLogin;
    }

    public String getSellerPassword() {
        return sellerPassword;
    }
}