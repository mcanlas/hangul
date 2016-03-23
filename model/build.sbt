scalaVersion := twoEleven

name := "hangul-model"

organization := "com.htmlism"

libraryDependencies += "org.specs2" %% "specs2-core" % "3.7.2" % "test"

initialCommands in console := "import com.htmlism.hangul._"
