organization := "home"

name := "scalaExamples"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.5"

libraryDependencies ++= {
    Seq( 
      "joda-time" % "joda-time" % "2.7",
      "org.joda" % "joda-convert" % "1.2"
    )
}

parallelExecution in Test := true

scalacOptions ++= Seq("-feature", "-deprecation")