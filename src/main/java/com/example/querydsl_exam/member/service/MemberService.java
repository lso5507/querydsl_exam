package com.example.querydsl_exam.member.service;

import org.springframework.stereotype.Service;

import com.example.querydsl_exam.member.dto.MemberDto;
import com.example.querydsl_exam.member.entity.Member;
import com.example.querydsl_exam.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	public void save(MemberDto member){
		memberRepository.save(new Member(member));

	}
	public Member findById(Long id){
		return memberRepository.findById(id).get();
	}


}
