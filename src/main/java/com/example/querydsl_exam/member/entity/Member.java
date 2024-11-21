package com.example.querydsl_exam.member.entity;

import com.example.querydsl_exam.member.dto.MemberDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	public Member(){}

	public Member(MemberDto memberDto){
		this.name=memberDto.getName();
	}

	public Member(long l, String name) {
		this.id=id;
		this.name=name;
	}
}
