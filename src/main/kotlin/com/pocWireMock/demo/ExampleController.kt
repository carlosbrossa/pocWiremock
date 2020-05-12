package com.pocWireMock.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class ExampleController{

    @GetMapping("/hip")
    fun helloString() = "hop"



}