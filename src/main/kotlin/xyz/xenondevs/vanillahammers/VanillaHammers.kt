package xyz.xenondevs.vanillahammers

import xyz.xenondevs.nova.addon.Addon
import xyz.xenondevs.nova.update.ProjectDistributor
import xyz.xenondevs.vanillahammers.advancement.Advancements
import xyz.xenondevs.vanillahammers.registry.Items
import xyz.xenondevs.vanillahammers.registry.ToolTiers

object VanillaHammers : Addon() {
    
    override val projectDistributors = listOf(ProjectDistributor.hangar("xenondevs/Vanilla-Hammers"))
    
}