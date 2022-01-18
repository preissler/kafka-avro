package ka.api

import akka.actor.typed.ActorSystem
import akka.http.scaladsl.server.Route

class Api(implicit system: ActorSystem[Nothing]) {

  val route: Route = HealthCheck.route
}
