package com.pocWireMock.demo

import com.pocWireMock.demo.shayshay.ShayShayClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class ExampleController{

    @Autowired
    lateinit var shayShayClient: ShayShayClient

    @GetMapping("/hip")
    fun helloString() = "hop"

    @GetMapping("/shayShaySay")
    fun shayShaySay() =
        shayShayClient.get()



}