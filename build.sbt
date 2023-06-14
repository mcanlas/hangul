val commonSettings = Seq(
  organization := "com.htmlism"
)

lazy val root = (project in file("."))
  .aggregate(model, print)
  .settings(commonSettings: _*)

lazy val model = project
  .settings(commonSettings: _*)
  .settings(
    name                                := "hangul-model",
    libraryDependencies += "org.specs2" %% "specs2-core" % "4.10.6" % "test",
    console / initialCommands           := "import com.htmlism.hangul._"
  )

lazy val print = (project in file("print-characters"))
  .dependsOn(model)
  .settings(commonSettings: _*)
