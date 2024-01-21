package com.culfoshe.entity;

import com.culfoshe.join.service.MemberService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter @Getter @ToString
public class PartnerMemPK implements Serializable {

    @Column(name = "partnermem_id")
    private Long partnermem_id;

    @Column(name = "store_location")
    private String store_location;

    public PartnerMemPK(){
        partnermem_id = MemberService.makePartnerMemberId();
    }

    private void setLocation(String location){
        this.store_location = location;
    }
}
