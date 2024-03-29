Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / watchBeforeCommand           := Watch.clearScreen
ThisBuild / watchTriggeredMessage        := Watch.clearScreenOnTrigger
ThisBuild / watchForceTriggerOnAnyChange := true

fork := true

ThisBuild / scalaVersion := "3.2.2"

ThisBuild / scalacOptions ++=
  Seq(
    "-source:future",
    "-deprecation",
    "-feature",
    "-unchecked",
    "-explain",
    "-Ysafe-init",
    "-Ykind-projector",
    "-Wconf:id=E029:error,msg=non-initialized:error,msg=spezialized:error,cat=unchecked:error",
  )

javacOptions ++= Seq("-source", "17")

val zioVersion        = "2.0.10"
val postgresqlVersion = "42.2.24"

name    := "masters-thesis"
version := "0.1.0"
libraryDependencies ++= Seq(
  "dev.zio"       %% "zio"        % zioVersion,
  "org.postgresql" % "postgresql" % postgresqlVersion,
)

libraryDependencies ++= Seq(
  "dev.zio" %% "zio-test"     % zioVersion,
  "dev.zio" %% "zio-test-sbt" % zioVersion,
).map(_ % Test)
