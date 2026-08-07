class TypeParameterShadow[A] {
  def shadow[A](a: A): A = a
}
