package com.wasanabag.serverAPI.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "extrenlItem")
public class ExtrenlItem extends Item{
    private Suppler importer;
    private String importDate;
    private String importTime;
    private String importStatus;
    private String importQuantity;
    private String importPrice;
    private String importTotal;
    private String importPayment;
    private String importDue;
    private String importPaymentStatus;
    private String importPaymentDate;
    private String importPaymentTime;
    private String importPaymentMethod;
    private String importPaymentReference;
    private String importPaymentNote;
    private String importPaymentImage;


}
