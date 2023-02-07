package com.study.itemservice.dto.member

import com.study.itemservice.domain.Address
import javax.validation.constraints.NotEmpty

data class UpdateMemberRequest(
    @field:NotEmpty(message = "회원 이름은 필수 입니다.")
    val name: String,

    var address: Address?
)
