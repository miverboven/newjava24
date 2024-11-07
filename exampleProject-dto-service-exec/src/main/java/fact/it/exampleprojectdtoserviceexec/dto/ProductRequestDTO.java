package fact.it.exampleprojectdtoserviceexec.dto;

public class ProductRequestDTO {

    private String barcode;
    private String name;
    private Double price;
    private Double purchaseCost;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(final String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public Double getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(final Double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

}