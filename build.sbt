val commonSettings = Seq(
  scalafmtOnCompile := true,
  scalaVersion := "2.13.1",
  crossScalaVersions := Seq("2.11.12", "2.12.11", "2.13.1"),
  organization := "com.htmlism"
)

lazy val root = (project in file("."))
  .aggregate(model, print)
  .settings(commonSettings: _*)

lazy val model = project
  .settings(commonSettings: _*)
  .settings(
    name := "hangul-model",
    libraryDependencies += "org.specs2" %% "specs2-core" % "4.9.3" % "test",
    initialCommands in console := "import com.htmlism.hangul._"
  )

lazy val print = (project in file("print-characters"))
  .dependsOn(model)
  .settings(commonSettings: _*)
