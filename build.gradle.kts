import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    val kotlinVersion = "1.3.31"
    idea
    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
    id("org.springframework.boot") version "2.1.5.RELEASE"
}

group = "poc"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        jcenter()
    }
}

subprojects {
    apply(plugin = "idea")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "kotlin-spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation(kotlin("reflect"))

        // we need both to make IDEA working
        kapt("org.springframework.boot:spring-boot-configuration-processor")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    val bootJar: BootJar by tasks
    bootJar.enabled = true
}

val bootJar: BootJar by tasks
bootJar.enabled = false
