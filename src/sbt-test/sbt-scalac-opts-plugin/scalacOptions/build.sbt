ThisBuild / crossScalaVersions := Seq(
  "2.12.13",
  "2.13.4",
  "2.13.10",
  "3.3.6",
  "3.8.4",
)

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))

// each project below violates a single scalac option enabled by the plugin,
// so it must fail to compile (the plugin enables -Xfatal-warnings)
lazy val constant = project in file("negative/constant")
lazy val deadCode = project in file("negative/deadCode")
lazy val deprecation = project in file("negative/deprecation")
lazy val feature = project in file("negative/feature")
lazy val inferAny = project in file("negative/inferAny")
lazy val missingInterpolator = project in file("negative/missingInterpolator")
lazy val nullaryUnit = project in file("negative/nullaryUnit")
lazy val numericWiden = project in file("negative/numericWiden")
lazy val packageObjectClasses = project in file("negative/packageObjectClasses")
lazy val typeParameterShadow = project in file("negative/typeParameterShadow")
lazy val unusedImplicits = project in file("negative/unusedImplicits")
lazy val unusedImports = project in file("negative/unusedImports")
lazy val unusedLocals = project in file("negative/unusedLocals")
lazy val unusedPatvars = project in file("negative/unusedPatvars")
lazy val unusedPrivates = project in file("negative/unusedPrivates")
lazy val valueDiscard = project in file("negative/valueDiscard")
