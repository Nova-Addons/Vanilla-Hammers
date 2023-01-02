package xyz.xenondevs.vanillahammers.item.options

import xyz.xenondevs.nova.data.config.ConfigAccess
import xyz.xenondevs.nova.material.ItemNovaMaterial

class HammerOptions(material: ItemNovaMaterial) : ConfigAccess(material) {
    
    val range by getEntry<Int>("range")
    val depth by getEntry<Int>("depth")
    val hardnessTolerance by getEntry<Double>("hardness_tolerance")
    
}