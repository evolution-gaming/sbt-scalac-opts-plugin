object UnusedPatvars {
  def run(o: Option[Int]): Unit = o match {
    case Some(i) => ()
    case None    => ()
  }
}
