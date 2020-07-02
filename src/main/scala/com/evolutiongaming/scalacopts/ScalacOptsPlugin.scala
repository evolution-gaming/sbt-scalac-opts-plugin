package com.evolutiongaming.scalacopts

import sbt.Keys._
import sbt._

object ScalacOptsPlugin extends AutoPlugin {

  override def trigger: PluginTrigger = allRequirements

  final case class ScalacOpt(
    name: String,
    sinceOpt: Option[Int] = None,
    untilOpt: Option[Int] = None
  ) {

    def until(until: Int): ScalacOpt = copy(untilOpt = Some(until))

    def since(since: Int): ScalacOpt = copy(sinceOpt = Some(since))
  }


  val scalacOptsAll = List(
    ScalacOpt("-deprecation") until 13,                     // Emit warning and location for usages of deprecated APIs. Not really removed but deprecated in 2.13.
    ScalacOpt("-explaintypes"),                             // Explain type errors in more detail.
    ScalacOpt("-feature"),                                  // Emit warning and location for usages of features that should be imported explicitly.
    ScalacOpt("-language:existentials"),                    // Existential types (besides wildcard types) can be written and inferred
    ScalacOpt("-language:experimental.macros"),             // Allow macro definition (besides implementation and application)
    ScalacOpt("-language:higherKinds"),                     // Allow higher-kinded types
    ScalacOpt("-language:implicitConversions"),             // Allow definition of implicit functions called views
    ScalacOpt("-unchecked"),                                // Enable additional warnings where generated code depends on assumptions.
    ScalacOpt("-Xcheckinit"),                               // Wrap field accessors to throw an exception on uninitialized access.
    ScalacOpt("-Xfatal-warnings"),                          // Fail the compilation if there are any warnings.
    ScalacOpt("-Xfuture") until 13,                         // Turn on future language features. This is not really removed in 2.13 but is replaced by -Xsource which requires the user to choose which language version they want.
    ScalacOpt("-Xlog-reflective-calls"),                    // Print a message when a reflective method call is generated
    ScalacOpt("-Xlint") until 11,                           // Used to mean enable all linting options but now the syntax for that is different (-Xlint:_ I think)
    ScalacOpt("-Xlint:adapted-args"),                       // Warn if an argument list is modified to match the receiver.
    ScalacOpt("-Xlint:by-name-right-associative") until 13, // By-name parameter of right associative operator.
    ScalacOpt("-Xlint:constant") since 12,                  // Evaluation of a constant arithmetic expression results in an error.
    ScalacOpt("-Xlint:delayedinit-select"),                 // Selecting member of DelayedInit.
    ScalacOpt("-Xlint:deprecation") since 13,               // Emit warning and location for usages of deprecated APIs.
    ScalacOpt("-Xlint:doc-detached"),                       // A Scaladoc comment appears to be detached from its element.
    ScalacOpt("-Xlint:inaccessible"),                       // Warn about inaccessible types in method signatures.
    ScalacOpt("-Xlint:infer-any"),                          // Warn when a type argument is inferred to be `Any`.
    ScalacOpt("-Xlint:missing-interpolator"),               // A string literal appears to be missing an interpolator id.
    ScalacOpt("-Xlint:nullary-override") until 13,          // Warn when non-nullary `def f()' overrides nullary `def f'.
    ScalacOpt("-Xlint:nullary-unit"),                       // Warn when nullary methods return Unit.
    ScalacOpt("-Xlint:option-implicit"),                    // Option.apply used implicit view.
    ScalacOpt("-Xlint:package-object-classes"),             // Class or object defined in package object.
    ScalacOpt("-Xlint:poly-implicit-overload"),             // Parameterized overloaded implicit methods are not visible as view bounds.
    ScalacOpt("-Xlint:private-shadow"),                     // A private field (or class parameter) shadows a superclass field.
    ScalacOpt("-Xlint:stars-align"),                        // Pattern sequence wildcard must align with sequence component.
    ScalacOpt("-Xlint:type-parameter-shadow"),              // A local type parameter shadows a type already in scope.
    ScalacOpt("-Xlint:unsound-match") until 13,             // Pattern match may not be typesafe.
    ScalacOpt("-Ywarn-macros:after"),                       // Enable lint warnings on macro expansions: Only inspect expanded trees when generating unused symbol warnings.
    ScalacOpt("-Yno-adapted-args") until 13,                // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver.
    ScalacOpt("-Ypartial-unification") until 13,            // Enable partial unification in type constructor inference
    ScalacOpt("-Ywarn-dead-code") until 13,                 // Warn when dead code is identified.
    ScalacOpt("-Wdead-code") since 13,                      // ^ Replaces the above
    ScalacOpt("-Ywarn-extra-implicit") since 12 until 13,   // Warn when more than one implicit parameter section is defined.
    ScalacOpt("-Wextra-implicit") since 13,                 // ^ Replaces the above
    ScalacOpt("-Ywarn-inaccessible") until  11,             // Warn about inaccessible types in method signatures. Alias for -Xlint:inaccessible so can be removed as of 2.11.
    ScalacOpt("-Ywarn-nullary-override") until 13,          // Warn when non-nullary `def f()' overrides nullary `def f'.
    ScalacOpt("-Ywarn-nullary-unit") until 13,              // Warn when nullary methods return Unit.
    ScalacOpt("-Ywarn-numeric-widen") until 13,             // Warn when numerics are widened.
    ScalacOpt("-Wnumeric-widen") since 13,                  // ^ Replaces the above
    ScalacOpt("-Ywarn-unused-import") until 12,             // Warn if an import selector is not referenced.
    ScalacOpt("-Ywarn-unused:implicits") since 12 until 13, // Warn if an implicit parameter is unused.
    ScalacOpt("-Wunused:implicits") since 13,               // ^ Replaces the above
    ScalacOpt("-Ywarn-unused:imports") since 12 until 13,   // Warn if an import selector is not referenced.
    ScalacOpt("-Wunused:implicits") since 13,               // ^ Replaces the above
    ScalacOpt("-Ywarn-unused:locals") since 12 until 13,    // Warn if a local definition is unused.
    ScalacOpt("-Wunused:locals") since 13,                  // ^ Replaces the above
    ScalacOpt("-Ywarn-unused:params") since 12 until 13,    // Warn if a value parameter is unused.
    ScalacOpt("-Wunused:params") since 13,                  // ^ Replaces the above
    ScalacOpt("-Ywarn-unused:patvars") since 12 until 13,   // Warn if a variable bound in a pattern is unused.
    ScalacOpt("-Wunused:patvars") since 13,                 // ^ Replaces the above
    ScalacOpt("-Ywarn-unused:privates") since 12 until 13,  // Warn if a private member is unused.
    ScalacOpt("-Wunused:privates") since 13,                // ^ Replaces the above
    ScalacOpt("-Ywarn-value-discard") until 13,             // Warn when non-Unit expression results are unused.
    ScalacOpt("-Wvalue-discard") since 13                   // ^ Replaces the above
  )


