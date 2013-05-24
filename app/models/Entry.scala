package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class Entry(id: Long, timestamp: Long) { }

object Entry {

  val entry = {
    get[Long]("id") ~
    get[Long]("timestamp") map {
      case id~timestamp => Entry(id,timestamp)
    }
  }

  def all(): List[Entry] = DB.withConnection { implicit c =>
    SQL("select * from entry order by timestamp desc").as(entry *)
  }

  def create(ts: Long) {
    DB.withConnection { implicit c =>
      SQL("insert into entry (timestamp) values ({timestamp})").on(
        'timestamp -> ts
      ).executeUpdate()
    }
  }

  def delete_oldest() {
    DB.withConnection { implicit c =>
      SQL("""delete from entry where id in
        (select id from entry order by timestamp asc limit 1)
      """).executeUpdate()
    }
  }
}

