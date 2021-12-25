import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class TestingApp {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create();
        ActorRef casherActor = system.actorOf(Props.create())
    }
}
