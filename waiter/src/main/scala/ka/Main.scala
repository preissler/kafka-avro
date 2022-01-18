package ka

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorSystem, DispatcherSelector}
import akka.http.scaladsl.Http
import com.typesafe.scalalogging.StrictLogging
import ka.api.Api

import scala.concurrent.ExecutionContext

object Main extends App with StrictLogging {

  logger.info("Starting Waiter = {}", System.currentTimeMillis())
  val host = "0.0.0.0"
  val port = 8091
  implicit val system = ActorSystem(Behaviors.empty, "service-api")
  implicit val ec: ExecutionContext = system.dispatchers.lookup(DispatcherSelector.fromConfig("blocking-io-dispatcher"))
  val api = new Api
  Http().newServerAt(host, port).bind(api.route)

}
