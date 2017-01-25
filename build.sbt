name := "avro-validate"

version := "1.0"

scalaVersion := "2.12.1"

scalacOptions := Seq("-deprecation")

libraryDependencies += "org.apache.avro" % "avro" % "1.8.1"

libraryDependencies += "io.circe" %% "circe-parser" % "0.7.0"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.22"

