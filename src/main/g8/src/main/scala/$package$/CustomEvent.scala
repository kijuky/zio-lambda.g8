package $package$

import zio.json.*

final case class CustomEvent(message: String)

object CustomEvent {
  given JsonDecoder[CustomEvent] =
    DeriveJsonDecoder.gen[CustomEvent]
}
