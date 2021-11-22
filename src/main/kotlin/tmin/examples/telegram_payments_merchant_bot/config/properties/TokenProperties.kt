package tmin.examples.telegram_payments_merchant_bot.config.properties

import org.jetbrains.annotations.NotNull
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated

@Validated
@ConfigurationProperties(prefix = "token")
class TokenProperties {
    @NotNull
    lateinit var botToken: String

    @NotNull
    lateinit var testProviderToken: String
}
