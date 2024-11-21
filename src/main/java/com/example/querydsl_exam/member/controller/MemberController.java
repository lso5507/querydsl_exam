package com.example.querydsl_exam.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.querydsl_exam.member.dto.MemberDto;
import com.example.querydsl_exam.member.entity.Member;
import com.example.querydsl_exam.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
	private final MemberService memberService;
	@PostMapping("")
	public ResponseEntity<?>save(@RequestBody MemberDto memberDto){
		memberService.save(memberDto);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> select(@PathVariable("id")Member member){
		return ResponseEntity.ok(member);
	}
}
