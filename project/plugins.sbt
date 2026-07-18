addSbtPlugin("org.scoverage" % "sbt-scoverage" % "2.4.4")

addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.12.0")

// sbt-coveralls has no sbt2/Scala 3 build, only needed for the Scala 2.12 leg
if (scala.util.Properties.versionNumberString.startsWith("2.12"))
  Seq(addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.3.15"))
else Seq.empty

addSbtPlugin("com.evolution" % "sbt-scalac-opts-plugin" % "0.0.9")
