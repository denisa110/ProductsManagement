package entities;

public class Product {
    private String id;
    private String productName;
    private Double unitPrice;

    public Product() {
    }

    public Product(String idProduct, String productName, Double unitPrice) {
        this.id = idProduct;
        this.productName = productName;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
