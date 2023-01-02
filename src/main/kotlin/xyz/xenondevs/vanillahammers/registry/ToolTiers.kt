package xyz.xenondevs.vanillahammers.registry

import xyz.xenondevs.nova.item.tool.ToolTierRegistry.register
import xyz.xenondevs.vanillahammers.VanillaHammers

object ToolTiers {
    
    val EMERALD = register(VanillaHammers, "emerald")
    val LAPIS = register(VanillaHammers, "lapis")
    val QUARTZ = register(VanillaHammers, "quartz")
    val OBSIDIAN = register(VanillaHammers, "obsidian")
    val PRISMARINE = register(VanillaHammers, "prismarine")
    val FIERY = register(VanillaHammers, "fiery")
    val SLIME = register(VanillaHammers, "slime")
    val ENDER = register(VanillaHammers, "ender")
    
    fun init() = Unit
    
}