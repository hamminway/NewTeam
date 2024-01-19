package com.culfoshe.entity;


import com.culfoshe.constant.HeaderCategory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "IndividualPost")
@Getter @Setter
public class IndividualPost extends BaseEntity{

    @Id
    @Column(name = "post_code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long PostCode;

    @Enumerated(EnumType.STRING)
    private HeaderCategory postCategory;

    private String MenuCategory;

    private String postTitle;

    private String postReview;

    private int postViewCount;

    private int postSaveCount;

    @ManyToOne
    @JoinColumn(name = "store_location")
    @JoinColumn(name = "partnermem_id")
    private PartnerMem partnerMem;

    private String location;

    @ManyToOne
    @JoinColumn(name = "individualmem_id")
    private IndividualMem individualMem;


}
