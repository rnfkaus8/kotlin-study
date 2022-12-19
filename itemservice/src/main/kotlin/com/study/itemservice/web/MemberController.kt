package com.study.itemservice.web

import com.study.itemservice.domain.Address
import com.study.itemservice.domain.Member
import com.study.itemservice.dto.member.MemberDto
import com.study.itemservice.dto.member.UpdateMemberRequest
import com.study.itemservice.service.MemberService
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors
import javax.validation.Valid
import com.study.itemservice.dto.Result

@RestController
@Slf4j
class MemberController(
    private val memberService: MemberService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping(value = ["/members/new"])
    fun create(@RequestBody @Valid form: MemberForm): MemberDto {
        log.info("name : ${form.name}")
        log.info("city : ${form.city}")
        log.info("street : ${form.street}")
        log.info("zipcode : ${form.zipcode}")
        val address: Address = Address(city = form.city, street = form.street, zipcode = form.zipcode)
        val member: Member = Member(name = form.name, address = address)
        memberService.join(member)
        return MemberDto.toDto(member)
    }

    @PutMapping(value = ["/members/{id}"])
    fun updateMember(@PathVariable("id") id: Long, @RequestBody @Valid request: UpdateMemberRequest): MemberDto {
        memberService.update(id, request)
        val findMember = memberService.findOne(id)
        return MemberDto.toDto(findMember)
    }

    @GetMapping("/members")
    fun members(): Result<List<MemberDto>> {
        val findMembers = memberService.findMembers()
        val collect = findMembers.stream().map { m ->
            MemberDto(
                name = m.name,
                address = Address(city = m.address.city, street = m.address.street, zipcode = m.address.zipcode)
            )
        }
            .collect(Collectors.toList())

        return Result(collect)
    }

}