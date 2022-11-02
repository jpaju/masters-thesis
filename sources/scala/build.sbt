Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / watchBeforeCommand    := Watch.clearScreen
ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger

fork := true

ThisBuild / scalaVersion := "3.2.0"

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

lazy val root = project
  .in(file("."))
  .settings(
    name    := "masters-thesis",
    version := "0.1.0",
  )
  .settings(
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.0.3"
    )
  )