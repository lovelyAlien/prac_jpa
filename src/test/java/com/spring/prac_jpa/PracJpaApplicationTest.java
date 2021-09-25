package com.spring.prac_jpa;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
class PracJpaApplicationTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MemberProductRepository memberProductRepository;

    @Test
    public void contextLoads(){

//        Member member=new Member();
//        memberRepository.save(member);

        Member member = memberRepository.findById(3L).orElse(null);
        Product product=new Product();
        productRepository.save(product);
        MemberProduct memberProduct=new MemberProduct(member, product);
        memberProductRepository.save(memberProduct);

        if(member!=null)
            member.add(memberProduct);

        product.add(memberProduct);

        for(MemberProduct m: member.getProducts()){
            System.out.println("member.id= "+ m.getId());
        }

        for(MemberProduct p: product.getMembers()){
            System.out.println("product.id= "+ p.getId());
        }


//        product.add(memberProduct);




    }
}