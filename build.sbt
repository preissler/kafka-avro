ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val serviceApi = project.settings(
  libraryDependencies ++= Seq(
    Dependencies.AkkaHttp,
    Dependencies.AkkaActorTyped,
    Dependencies.LogBack,
  ),
  dockerExposedPorts := Seq(8080),
)

lazy val root = (project in file("."))
  .settings(
    name := "kafka-avro",
  )
  .aggregate(serviceApi)
