package fact.it.exampleprojectdtoserviceexec.dto;

public class ProductResponseDTO {

    private Long id;
    private String barcode;
    private String name;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

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

}
