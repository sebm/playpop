package controllers

import play.api._
import play.api.mvc._

import models.Entry

object Application extends Controller {

  def index = Action {
    Ok(views.html.index(List[Entry]()))
  }

  def push = TODO

  def pop = TODO

}
