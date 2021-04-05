package com.myco
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import com.myco.lib._
import Helpers._
import net.liftweb.http.S
import net.liftweb.http.provider.HTTPCookie
import io.netty.handler.codec.http.cookie._

class CookieSnippet {

  def setCookie = {
    val cookieValue = randomInt(100).toString()
    val nettyCookie = new DefaultCookie("cookietest", cookieValue)
    nettyCookie.setSameSite(CookieHeaderNames.SameSite.Strict)
    val cookieAsString = ServerCookieEncoder.LAX.encode(nettyCookie)
    S.setHeader("Set-Cookie", cookieAsString)
     "*" #> ("Cookie set to " + cookieValue)
   }

  def readCookie = {
    S.findCookie("cookietest") flatMap (_.value) match {
      case Full(cookieValue) =>
        "*" #> ("Cookie read as " + cookieValue)
      case Empty =>
        "*" #> "No cookie found"
      case Failure(msg, exception, chain) =>
        "*" #> ("Error reading the cookie: " + msg)
    }
  }

}
