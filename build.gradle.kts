import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "xyz.xenondevs"
version = "1.2-RC.1"

val mojangMapped = project.hasProperty("mojang-mapped")

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.nova)
    alias(libs.plugins.stringremapper)
    alias(libs.plugins.specialsource)
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.xenondevs.xyz/releases")
    
    // include xenondevs-nms repository if requested
    if (project.hasProperty("xenondevsNms")) {
        maven("https://repo.papermc.io/repository/maven-public/") // authlib, brigadier, etc.
        maven {
            name = "xenondevsNms"
            url = uri("https://repo.xenondevs.xyz/nms/")
            credentials(PasswordCredentials::class)
        }
    }
}

dependencies {
    implementation(libs.nova)
}

addon {
    id.set(project.name)
    name.set("Vanilla Hammers")
    version.set(project.version.toString())
    novaVersion.set(libs.versions.nova)
    main.set("xyz.xenondevs.vanillahammers.VanillaHammers")
    
    authors.add("StudioCode")
}

spigotRemap {
    spigotVersion.set(libs.versions.spigot.get().substringBefore('-'))
    sourceJarTask.set(tasks.jar)
}

remapStrings {
    remapGoal.set(if (mojangMapped) "mojang" else "spigot")
    spigotVersion.set(libs.versions.spigot.get())
}

tasks {
    register<Copy>("addonJar") {
        group = "build"
        dependsOn("addon", if (mojangMapped) "jar" else "remapObfToSpigot")
        
        from(File(project.buildDir, "libs/${project.name}-${project.version}.jar"))
        into((project.findProperty("outDir") as? String)?.let(::File) ?: project.buildDir)
        rename { it.replace(project.name, "Vanilla-Hammers") }
    }
    
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}