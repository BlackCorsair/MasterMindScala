name := "MasterMindScala"

version := "0.1"

scalaVersion := "2.12.1"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % "test"
resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"
addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.10")