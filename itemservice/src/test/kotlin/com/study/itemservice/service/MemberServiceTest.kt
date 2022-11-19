package com.study.itemservice.service

import com.study.itemservice.domain.Address
import com.study.itemservice.domain.Member
import com.study.itemservice.repository.MemberRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
internal class MemberServiceTest(
   @Autowired
   val memberRepository: MemberRepository,

   @Autowired
   val memberService: MemberService
) {

    @Test
    fun joinFailed() {

        // given
        val address1: Address = Address(city = "seoul", street = "을지로입구", zipcode = "zipcode1")
        val address2: Address = Address(city = "seoul", street = "을지로3가", zipcode = "zipcode1")
        val member1: Member = Member(name = "member1", address = address1)
        val member2: Member = Member(name = "member1", address = address2)

        // when
        memberService.join(member1)
        assertThrows(IllegalStateException::class.java) { memberService.join(member2) }
    }

    @Test
    fun joinSuccessAndFindOne() {
        // given
        val address1: Address = Address(city = "seoul", street = "을지로입구", zipcode = "zipcode1")
        val address2: Address = Address(city = "seoul", street = "을지로3가", zipcode = "zipcode1")
        val member1: Member = Member(name = "member1", address = address1)
        val member2: Member = Member(name = "member2", address = address2)

        memberService.join(member1)
        memberService.join(member2)
        // when
        val findMember1 = memberService.findOne(member1.id)
        val findMember2 = memberService.findOne(member2.id)

        // then
        assertThat(findMember1).isEqualTo(member1)
        assertThat(findMember2).isEqualTo(member2)
    }

    @Test
    fun findMembers() {
        // given
        val address1: Address = Address(city = "seoul", street = "을지로입구", zipcode = "zipcode1")
        val address2: Address = Address(city = "seoul", street = "을지로3가", zipcode = "zipcode1")
        val member1: Member = Member(name = "member1", address = address1)
        val member2: Member = Member(name = "member2", address = address2)

        memberService.join(member1)
        memberService.join(member2)

        // when
        val findMembers = memberService.findMembers()

        // then
        assertThat(findMembers).isEqualTo(arrayListOf(member1, member2))
    }

}