package ka

object Main extends App with StrictLogging {

  logger.info("Starting = ", System.currentTimeMillis())
  val host = "0.0.0.0"
  val port = 8080
  implicit val system = ActorSystem(Behaviors.empty, "service-api")

}
