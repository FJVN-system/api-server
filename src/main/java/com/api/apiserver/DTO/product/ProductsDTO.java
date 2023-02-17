package com.api.apiserver.DTO.product;

import com.api.apiserver.domain.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
public class ProductsDTO {

    private Long id;
    private String companyName;
    private String artist;
    private String category;
    private String  ent;
    private String thumbNailUrl;
    private Long price;
    private Long weight;
    private String title;

    private Long purchasePrice;

    private Long stock;

    private LocalDateTime releaseDate;

    private LocalDateTime preorderDeadline;

    private Boolean stockLimited;

    private Boolean restockable;

    private String sku;

    private String barcode;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ProductsDTO(Product product) {
        this.id = product.getId();
        this.companyName = product.getCompany().getCompanyName();
        this.artist = product.getArtist().getName();
        this.category = product.getCategory().getName();
        this.ent = product.getEnt().getName();
        this.thumbNailUrl = product.getThumbNailUrl();
        this.price = product.getPrice();
        this.weight = product.getWeight();
        this.title = product.getTitle();
        this.purchasePrice = product.getPurchasePrice();
        this.stock = product.getStock();
        this.releaseDate = product.getReleaseDate();
        this.preorderDeadline = product.getPreorderDeadline();
        this.stockLimited = product.getStockLimited();
        this.restockable = product.getRestockable();
        this.sku = product.getSku();
        this.barcode = product.getBarcode();
        this.description = product.getDescription();
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
    }
}
