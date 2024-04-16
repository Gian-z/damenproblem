ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.13"

lazy val root = (project in file("."))
  .settings(
    name := "damenproblem",
    idePackagePrefix := Some("m323.damenproblem")
  )

libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.4"
