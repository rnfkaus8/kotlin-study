package com.study.itemservice

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Member(username: String) {

    var username: String = username

    @Id
    @GeneratedValue
    var id: Long = 0L

}