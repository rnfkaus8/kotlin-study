package com.study.itemservice.web

import com.study.itemservice.domain.Address
import com.study.itemservice.domain.Member
import com.study.itemservice.service.MemberService
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@Slf4j
class MemberController(
    private val memberService: MemberService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping(value = ["/members/new"])
    fun create(@Valid form: MemberForm): String {
        log.info("name : ${form.name}")
        log.info("city : ${form.city}")
        log.info("street : ${form.street}")
        log.info("zipcode : ${form.zipcode}")
        val address: Address = Address(city = form.city, street = form.street, zipcode = form.zipcode)
        val member: Member = Member(name = form.name, address = address)
        memberService.join(member)
        return "hello"
    }

}