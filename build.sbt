name := "bittrex-scala-client-example"

version := "0.1"

scalaVersion := "2.12.4"

mainClass in (Compile, run) := Some("com.example.bittrex.Main")

libraryDependencies ++= Seq(
  "com.github.taintech" %% "bittrex-client" % "0.2"
)