organization := "home"

name := "test"

version := "0.1.0-SNAPSHOT"


scalaVersion := "2.11.5"

libraryDependencies ++= {
    Seq(    )
}

parallelExecution in Test := true

scalacOptions ++= Seq("-feature", "-deprecation")