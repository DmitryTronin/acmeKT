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
    implementation(kotlin("stdlib"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}



application {
    mainClass.set("banking.MainKt")
}