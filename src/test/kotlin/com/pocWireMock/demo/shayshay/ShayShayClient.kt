package com.pocWireMock.demo.shayshay

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@FeignClient(
        name = "shayshay",
        url = "\${shayShayApi}"
)
interface ShayShayClient {

    @RequestMapping(
            method = [RequestMethod.GET],
            name = "shayShay",
            value = ["/random?limit=3"],
            headers = ["x-rapidapi-host: shayshay.p.rapidapi.com", "x-rapidapi-key: 82ca812030mshb0ff23879e98177p1d9a61jsn22980c03e06d"],
            consumes = ["application/json"],
            produces = ["application/json"]
    )
    fun get(): List<ShayShayResponse>
}