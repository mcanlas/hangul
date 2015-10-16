scalaVersion := "2.11.7"

lazy val model = project

lazy val print = (project in file("print-characters")) dependsOn model
