package com.culfoshe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Embeddable
@Setter @Getter
public class PartnerMemPK implements Serializable {

    @Column(name = "partnermem_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long partnermem_id;

    @Column(name = "store_location")
    private String store_location;

    private void setLocation(String location){
        this.store_location = location;
    }
}
