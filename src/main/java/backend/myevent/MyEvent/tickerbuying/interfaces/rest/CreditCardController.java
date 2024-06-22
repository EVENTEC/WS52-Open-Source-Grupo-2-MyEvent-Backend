package backend.myevent.MyEvent.tickerbuying.interfaces.rest;

import backend.myevent.MyEvent.tickerbuying.domain.model.queries.CreditCardQueries.GetAllCreditCardsQuery;
import backend.myevent.MyEvent.tickerbuying.domain.model.queries.CreditCardQueries.GetCreditCardByIdQuery;
import backend.myevent.MyEvent.tickerbuying.domain.services.CreditCardServices.CreditCardCommandService;
import backend.myevent.MyEvent.tickerbuying.domain.services.CreditCardServices.CreditCardQueryService;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.creditcardresources.CreateCreditCardResource;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.creditcardresources.CreditCardResource;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.creditcardtransform.CreateCreditCardCommandFromResourceAssembler;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.creditcardtransform.CreditCardResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/creditcard",produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "CreditCard", description = "CreditCard Management Endpoints")
public class CreditCardController {

    private final CreditCardQueryService creditCardQueryService;
    private final CreditCardCommandService creditCardCommandService;

    public CreditCardController(CreditCardQueryService creditCardQueryService, CreditCardCommandService creditCardCommandService) {
        this.creditCardQueryService = creditCardQueryService;
        this.creditCardCommandService = creditCardCommandService;
    }

    @Operation(summary = "Create a new credit card", description = "Create a new credit card")
    @PostMapping
    public ResponseEntity<?> createCreditCard(@RequestBody CreateCreditCardResource resource) {
        try{
            var createCreditCardCommand = CreateCreditCardCommandFromResourceAssembler.toCommandFromResource(resource);
            var creditCard = creditCardCommandService.handle(createCreditCardCommand);
            var creditCardResource = CreditCardResourceFromEntityAssembler.toResourceFromEntity(creditCard.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(creditCardResource);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<CreditCardResource>> getAllCreditCards() {
        var getAllCreditCardsQuery = new GetAllCreditCardsQuery();
        var creditCards = creditCardQueryService.handle(getAllCreditCardsQuery);
        var creditCardResources = creditCards.stream()
                .map(CreditCardResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(creditCardResources);
    }
    @Operation(summary = "Get a credit card by ID", description = "Get a credit card by ID")
    @GetMapping("/{id}")
    public ResponseEntity<CreditCardResource> getCreditCardById(@PathVariable Long id) {
        var getCreditCardByIdQuery = new GetCreditCardByIdQuery(id);
        var creditCardOptional = creditCardQueryService.handle(getCreditCardByIdQuery);
        if (creditCardOptional.isPresent()) {
            var creditCardResource = CreditCardResourceFromEntityAssembler.toResourceFromEntity(creditCardOptional.get());
            return ResponseEntity.ok(creditCardResource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}

//http://localhost:8080/swagger-ui/index.html
