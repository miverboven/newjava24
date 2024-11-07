package fact.it.exampleprojectdtoserviceexec.model;

import fact.it.exampleprojectdtoserviceexec.util.ValidationException;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 12)
    private String barcode;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private Double purchaseCost;

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

    public void setPrice(double price) {
        if (price < 0) {
            throw new ValidationException("Price cannot be negative");
        }
        this.price = price;
    }


    public Double getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(final Double purchaseCost) {
        if (purchaseCost < 0) {
            throw new ValidationException("Purchase cost cannot be negative");
        }
        this.purchaseCost = purchaseCost;
    }

}