package com.ozruit.apigee.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class ApigeeConfig {

    @Value("\${apigee.api-key}")
    lateinit var apiKey: String
}

