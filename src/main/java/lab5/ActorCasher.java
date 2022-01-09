import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

public class ActorCasher extends AbstractActor {
    public static final float DEFAULT = -1.0f;
    private final Map<String, Float> cash = new HashMap<>();
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(String.class, r -> sender().tell(cash.getOrDefault(r, DEFAULT), ActorRef.noSender()))
                .match(StoreMessage.class, r -> cash.put(r.getUrl(), r.getAvgTime()))
                .matchAny(o -> System.out.println("received unknown message"))
                .build();
    }
}
