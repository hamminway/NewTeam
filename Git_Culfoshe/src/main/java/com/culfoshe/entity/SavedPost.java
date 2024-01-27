package com.culfoshe.entity;


import javax.persistence.*;

@Entity
@Table(name = "")
public class SavedPost {

    @Id
    @Column(name = "save_code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long savedCode;

    private String individualFolder;

    @ManyToOne
    @JoinColumn(name = "post_code")
    private IndividualPost individualPost;

    @ManyToOne
    @JoinColumn(name = "individualmem_id")
    private IndividualMem individualMem;

}
