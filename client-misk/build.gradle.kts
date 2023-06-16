import com.vanniktech.maven.publish.JavadocJar.Dokka
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension

plugins {
  kotlin("jvm")
  `java-library`
  id("com.vanniktech.maven.publish.base")
}

dependencies {
  implementation(Dependencies.apacheCommonsLang3)
  implementation(Dependencies.guava)
  implementation(Dependencies.moshiCore)
  implementation(Dependencies.moshiKotlin)
  implementation(Dependencies.wireRuntime)
  implementation(Dependencies.guice)
  implementation(Dependencies.okHttp)
  implementation(Dependencies.retrofit)
  implementation(Dependencies.retrofitMock)
  implementation(Dependencies.retrofitMoshi)
  implementation(Dependencies.retrofitWire)
  implementation(Dependencies.okio)
  implementation(Dependencies.kotlinStdLib)
  implementation(Dependencies.wireMoshiAdapter)
  implementation(Dependencies.slf4jApi)
  implementation(Dependencies.loggingApi)

  api(project(":client"))
  // We do not want to leak client-base implementation details to customers.
  implementation(project(":client-base"))

  implementation(Dependencies.misk)
  implementation(Dependencies.miskActions)
  implementation(Dependencies.miskCore)
  implementation(Dependencies.miskInject)
  implementation(Dependencies.miskService)
  implementation(Dependencies.wispLogging)

  testImplementation(Dependencies.assertj)
  testImplementation(Dependencies.miskTesting)
  testImplementation(Dependencies.junitEngine)

  testImplementation(project(":backfila-embedded"))
  testImplementation(project(":client-testing"))
}

configure<MavenPublishBaseExtension> {
  configure(
    KotlinJvm(javadocJar = Dokka("dokkaGfm"))
  )
}
