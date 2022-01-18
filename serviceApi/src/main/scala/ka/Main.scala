package ka

import akka.actor.typed.{ActorSystem, DispatcherSelector}
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import com.typesafe.scalalogging.StrictLogging
import ka.api.Api

import scala.concurrent.ExecutionContext
import scala.io.StdIn

object Main extends App with StrictLogging {

  logger.info("Starting = {}", System.currentTimeMillis())
  val host = "0.0.0.0"
  val port = 8090
  implicit val system = ActorSystem(Behaviors.empty, "service-api")
  implicit val ec: ExecutionContext = system.dispatchers.lookup(DispatcherSelector.fromConfig("blocking-io-dispatcher"))
  val api = new Api
  val bindingFuture = Http().newServerAt(host, port).bind(api.route)
  StdIn.readLine()
  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())
}
