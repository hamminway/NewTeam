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
    private String store_location; // 사업장 주소

    public PartnerMemPK(){
        partnermem_id = MemberService.makePartnerMemberId();
    }

/*
    아직 사용하지 않음(사용할 때 설명듣기: 안 쓸 수도 있음)
    private void setLocation(String location){
        this.store_location = location;
    }

 */

}
