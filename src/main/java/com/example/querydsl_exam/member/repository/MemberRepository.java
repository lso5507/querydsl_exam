package com.example.querydsl_exam.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.querydsl_exam.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long>{
}
