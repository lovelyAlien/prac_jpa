package com.spring.prac_jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<MemberProduct> products = new ArrayList<>();

    public void add(MemberProduct memberProduct){
        this.products.add(memberProduct);
    }
}

