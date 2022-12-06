package com.similar.infrastructure.client;

import com.similar.application.exception.SimulatedClientExceptionHandler;
import com.similar.domain.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "similar", url = "localhost:3001", fallback = SimulatedClientExceptionHandler.class)
public interface SimulatedClient {
    @GetMapping(path = "/product/{productId}/similarids")
    List<Long> getSimilar(@RequestHeader HttpHeaders headers, @PathVariable Long productId);

    @GetMapping(path = "/product/{similarProductId}")
    Product getDetailOfProduct( @PathVariable Long similarProductId);
}
