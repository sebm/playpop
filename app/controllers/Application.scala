package controllers

import play.api._
import play.api.mvc._

import models.Entry

object Application extends Controller {

  def index = Action {
    Ok(views.html.index(Entry.all()))
  }

  def push = Action {
    Entry.create(System.currentTimeMillis)
    Redirect(routes.Application.index)
  }

  def pop = Action {
    Entry.delete_oldest()
    Redirect(routes.Application.index)
  }

}
