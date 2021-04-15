import sbt.librarymanagement.{MavenRepository, Resolver}

object Artifactory {

  implicit class ResolverOpsArtifactory(val self: Resolver.type) extends AnyVal {

    def artifactory(owner: String, repo: String): MavenRepository = {
      MavenRepository(
        s"artifactory-$owner-$repo",
        s"https://$owner.jfrog.io/artifactory/$repo")
    }

    def evolution: MavenRepository = artifactory("evolution", "public")

    def evolutionReleases: MavenRepository = artifactory("evolution", "maven-local-releases")
  }
}
