package ka.api

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._

object HealthCheck {
  val route = {
    (pathPrefix("api") & get) {
      path("health-check") {
        complete(StatusCodes.OK)
      }
    }
  }
}
