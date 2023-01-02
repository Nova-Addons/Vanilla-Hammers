package xyz.xenondevs.vanillahammers.registry

import xyz.xenondevs.nova.item.behavior.Damageable
import xyz.xenondevs.nova.item.behavior.Enchantable
import xyz.xenondevs.nova.item.behavior.Tool
import xyz.xenondevs.nova.material.NovaMaterialRegistry.registerItem
import xyz.xenondevs.vanillahammers.VanillaHammers
import xyz.xenondevs.vanillahammers.item.Hammer

object Items {
    
    val WOODEN_HAMMER = registerItem(VanillaHammers, "wooden_hammer", Tool, Hammer, Damageable, Enchantable)
    val STONE_HAMMER = registerItem(VanillaHammers, "stone_hammer", Tool, Hammer, Damageable, Enchantable)
    val IRON_HAMMER = registerItem(VanillaHammers, "iron_hammer", Tool, Hammer, Damageable, Enchantable)
    val GOLDEN_HAMMER = registerItem(VanillaHammers, "golden_hammer", Tool, Hammer, Damageable, Enchantable)
    val DIAMOND_HAMMER = registerItem(VanillaHammers, "diamond_hammer", Tool, Hammer, Damageable, Enchantable)
    val NETHERITE_HAMMER = registerItem(VanillaHammers, "netherite_hammer", Tool, Hammer, Damageable, Enchantable)
    val EMERALD_HAMMER = registerItem(VanillaHammers, "emerald_hammer", Tool, Hammer, Damageable, Enchantable)
    val LAPIS_HAMMER = registerItem(VanillaHammers, "lapis_hammer", Tool, Hammer, Damageable, Enchantable)
    val QUARTZ_HAMMER = registerItem(VanillaHammers, "quartz_hammer", Tool, Hammer, Damageable, Enchantable)
    val OBSIDIAN_HAMMER = registerItem(VanillaHammers, "obsidian_hammer", Tool, Hammer, Damageable, Enchantable)
    val PRISMARINE_HAMMER = registerItem(VanillaHammers, "prismarine_hammer", Tool, Hammer, Damageable, Enchantable)
    val FIERY_HAMMER = registerItem(VanillaHammers, "fiery_hammer", Tool, Hammer, Damageable, Enchantable)
    val SLIME_HAMMER = registerItem(VanillaHammers, "slime_hammer", Tool, Hammer, Damageable, Enchantable)
    val ENDER_HAMMER = registerItem(VanillaHammers, "ender_hammer", Tool, Hammer, Damageable, Enchantable)
    
    fun init() = Unit
    
}