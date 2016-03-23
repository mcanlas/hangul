scalaVersion := twoEleven

crossScalaVersions := Seq("2.10.6", twoEleven)

lazy val model = project

lazy val print = (project in file("print-characters")) dependsOn model
