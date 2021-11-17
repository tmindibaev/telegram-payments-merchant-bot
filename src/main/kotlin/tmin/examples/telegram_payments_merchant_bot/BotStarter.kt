package tmin.examples.telegram_payments_merchant_bot

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.preCheckoutQuery
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.payments.LabeledPrice
import com.github.kotlintelegrambot.entities.payments.PaymentInvoiceInfo
import org.springframework.stereotype.Component
import java.math.BigInteger
import java.util.logging.Logger

@Component
class BotStarter {

    init {
        val bot = bot {

            token = "my bot token"

            dispatch {
                text {
                    if (!availableCommands.contains(text)) {
                        bot.sendMessage(ChatId.fromId(message.chat.id), "Maybe u could use some /help ?")
                    }
                }
                command("help") {
                    bot.sendMessage(ChatId.fromId(message.chat.id), "Available commands are: $availableCommands")
                }
                command("testPayment") {
                    logger.info("Started testPayment handling")
                    val response = bot.sendInvoice(
                        ChatId.fromId(message.chat.id),
                        PaymentInvoiceInfo(
                            title = "Тестовый платёж",
                            description = "Описание",
                            payload = "internal payload",
                            providerToken = "my provider payment token",
                            startParameter = "startParameter",
                            currency = "USD",
                            prices = listOf(LabeledPrice(label = "Three hundred bucks", amount = BigInteger.valueOf(30000)))
                        )
                    )
                    logger.info("Got response from telegram: $response")
                    response.fold(
                        ifSuccess =  { logger.info("Success!")},
                        ifError = { bot.sendMessage(ChatId.fromId(message.chat.id), "Something went wrong. $response") }
                    )
                }
                preCheckoutQuery {
                    logger.info("Started preCheckoutQuery handling")
                    bot.answerPreCheckoutQuery(preCheckoutQuery.id, ok = true)
                }

                command("wakeMeUp") {
                    bot.sendMessage(ChatId.fromId(message.chat.id), "Проснись, Нео... Ты обосрался")
                }
            }
        }

        bot.startPolling()
    }

    companion object {
        val availableCommands = listOf(
            "/help",
            "/testPayment",
            "/wakeMeUp",
        )
        val logger: Logger = Logger.getLogger("BotStarter")
    }
}
