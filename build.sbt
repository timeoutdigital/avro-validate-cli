name := "avro-validate"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies += "org.apache.avro" % "avro" % "1.8.1"

libraryDependencies ++= Seq("circe-core", "circe-generic", "circe-parser").map("io.circe" %% _ % "0.6.0")

scalacOptions := Seq("-deprecation")

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.22"

