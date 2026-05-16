import sbt.Keys.*
import sbt.*

object DependenciesPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    implicit class DependencyOps(p: Project) {
      def withTesting: Project = {
        p.settings(
          libraryDependencies ++= Seq(
            "org.typelevel" %% "weaver-cats" % Versions.weaver % Test
          )
        )
      }
    }
  }
}
