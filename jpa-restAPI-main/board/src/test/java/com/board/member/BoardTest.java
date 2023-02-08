package com.board.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.entity.member.Member;
import com.board.entity.member.MemberRepository;

@SpringBootTest
public class BoardTest {
	
	@Autowired
	MemberRepository memberRepository;

    @Test
    void save() {

        Member params = Member.builder()
                .nickname("임차인")
                .accountType("LESSEE")
                .accountId("lessee")
                .quit("N")
                .build();

        memberRepository.save(params);

        Member entity = memberRepository.findById((long) 4).get();
        assertThat(entity.getNickname()).isEqualTo("대장");
        assertThat(entity.getAccountType()).isEqualTo("LESSOR");
        assertThat(entity.getAccountId()).isEqualTo("admin");
        assertThat(entity.getQuit()).isEqualTo("N");
    }
}
