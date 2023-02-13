package study.jpa.kotlin.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import study.jpa.kotlin.domain.Member
import study.jpa.kotlin.repository.MemberRepository

@Service
@Transactional(readOnly = true)
class MemberService(
  val memberRepository: MemberRepository
) {

  @Transactional
  fun join(member: Member): Long {
    validateDuplicateMember(member)
    memberRepository.save(member)
    return member.id!!
  }

  fun findMembers(): List<Member> {
    return memberRepository.findAll()
  }

  fun findOne(id: Long): Member {
    return memberRepository.findOne(id)
  }

  private fun validateDuplicateMember(member: Member) {
    val findMembers = memberRepository.findByName(member.name)
    if (!findMembers.isEmpty()) {
      throw IllegalStateException("이미 존재하는 회원입니다.")
    }
  }

}