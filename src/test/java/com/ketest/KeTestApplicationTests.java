package com.ketest;

import com.ketest.domain.member.Gender;
import com.ketest.domain.member.Member;
import com.ketest.domain.member.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class KeTestApplicationTests {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void saveMember() {
        Member saveParams = Member.builder()
                .loginId("testThird")
                .password("2222")
                .name("세번째계정")
                .gender(Gender.F)
                .birthday(LocalDate.of(1987, 8, 14))
                .deleteYn(false)
                .build();

        Member member = memberRepository.save(saveParams);
        Assertions.assertEquals(member.getLoginId(), "testThird");
    }

}
