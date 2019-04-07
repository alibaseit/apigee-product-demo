package com.ozruit.apigee

import com.ozruit.apigee.config.ApigeeConfig
import com.ozruit.apigee.exception.ApigeeException
import com.ozruit.apigee.response.ApigeeProduct
import com.ozruit.apigee.response.ApigeeProductResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class ApigeeProductClient(val restTemplate: RestTemplate,
                          val apigeeConfig: ApigeeConfig) {
    val logger = LoggerFactory.getLogger(ApigeeProductClient::class.java)!!

    fun getProducts(category: String): List<ApigeeProduct> {
        val url = "https://jl-nonprod-syst.apigee.net/v1/categories/$category/products?key=${apigeeConfig.apiKey}"

        val response = restTemplate.getForEntity(url, ApigeeProductResponse::class.java)

        if (!response.statusCode.is2xxSuccessful) {
            logger.error("Apigee exception {}", response.body)
            throw ApigeeException("Apigee Exception.", response.statusCodeValue)
        }

        return response.body!!.products
    }

}