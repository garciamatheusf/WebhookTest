package jersey.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("webhook")
public class WebhookController {

    @Path("200")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ok(String jsonRequest){
        System.out.println("====================================================================");
        System.out.println("Conteúdo recebido: ");
        System.out.println(jsonRequest);
        System.out.println("Retornando status 200");

        return WebhookResult.ok();
    }

    @Path("403")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response forbidden(String jsonRequest){
        System.out.println("====================================================================");
        System.out.println("Conteúdo recebido: ");
        System.out.println(jsonRequest);
        System.out.println("Retornando status 403");

        return WebhookResult.forbidden();
    }

    @Path("500")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setWebcam(String jsonRequest){
        System.out.println("====================================================================");
        System.out.println("Conteúdo recebido: ");
        System.out.println(jsonRequest);
        System.out.println("Retornando status 500");

        return WebhookResult.internalError();
    }

}
