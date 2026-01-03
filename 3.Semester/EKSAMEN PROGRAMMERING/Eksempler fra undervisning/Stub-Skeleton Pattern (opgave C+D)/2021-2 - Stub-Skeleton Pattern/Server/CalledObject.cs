
namespace StubSkeletonPattern.Server {

  public class CalledObject : IMethodImpl {

    public Person Oldest(Person p1, Person p2) {
      if (p1.CompareTo(p2) >= 0)
        return p1;
      else
        return p2;
    }
  }
}
