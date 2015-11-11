scalaVersion := "2.11.7"

name := "hangul-model"

organization := "com.htmlism"

libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.4" % "test"

initialCommands in console := "import com.htmlism.hangul._"
