import sbt._
object Dependencies {

  object Versions {
    val AkkaVersion = "2.6.17"
    val AkkaHttpVersion = "10.2.6"
    val LogVersionClassic = "1.2.8"
    val LoggingVersion = "3.9.4"
  }

  val LogBack = "ch.qos.logback" % "logback-classic" % Versions.LogVersionClassic
  val AkkaActorTyped = "com.typesafe.akka" %% "akka-actor-typed" % Versions.AkkaVersion
  val AkkaHttp = "com.typesafe.akka" %% "akka-http" % Versions.AkkaHttpVersion
  val AkkaStream = "com.typesafe.akka" %% "akka-stream" % Versions.AkkaVersion
  val ScalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % Versions.LoggingVersion
}
