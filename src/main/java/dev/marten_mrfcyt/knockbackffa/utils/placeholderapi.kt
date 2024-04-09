package dev.marten_mrfcyt.knockbackffa.utils

import dev.marten_mrfcyt.knockbackffa.KnockBackFFA
import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.OfflinePlayer
import org.bukkit.plugin.Plugin

@Suppress("UnstableApiUsage")
class PlaceHolderAPI(knockBackFFA: KnockBackFFA) : PlaceholderExpansion() {
    private val plugin: Plugin = knockBackFFA
    override fun getAuthor(): String {
        return plugin.pluginMeta.authors[0]
    }

    override fun getIdentifier(): String {
        return plugin.pluginMeta.name
    }

    override fun getVersion(): String {
        return plugin.pluginMeta.version
    }
    override fun onRequest(player: OfflinePlayer?, params: String): String? {
        if (player == null) return null
        val playerData = PlayerData(KnockBackFFA()).getPlayerData(player.uniqueId)
        return when (params) {
            "deaths" -> {
                playerData.getInt("deaths", 0).toString()
            }
            "kills" -> {
                playerData.getInt("kills", 0).toString()
            }
            "killstreak" -> {
                playerData.getInt("killstreak", 0).toString()
            }
            "coins" -> {
                playerData.getInt("coins", 0).toString()
            }
            "elo" -> {
                playerData.getInt("elo", 0).toString()
            }
            else -> null
        }
    }
}