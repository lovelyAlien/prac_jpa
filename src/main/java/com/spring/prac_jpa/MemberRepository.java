package com.spring.prac_jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface MemberRepository extends JpaRepository<Member, Long> {
}
