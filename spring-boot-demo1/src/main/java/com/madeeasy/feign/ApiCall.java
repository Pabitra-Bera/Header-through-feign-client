package com.madeeasy.feign;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8080",name = "apicall")
@Component
public interface ApiCall {

    @GetMapping("/welcome")
//    @Headers("Content-Type: application/json")
    public String welcome(@RequestHeader("Authorization")  String bearerToken);
}
