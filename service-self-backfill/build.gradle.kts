plugins {
  id("com.github.johnrengelman.shadow")
  kotlin("jvm")
  id("com.diffplug.spotless")
}

dependencies {
  implementation(Dependencies.apacheCommonsLang3)
  implementation(Dependencies.guava)
  implementation(Dependencies.guice)
  implementation(Dependencies.jacksonDatabind)
  implementation(Dependencies.jacksonDataformatYaml)
  implementation(Dependencies.jacksonJsr310)
  implementation(Dependencies.jacksonKotlin)
  implementation(Dependencies.jCommander)
  implementation(Dependencies.jettyServer)
  implementation(Dependencies.jettyServlet)
  implementation(Dependencies.jettyWebsocketServlet)
  implementation(Dependencies.jettyWebsocketServer)
  implementation(Dependencies.kotlinStdLib)
  implementation(Dependencies.kotlinReflection)
  implementation(Dependencies.kotlinxCoroutines)
  implementation(Dependencies.kotlinxCoroutinesLogging)
  implementation(Dependencies.loggingApi)
  implementation(Dependencies.metricsCore)
  implementation(Dependencies.metricsParent)
  implementation(Dependencies.misk)
  implementation(Dependencies.miskActions)
  implementation(Dependencies.miskAdmin)
  implementation(Dependencies.miskCore)
  implementation(Dependencies.miskHibernate)
  implementation(Dependencies.miskInject)
  implementation(Dependencies.miskMetrics)
  implementation(Dependencies.miskService)
  implementation(Dependencies.miskSlack)
  implementation(Dependencies.moshiCore)
  implementation(Dependencies.moshiKotlin)
  implementation(Dependencies.okio)
  implementation(Dependencies.openTracing)
  implementation(Dependencies.openTracingOkHttp)
  implementation(Dependencies.retrofit)
  implementation(Dependencies.retrofitGuavaAdapter)
  implementation(Dependencies.retrofitWire)
  implementation(Dependencies.tracingJaeger)
  implementation(Dependencies.wireRuntime)
  implementation(Dependencies.wireCompiler)
  implementation(Dependencies.wireSchema)
  implementation(Dependencies.wispClient)
  implementation(Dependencies.wispConfig)
  implementation(Dependencies.wispDeployment)
  implementation(Dependencies.wispLogging)

  implementation(project(":client"))
  implementation(project(":client-base"))
  implementation(project(":client-misk"))
  implementation(project(":client-misk-hibernate"))
  implementation(project(":service"))

  testImplementation(Dependencies.miskTesting)
  testImplementation(Dependencies.miskHibernateTesting)
  testImplementation(Dependencies.junitApi)
  testImplementation(Dependencies.junitParams)
  testImplementation(Dependencies.junitEngine)
  testImplementation(Dependencies.kotlinTest)
  testImplementation(Dependencies.kotlinxCoroutinesTest)
  testImplementation(Dependencies.assertj)
  testImplementation(Dependencies.openTracingMock)

  testImplementation(project(":backfila-embedded"))
}

val jar by tasks.getting(Jar::class) {
  baseName = "backfila-service-self-backfill"
}

if (rootProject.file("hooks.gradle").exists()) {
  apply(from = rootProject.file("hooks.gradle"))
}

apply(from = "$rootDir/gradle-mvn-publish.gradle")
