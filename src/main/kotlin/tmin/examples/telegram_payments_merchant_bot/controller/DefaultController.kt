package tmin.examples.telegram_payments_merchant_bot.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * Default controller that exists to return a proper REST response for unmapped requests.
 */
@Controller
class DefaultController {

    @GetMapping("/", "/healthcheck")
    fun healthCheck(): ResponseEntity<String> {
        return ResponseEntity<String>("UP", HttpStatus.OK)
    }
}
