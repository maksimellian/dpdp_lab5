import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.ActorMaterializerHelper;
import akka.stream.javadsl.Flow;

import java.util.concurrent.CompletionStage;

public class TestingApp {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static final int

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create();
        ActorRef actorCasher = system.actorOf(Props.create(ActorCasher.class), "cash");
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = createFlow(materializer, actorCasher);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost(HOST, PORT),
                materializer
        );
        System.in.read();
        binding.thenCompose(ServerBinding::unbind).thenAccept(unbound -> system.terminate());
    }

    private static Flow<HttpRequest, HttpResponse, NotUsed> createFlow(ActorMaterializer materializer, ActorRef casher) {
        return Flow.of(HttpRequest.class)
                .map((r) -> {
                    
                })
        }
    }
}
