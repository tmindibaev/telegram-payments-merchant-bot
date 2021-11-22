package tmin.examples.telegram_payments_merchant_bot.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Default controller that exists to return a proper REST response for unmapped requests.
 */
@Controller
class DefaultController {

    @RequestMapping("/", "/api")
    fun healthCheck(): String = "UP"
}
