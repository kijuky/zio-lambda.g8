package $package$

import zio.Console.*
import zio.*
import zio.lambda.*

object $main_class$ extends ZIOAppDefault {

  val app: (CustomEvent, Context) => Task[String] = (event, _) =>
    for {
      _ <- printLine(event.message)
    } yield "Handler ran successfully"

  override val run: RIO[ZIOAppArgs with Scope, Unit] =
    ZLambdaRunner.serve(app)
}
