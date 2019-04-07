package com.ozruit.apigee

import com.ozruit.apigee.config.ApigeeConfig
import com.ozruit.apigee.response.ApigeeProduct
import org.assertj.core.api.Assertions
import org.junit.Test
import org.springframework.web.client.RestTemplate

class ApigeeProductClientTest {

    @Test
    fun `get apigee products`() {
        val apigeeConfig = ApigeeConfig()
        apigeeConfig.apiKey = "2ALHCAAs6ikGRBoy6eTHA58RaG097Fma"

        var rest = RestTemplate()

        var apigeeProductClient = ApigeeProductClient(rest, apigeeConfig)
        var category = "600001506"

        var products: List<ApigeeProduct> = apigeeProductClient.getProducts(category)
        products.forEach { println(it) }
        Assertions.assertThat(products).isNotEmpty
    }
}