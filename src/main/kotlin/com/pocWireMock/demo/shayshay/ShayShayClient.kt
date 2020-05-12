package com.pocWireMock.demo.shayshay

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*


@FeignClient(
        name = "shayshay",
        url = "\${shayShayApi}"
)
interface ShayShayClient {

    @RequestMapping(
            method = [RequestMethod.GET],
            name = "shayShay",
            value = ["/random?limit=3"],
            consumes = ["application/json"],
            produces = ["application/json"]
    )
    fun get(@RequestHeader("x-rapidapi-key") key: String = "82ca812030mshb0ff23879e98177p1d9a61jsn22980c03e06d"): ShayShayResponse
}