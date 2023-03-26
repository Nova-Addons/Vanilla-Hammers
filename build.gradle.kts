import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "xyz.xenondevs"
version = "1.0-SNAPSHOT"

val mojangMapped = project.hasProperty("mojang-mapped") || System.getProperty("mojang-mapped") != null

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("jvm") version "1.7.21"
    id("xyz.xenondevs.specialsource-gradle-plugin") version "1.0.0"
    id("xyz.xenondevs.string-remapper-gradle-plugin") version "1.0.0"
    id("xyz.xenondevs.nova.nova-gradle-plugin") version libs.versions.nova
}

repositories {
    mavenCentral()
    maven("https://repo.xenondevs.xyz/releases")
    mavenLocal { content { includeGroup("org.spigotmc") } }
}

dependencies {
    implementation(libs.nova)
    implementation(variantOf(libs.spigot) { classifier("remapped-mojang") })
}

addon {
    id.set(project.name)
    name.set("Vanilla Hammers")
    version.set(project.version.toString())
    novaVersion.set(libs.versions.nova)
    main.set("xyz.xenondevs.vanillahammers.VanillaHammers")
    
    authors.add("StudioCode")
    // TODO: spigot resource id
}

spigotRemap {
    spigotVersion.set(libs.versions.spigot.get().substringBefore('-'))
    sourceJarTask.set(tasks.jar)
    spigotJarClassifier.set("")
}

remapStrings {
    remapGoal.set(if (mojangMapped) "mojang" else "spigot")
    spigotVersion.set(libs.versions.spigot.get())
    classes.set(listOf(
        // Put your classes to string-remap here
    ))
}

tasks {
    register<Copy>("addonJar") {
        group = "build"
        dependsOn("addon", if (mojangMapped) "jar" else "remapObfToSpigot")
        
        from(File(File(project.buildDir, "libs"), "${project.name}-${project.version}.jar"))
        into(
            (project.findProperty("outDir") as? String)?.let(::File)
                ?: System.getProperty("outDir")?.let(::File)
                ?: project.buildDir
        )
        rename { it.replace(project.name, addon.get().addonName.get()) }
    }
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}