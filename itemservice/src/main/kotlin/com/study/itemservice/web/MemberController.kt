package com.study.itemservice.web

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@Slf4j
class MemberController {

    private val log = LoggerFactory.getLogger(javaClass)

    @RequestMapping("/")
    fun home(): String {
        log.info("home controller")
        return "home"
    }
}