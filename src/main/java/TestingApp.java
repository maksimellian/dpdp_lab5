import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class TestingApp {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create();
        ActorRef actorCasher = system.actorOf(Props.create(ActorCasher.class))
    }
}