  object autoImport {

    lazy val scalacOptsFailOnWarn = settingKey[Option[Boolean]]("Adds or removes -Xfatal-warnings")

    def scalacOptsFor(version: String, scalacOpts: List[ScalacOpt]): List[String] = {
      val opts = for {
        version        <- CrossVersion.partialVersion(version).toList
        (major, minor)  = version if major == 2
        scalacOpt      <- scalacOpts
        if scalacOpt.sinceOpt forall { _ <= minor }
        if scalacOpt.untilOpt forall { _  > minor }
      } yield {
        scalacOpt.name
      }
      List("-encoding", "utf-8") ++ opts
    }

    val filterConsoleScalacOpts: Seq[String] => Seq[String] = {
      val exclude = Set(
        "-Werror",
        "-Wdead-code",
        "-Wunused:imports",
        "-Ywarn-unused:imports",
        "-Ywarn-unused-import",
        "-Ywarn-dead-code",
        "-Xfatal-warnings")

      opts: Seq[String] => opts.filterNot(exclude)
    }

    def failOnWarn(failOnWarn: Option[Boolean]): Seq[String] => Seq[String] = {
      val opt = "-Xfatal-warnings"
      opts: Seq[String] =>
        failOnWarn.fold(opts) {
          case true  => if (opts contains opt) opts else opts :+ opt
          case false => opts.filter(_ != opt)
        }
    }
  }

  import autoImport._

  override def projectSettings: Seq[Setting[_]] = List(
    scalacOptsFailOnWarn := Some(true),
    scalacOptions ++= failOnWarn(scalacOptsFailOnWarn.value)(scalacOptsFor(scalaVersion.value, scalacOptsAll)),
    scalacOptions.in(Compile, console) ~= filterConsoleScalacOpts,
    scalacOptions.in(Test, console)    ~= filterConsoleScalacOpts
  )
}
