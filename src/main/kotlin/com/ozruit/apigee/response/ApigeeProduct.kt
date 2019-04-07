package com.ozruit.apigee.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ApigeeProduct (
        val  productId : String,
val type: String,
val title: String,
val  code: BigDecimal,
val reviews: Long,
val price: ApigeePrice
)