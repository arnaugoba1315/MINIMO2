package edu.upc.project.services;

import edu.upc.project.GameManager;
import edu.upc.project.GameManagerImpl;
import edu.upc.project.models.Question;
import edu.upc.project.config.CORS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/question", description = "Endpoint to Question Service")
@Path("/question")
public class QuestionService {
    final static Logger logger = Logger.getLogger(QuestionService.class);
    private GameManager gm;

    public QuestionService() {
        this.gm = GameManagerImpl.getInstance();
    }

    @POST
    @CORS
    @ApiOperation(value = "create a new question")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newQuestion(Question question) {
        logger.info("New question received");

        if (question.getTitle() == null || question.getMessage() == null ||
                question.getSender() == null || question.getDate() == null) {
            logger.error("Invalid question format");
            return Response.status(500).build();
        }

        // Asignar ID antes de guardar la pregunta
        question.setId(this.gm.sizeQuestions());
        question = this.gm.addQuestion(question);
        logger.info("Question saved with ID: " + question.getId());

        return Response.status(201).entity(question).build();
    }

    @OPTIONS
    @Path("/")
    public Response optionsForQuestion() {
        return Response.ok()
                .header("Access-Control-Allow-Methods", "POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Authorization")
                .build();
    }
}