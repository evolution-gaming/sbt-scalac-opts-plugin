import ScriptedPlugin.autoImport._

sbtPlugin := true

name := "sbt-scalac-opts-plugin"

organization := "com.evolutiongaming"

description := "Scalac options for sbt projects"

homepage := Some(new URL("http://github.com/evolution-gaming/sbt-scalac-opts-plugin"))

startYear := Some(2019)

organizationName := "Evolution Gaming"

organizationHomepage := Some(url("http://evolutiongaming.com"))

bintrayOrganization := Some("evolutiongaming")

scalaVersion := crossScalaVersions.value.head

crossScalaVersions := Seq("2.12.8")

crossSbtVersions := Seq("1.2.8")

resolvers += Resolver.bintrayRepo("evolutiongaming", "maven")

licenses := Seq(("MIT", url("https://opensource.org/licenses/MIT")))

releaseCrossBuild := true

scriptedBufferLog := false

scriptedLaunchOpts := Seq("-Xmx1G", s"-Dplugin.version=${version.value}")

enablePlugins(SbtPlugin)

addCommandAlias("build", ";clean; coverage; test; scripted")