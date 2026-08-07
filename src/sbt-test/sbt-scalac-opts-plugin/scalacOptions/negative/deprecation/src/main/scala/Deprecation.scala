object Deprecation {
  @deprecated("gone", "0.0.0")
  def old(): Unit = ()

  def use(): Unit = old()
}
