lazy val root = (project in file("."))
  .aggregate(model, print)
  .disablePublishing

lazy val model = project
  .settings(description := "A Scala data model for the Korean alphabet")
  .settings(
    name                      := "hangul-model",
    console / initialCommands := "import com.htmlism.hangul._"
  )
  .withTesting

lazy val print = (project in file("print-characters"))
  .dependsOn(model)
  .disablePublishing
