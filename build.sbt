val commonSettings = Seq(
  scalaVersion := "2.12.4",
  crossScalaVersions := Seq("2.10.7", "2.11.12", "2.12.4"),
  organization := "com.htmlism")

lazy val root = (project in file ("."))
  .aggregate(model, print)
  .settings(commonSettings: _*)

lazy val model = project
  .settings(commonSettings: _*)
  .settings(
    name := "hangul-model",
    libraryDependencies += "org.specs2" %% "specs2-core" % "3.8.9" % "test",
    initialCommands in console := "import com.htmlism.hangul._")

lazy val print = (project in file("print-characters"))
  .dependsOn(model)
  .settings(commonSettings: _*)
