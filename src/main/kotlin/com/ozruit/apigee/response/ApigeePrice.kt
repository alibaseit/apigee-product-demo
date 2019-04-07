package com.ozruit.apigee.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.JsonNode

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ApigeePrice(
        val was: String,
        val then1: String,
        val then2: String,
        val now: JsonNode,
        val uom: String,
        val currency: String
)