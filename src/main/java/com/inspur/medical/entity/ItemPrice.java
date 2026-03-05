package com.inspur.medical.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item_price")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPrice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long id;
    
    @Column(name = "serial_no", length = 50)
    @JsonProperty("SerialNo")
    private String serialNo;
    
    @Column(name = "item_desc", length = 200)
    @JsonProperty("ItemDesc")
    private String itemDesc;
    
    @Column(name = "item_code", length = 50)
    @JsonProperty("ItemCode")
    private String itemCode;
    
    @Column(name = "prices_no", length = 50)
    @JsonProperty("PricesNo")
    private String pricesNo;
    
    @Column(name = "uom", length = 20)
    @JsonProperty("Uom")
    private String uom;
    
    @Column(name = "price", length = 20)
    @JsonProperty("Price")
    private String price;
    
    @Column(name = "special_price", length = 20)
    @JsonProperty("SpecialPrice")
    private String specialPrice;
    
    @Column(name = "factory", length = 100)
    @JsonProperty("Factory")
    private String factory;
    
    @Column(name = "content_desc", length = 200)
    @JsonProperty("ContentDesc")
    private String contentDesc;
    
    @Column(name = "charge_standard", length = 100)
    @JsonProperty("ChargeStandard")
    private String chargeStandard;
    
    @Column(name = "insure_sign", length = 10)
    @JsonProperty("InsureSign")
    private String insureSign;
    
    @Column(name = "registration_no", length = 50)
    @JsonProperty("RegistrationNo")
    private String registrationNo;
    
    @Column(name = "reg_exp_date", length = 20)
    @JsonProperty("RegExpDate")
    private String regExpDate;
}
