plugins {
    kotlin("jvm") version "1.5.31"
}

val ktor_version = "1.6.4"

group = "com.adoneko"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly(kotlin("stdlib"))
    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly(kotlin("stdlib-jdk7"))
    compileOnly(kotlin("reflect"))

    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-websockets:$ktor_version")

    compileOnly("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7.1")
}