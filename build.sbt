val commonSettings = Seq(
  scalaVersion := "2.12.6",
  crossScalaVersions := Seq("2.11.12", "2.12.6"),
  organization := "com.htmlism")

lazy val root = (project in file ("."))
  .aggregate(model, print)
  .settings(commonSettings: _*)

lazy val model = project
  .settings(commonSettings: _*)
  .settings(
    name := "hangul-model",
    libraryDependencies += "org.specs2" %% "specs2-core" % "4.3.4" % "test",
    initialCommands in console := "import com.htmlism.hangul._")

lazy val print = (project in file("print-characters"))
  .dependsOn(model)
  .settings(commonSettings: _*)

scalafmtOnCompile := true
