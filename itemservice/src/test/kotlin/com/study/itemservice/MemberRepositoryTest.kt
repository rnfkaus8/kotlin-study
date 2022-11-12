package com.study.itemservice

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
internal class MemberRepositoryTest(
    @Autowired
    val memberRepository: MemberRepository
) {

    @Test
    @Transactional
    fun testMember() {
        //given
        val member: Member = Member("memberA")

        //when
        val savedId = memberRepository.save(member)
        val findMember: Member = memberRepository.find(savedId)

        //then
        assertThat(findMember.id).isEqualTo(member.id)
        assertThat(findMember.username).isEqualTo(member.username)
        assertThat(findMember).isEqualTo(member)
    }
}