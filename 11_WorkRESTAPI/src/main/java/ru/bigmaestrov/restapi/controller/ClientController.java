package ru.bigmaestrov.restapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ru.bigmaestrov.restapi.model.dto.CreateClientDTO;
import ru.bigmaestrov.restapi.model.domain.Client;

@RequestMapping(ClientController.MAPPING)
public interface ClientController {
    String MAPPING = "/clients";

    @PostMapping("/create")
    @Operation(description = "Request for creating new client.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Request is ok.",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
        @ApiResponse(responseCode = "400", description = "Something gone wrong")
    })
    ResponseEntity<String> createClient(@RequestBody(required = false) CreateClientDTO dto);

    @PostMapping("/update/{id}")
    @Operation(description = "Request for updating client.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Request is ok.",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
        @ApiResponse(responseCode = "400", description = "Something gone wrong")
    })
    ResponseEntity<String> updateClient(@PathVariable(required = false) String id,
                                        @RequestBody(required = false) CreateClientDTO dto);

    @GetMapping
    @Operation(description = "Request for getting all clients.")
    ResponseEntity<Page<Client>> getClients(@RequestParam Integer page,
                                            @RequestParam(defaultValue = "20") Integer size);

    @GetMapping("/find/{id}")
    @Operation(description = "Request for getting client by id.")
    ResponseEntity<Client> getClientByID(@PathVariable(required = false) String id);

    @GetMapping("/email")
    @Operation(description = "Request for getting clients by email.")
    ResponseEntity<Page<Client>> getClientsByEmailDomain(@RequestParam String emailDomain,
                                                        @RequestParam Integer page,
                                                        @RequestParam(defaultValue = "20") Integer size);

    @GetMapping("/order")
    @Operation(description = "Request for getting clients ordered by last name.")
    ResponseEntity<Page<Client>> getClientsByLastNameByOrder(@RequestParam Integer page,
                                                            @RequestParam(defaultValue = "20") Integer size);

    @PostMapping("/remove/{id}")
    @Operation(description = "Request for removing client.")
    ResponseEntity<String> removeClient(@PathVariable(required = false) String id);
}
