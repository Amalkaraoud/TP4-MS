package com.exemple.historique.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CALCUL-SERVICE")
public interface CalculClient {

    @GetMapping("/calcul/{operateur}")
    String calculer(@PathVariable("operateur") String operateur,
                    @RequestParam("a") int a,
                    @RequestParam("b") int b);
}