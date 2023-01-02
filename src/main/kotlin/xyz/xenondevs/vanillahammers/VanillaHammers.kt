package xyz.xenondevs.vanillahammers

import xyz.xenondevs.nova.addon.Addon
import xyz.xenondevs.vanillahammers.advancement.Advancements
import xyz.xenondevs.vanillahammers.registry.Items
import xyz.xenondevs.vanillahammers.registry.ToolTiers

object VanillaHammers : Addon() {
    
    override fun init() {
        ToolTiers.init()
        Items.init()
        Advancements.register()
    }
    
}