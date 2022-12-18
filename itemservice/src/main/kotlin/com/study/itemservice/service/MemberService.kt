package com.study.itemservice.service

import com.study.itemservice.domain.Member
import com.study.itemservice.dto.member.UpdateMemberRequest
import com.study.itemservice.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(
    val memberRepository: MemberRepository
) {

    /**
     * 회원가입
     */
    @Transactional
    fun join(member: Member): Long {
        validateDuplicateMember(member)
        memberRepository.save(member)
        return member.id
    }

    private fun validateDuplicateMember(member: Member) {
        val findMembers = memberRepository.findByName(member.name)
        if (findMembers.isNotEmpty()) {
            throw IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    fun findMembers(): List<Member> {
        return memberRepository.findAll()
    }

    fun findOne(memberId: Long): Member {
        return memberRepository.findOne(memberId)
    }

    @Transactional
    fun update(id: Long, request: UpdateMemberRequest) {
        val member: Member = memberRepository.findOne(id)
        member.changeName(request.name)
        if (request.address != null) {
            member.changeAddress(request.address!!)
        }
    }

}