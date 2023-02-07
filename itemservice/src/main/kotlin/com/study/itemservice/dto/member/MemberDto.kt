package com.study.itemservice.dto.member

import com.study.itemservice.domain.Address
import com.study.itemservice.domain.Member

data class MemberDto(
    val name: String,
    val address: Address,
) {
    companion object {
        fun toDto(member: Member): MemberDto {
            return MemberDto(
                name = member.name,
                address = Address(
                    city = member.address.city,
                    street = member.address.street,
                    zipcode = member.address.zipcode

                )
            )
        }
    }
}
