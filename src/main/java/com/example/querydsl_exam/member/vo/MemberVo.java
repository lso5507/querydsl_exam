package com.example.querydsl_exam.member.vo;

import lombok.Builder;

public record MemberVo(
	String name
) {
	@Builder
	public MemberVo {
	}
}
