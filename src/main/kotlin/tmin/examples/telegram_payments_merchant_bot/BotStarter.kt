package tmin.examples.telegram_payments_merchant_bot

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId
import org.springframework.stereotype.Component

@Component
class BotStarter {

    init {
        val bot = bot {

            token = "My token"
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
                    bot.sendMessage(ChatId.fromId(message.chat.id), "Hey bruh!")
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
    }
}
