ThisBuild / scalaVersion := "2.13.8"

lazy val serviceApi = project
  .settings(
    libraryDependencies ++= Seq(
      Dependencies.AkkaHttp,
      Dependencies.AkkaActorTyped,
      Dependencies.AkkaStream,
      Dependencies.ScalaLogging,
      Dependencies.LogBack,
    ),
    dockerExposedPorts := Seq(8090),
  )
  .enablePlugins(JavaAppPackaging)

lazy val waiter = project
  .settings(
    libraryDependencies ++= Seq(
      Dependencies.AkkaHttp,
      Dependencies.AkkaActorTyped,
      Dependencies.AkkaStream,
      Dependencies.ScalaLogging,
      Dependencies.LogBack,
    ),
    dockerExposedPorts := Seq(8091),
  )
  .enablePlugins(JavaAppPackaging)

lazy val root = (project in file("."))
  .settings(
    name := "kafka-avro",
  )
  .aggregate(serviceApi, waiter)
