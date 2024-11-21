package com.example.querydsl_exam.member.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.querydsl_exam.member.dto.MemberDto;
import com.example.querydsl_exam.member.entity.Member;

@SpringBootTest
class MemberServiceTest {
	@Autowired
	private MemberService memberService;
	@BeforeEach
	public void before(){
		MemberDto leeseokwoon = MemberDto.builder().name("leeseokwoon").build();
		MemberDto hanjangho = MemberDto.builder().name("hanjangho").build();
		MemberDto leesooman = MemberDto.builder().name("leesooman").build();
		memberService.save(leeseokwoon);
		memberService.save(hanjangho);
		memberService.save(leesooman);
	}
	@Test
	void findAllByName() {
		//given
		MemberDto memberDto = new MemberDto("lee");
		//when
		List<Member> resultList = memberService.findAllByName(memberDto);
		//then
		Assertions.assertEquals(2,resultList.size());

	}
}