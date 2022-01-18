# kafka-avro

## How to build

Install sbt -> https://www.scala-sbt.org/

* Local test

`sbt clean compile test`

* Local stage

`sbt stage`

* Generate Docker File

`sbt docker:stage`

* Generate Docker File publish Local

`sbt docker:publishLocal`
