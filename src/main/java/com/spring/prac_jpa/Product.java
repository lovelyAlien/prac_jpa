package com.spring.prac_jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<MemberProduct> members = new ArrayList<>();

    public void add(MemberProduct memberProduct){
        this.members.add(memberProduct);
    }

}
