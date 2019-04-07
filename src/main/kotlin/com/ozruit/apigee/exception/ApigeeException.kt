package com.ozruit.apigee.exception

class ApigeeException(message: String, val statusCodeValue: Int) : RuntimeException(message)
