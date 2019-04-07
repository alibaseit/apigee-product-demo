package com.ozruit.controller

import com.ozruit.apigee.ApigeeProductClient
import com.ozruit.apigee.response.ApigeeProduct
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping
class ProductsController(private val apigeeProductClient: ApigeeProductClient) {

    @GetMapping("/categories/{category}/reduced-products")
    internal fun discountedProductsByCategory(@RequestParam(value = "labelType", defaultValue = "ShowWasNow") labelType: String,
                                              @PathVariable(value = "category") category: String): ResponseEntity<List<ApigeeProduct>> {
        return ResponseEntity.ok(apigeeProductClient.getProducts(category))
    }
}