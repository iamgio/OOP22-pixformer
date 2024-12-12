plugins {
    // Apply the java plugin to add support for Java
    java

    kotlin("jvm") version "2.0.20"

    // Apply the application plugin to add support for building a CLI application
    // You can run your app via task "run": ./gradlew run
    application

    /*
     * Adds tasks to export a runnable jar.
     * In order to create it, launch the "shadowJar" task.
     * The runnable jar will be found in build/libs/projectname-all.jar
     */
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("org.danilopianini.gradle-java-qa") version "0.41.0"

    id("org.jlleitschuh.gradle.ktlint") version "12.1.2"
}

group = "pixformer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val javaFXModules =
    listOf(
        "base",
        "controls",
        "fxml",
        "graphics",
    )

val supportedPlatforms = listOf("linux", "mac", "win") // All required for OOP

dependencies {
    // Suppressions for SpotBugs
    compileOnly("com.github.spotbugs:spotbugs-annotations:4.7.3")

    // Example library: Guava. Add what you need (and remove Guava if you don't use it)
    implementation("com.google.code.gson:gson:2.10.1")

    // JavaFX: comment out if you do not need them
    val javaFxVersion = 15
    for (platform in supportedPlatforms) {
        for (module in javaFXModules) {
            implementation("org.openjfx:javafx-$module:$javaFxVersion:$platform")
        }
    }

    val jUnitVersion = "5.9.1"
    // JUnit API and testing engine
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testImplementation(kotlin("test"))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")

    // Ktor

    val ktorVersion = "3.0.2"

    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-websockets:$ktorVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("org.slf4j:slf4j-simple:2.0.16")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

application {
    // Define the main class for the application
    mainClass.set("pixformer.Pixformer")
}
