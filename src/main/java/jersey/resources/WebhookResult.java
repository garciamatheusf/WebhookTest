package jersey.resources;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.ws.rs.core.Response;

public class WebhookResult {

    public static Response ok() {
        ObjectNode json = JsonNodeFactory.instance.objectNode();
        json.put("status", 200);
        json.put("motivo", "Operacao realizada com sucesso");

        return Response
                .ok(json.toString())
                .build();
    }

    public  static Response internalError(){
        ObjectNode json = JsonNodeFactory.instance.objectNode();
        json.put("status", 500);
        json.put("motivo", "Operacao nao realizada");

        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(json.toString())
                .build();
    }

    public static Response forbidden(){
        ObjectNode json = JsonNodeFactory.instance.objectNode();
        json.put("status", 403);
        json.put("motivo", "Proibido");

        return Response
                .status(Response.Status.FORBIDDEN)
                .entity(json.toString())
                .build();
    }

}
