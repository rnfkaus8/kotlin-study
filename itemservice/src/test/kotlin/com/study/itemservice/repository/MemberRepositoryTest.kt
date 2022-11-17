package com.study.itemservice.repository

import com.study.itemservice.domain.Address
import com.study.itemservice.domain.Member
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
internal class MemberRepositoryTest(
    @Autowired
    val memberRepository: MemberRepository
) {

    @Test
    fun save() {
        //given
        val address = Address(city = "seoul", "을지로", "000000")
        val member = Member(name = "member1", address = address)
        //when
        memberRepository.save(member)
        val findMember = memberRepository.findOne(member.id!!)
        //then
        assertThat(findMember).isEqualTo(member)
        assertThat(findMember.name).isEqualTo("member1")
        assertThat(findMember.address).isEqualTo(address)
    }
}