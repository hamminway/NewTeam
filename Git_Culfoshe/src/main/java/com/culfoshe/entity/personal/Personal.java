package com.culfoshe.entity.personal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Getter@Setter@ToString
@Table(name = "personal")
public class Personal {

    @Id
    @Column(name = "personal_code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;



}
