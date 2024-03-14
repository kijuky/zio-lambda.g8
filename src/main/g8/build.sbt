lazy val root = (project in file("."))
  .settings(
    name := "$name$",
    organization := "$package$",
    scalaVersion := "$scala_version$",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio-json" % "0.6.2",
      "dev.zio" %% "zio-lambda" % "1.0.4"
    )
  )
  .enablePlugins(GraalVMNativeImagePlugin)
  .settings(
    GraalVMNativeImage / mainClass := Some("$package$.$main_class$"),
    GraalVMNativeImage / containerBuildImage := Some("ghcr.io/graalvm/native-image-community:$graalvm_version$"),
    graalVMNativeImageOptions := Seq(
      "--verbose",
      "--no-fallback",
      "--install-exit-handlers",
      "--enable-http",
      "--link-at-build-time",
      "--report-unsupported-elements-at-runtime",
      "-H:+UnlockExperimentalVMOptions",
      "-H:+StaticExecutableWithDynamicLibC",
      "-H:+RemoveSaturatedTypeFlows"
    )
  )
