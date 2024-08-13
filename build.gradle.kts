plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

subprojects {
    group = "com.example"
    version = "1.0-SNAPSHOT"
    repositories {
        mavenCentral()
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
    apply(plugin = "java")

    dependencies {
        implementation("org.junit.jupiter:junit-jupiter-api:5.10.3")
        implementation("org.junit.jupiter:junit-jupiter-params:5.10.3")
        runtimeOnly("org.junit.platform:junit-platform-launcher")
    }
}