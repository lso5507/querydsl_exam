package com.example.querydsl_exam.member.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.example.querydsl_exam.member.dto.MemberDto;
import com.example.querydsl_exam.member.entity.Member;
import com.example.querydsl_exam.member.entity.QMember;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryCustom {
	private final JPAQueryFactory queryFactory; // 물론 이를 위해서는 빈으로 등록을 해줘야 한다.
	public List<Member> searchByBuilder(MemberDto memberDto){
		QMember member=QMember.member;
		BooleanBuilder builder= new BooleanBuilder();
		if(StringUtils.hasText(memberDto.getName())){
			builder.and(member.name.contains(memberDto.getName()));
		}
		return queryFactory.select(member)
			.from(member)
			.where(builder)
			.fetch();
	}

}
