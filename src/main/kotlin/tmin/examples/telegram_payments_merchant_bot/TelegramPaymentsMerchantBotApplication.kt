package tmin.examples.telegram_payments_merchant_bot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TelegramPaymentsMerchantBotApplication

fun main(args: Array<String>) {
	runApplication<TelegramPaymentsMerchantBotApplication>(*args)
}
