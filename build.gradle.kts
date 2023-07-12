plugins {
    kotlin("jvm") version "1.7.10"
    application
}
val kotlinVersion="1.7.10"
val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlinStdlib)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainClass.set("app.banking.AppKt") // Replace "your.package.name" with the correct package name
}