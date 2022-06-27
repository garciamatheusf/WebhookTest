package jersey.resources;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.ws.rs.core.Response;

class WebhookResult {

    static Response ok() {
        ObjectNode json = JsonNodeFactory.instance.objectNode();
        json.put("status", 200);
        json.put("motivo", "Operacao realizada com sucesso");

        return prepareResponse(json);
    }

    static Response internalError(){
        ObjectNode json = JsonNodeFactory.instance.objectNode();
        json.put("status", 500);
        json.put("motivo", "Operacao nao realizada");

        return prepareResponse(json);
    }

    static Response forbidden(){
        ObjectNode json = JsonNodeFactory.instance.objectNode();
        json.put("status", 403);
        json.put("motivo", "Proibido");

        return prepareResponse(json);
    }

    static Response prepareResponse(ObjectNode json) {
        return Response
                .status(Response.Status.FORBIDDEN)
                .entity(json.toString())
                .build();
    }

}
