package com.example.querydsl_exam.member.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.querydsl_exam.member.dto.MemberDto;
import com.example.querydsl_exam.member.entity.Member;
import com.example.querydsl_exam.member.repository.MemberRepository;
import com.example.querydsl_exam.member.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MemberController.class)
class MemberControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MemberService memberService;

	@Test
	@DisplayName("POST /members - Save Member")
	void saveMemberTest() throws Exception {
		MemberDto memberDto = MemberDto.builder().name("lsw").build();
		String requestBody = new ObjectMapper().writeValueAsString(memberDto);

		mockMvc.perform(post("/members")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
			.andExpect(status().isOk());

		// verify(memberService).save(memberDto);
	}

	@Test
	@DisplayName("GET /members/{id} - Select Member")
	void selectMemberTest() throws Exception {
		MemberDto memberDto = MemberDto.builder().name("lsw").build();

		Member member = new Member(1L, "lsw");
		when(memberService.findById(1L)).thenReturn(member);

		mockMvc.perform(get("/members/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name").value("lsw"));

		// verify(memberService).findById(1L);
	}
	@Test
	void verify() throws Exception {
		MemberDto memberDto = MemberDto.builder().name("lsw").build();
		String requestBody = new ObjectMapper().writeValueAsString(memberDto);

		mockMvc.perform(post("/members")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
			.andExpect(status().isOk());



		Member member = new Member(1L, "lsw");
		when(memberService.findById(1L)).thenReturn(member);

		mockMvc.perform(get("/members/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.username").value("lsw"));
	}
}