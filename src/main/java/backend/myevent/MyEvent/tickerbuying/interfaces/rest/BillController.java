package backend.myevent.MyEvent.tickerbuying.interfaces.rest;

import backend.myevent.MyEvent.tickerbuying.domain.model.queries.BillQueries.GetAllBillsQuery;
import backend.myevent.MyEvent.tickerbuying.domain.model.queries.BillQueries.GetBillByIdQuery;
import backend.myevent.MyEvent.tickerbuying.domain.services.BillServices.BillCommandService;
import backend.myevent.MyEvent.tickerbuying.domain.services.BillServices.BillQueryService;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources.CreateBillResource;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources.BillResource;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.CreateBillCommandFromResourceAssembler;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.BillResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/bill", produces = MediaType.APPLICATION_JSON_VALUE)

public class BillController {

    private final BillQueryService billQueryService;
    private final BillCommandService billCommandService;

    public BillController(BillQueryService billQueryService, BillCommandService billCommandService) {
        this.billQueryService = billQueryService;
        this.billCommandService = billCommandService;
    }

    @PostMapping
    public ResponseEntity<?> createBill(@RequestBody CreateBillResource resource) {
        try {
            var createBillCommand = CreateBillCommandFromResourceAssembler.toCommandFromResource(resource);
            var bill = billCommandService.handle(createBillCommand);
            var billResource = BillResourceFromEntityAssembler.toResourceFromEntity(bill.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(billResource);
        } catch (IllegalArgumentException e) {
            // Devuelve el objeto de la solicitud junto con el mensaje de error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage() + ", Request: " + resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllBills() {
        try {
            var getAllBillsQuery = new GetAllBillsQuery();
            var bills = billQueryService.handle(getAllBillsQuery);
            var billResources = bills.stream()
                    .map(BillResourceFromEntityAssembler::toResourceFromEntity)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(billResources);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillResource> getBillById(@PathVariable Long id) {
        var getBillByIdQuery = new GetBillByIdQuery(id);
        var billOptional = billQueryService.handle(getBillByIdQuery);
        if (billOptional.isPresent()) {
            var billResource = BillResourceFromEntityAssembler.toResourceFromEntity(billOptional.get());
            return ResponseEntity.ok(billResource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
//http://localhost:8080/swagger-ui/index.html