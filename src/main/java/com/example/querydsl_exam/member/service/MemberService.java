package com.example.querydsl_exam.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.querydsl_exam.member.dto.MemberDto;
import com.example.querydsl_exam.member.entity.Member;
import com.example.querydsl_exam.member.repository.MemberRepository;
import com.example.querydsl_exam.member.repository.MemberRepositoryCustom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	private final MemberRepositoryCustom memberRepositoryCustom;
	public void save(MemberDto member){
		memberRepository.save(new Member(member));

	}
	public Member findById(Long id){
		return memberRepository.findById(id).get();
	}
	public List<Member>findAllByName(MemberDto memberDto){
		return memberRepositoryCustom.searchByBuilder(memberDto);
	}


}
