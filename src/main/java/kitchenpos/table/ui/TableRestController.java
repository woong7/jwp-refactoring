package kitchenpos.table.ui;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kitchenpos.table.application.TableService;
import kitchenpos.table.domain.OrderTable;
import kitchenpos.table.dto.request.OrderTableCreateRequest;
import kitchenpos.table.dto.request.OrderTableEmptyUpdateRequest;
import kitchenpos.table.dto.request.OrderTableNumberOfGuestsUpdateRequest;

@RestController
@RequestMapping("/api/tables")
public class TableRestController {
    private final TableService tableService;

    public TableRestController(final TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping
    public ResponseEntity<OrderTable> create(@RequestBody final OrderTableCreateRequest request) {
        final OrderTable created = tableService.create(request);
        final URI uri = URI.create("/api/tables/" + created.getId());
        return ResponseEntity.created(uri)
            .body(created)
            ;
    }

    @GetMapping
    public ResponseEntity<List<OrderTable>> list() {
        return ResponseEntity.ok()
            .body(tableService.list())
            ;
    }

    @PutMapping("/api/tables/{orderTableId}/empty")
    public ResponseEntity<OrderTable> changeEmpty(
        @PathVariable final Long orderTableId,
        @RequestBody final OrderTableEmptyUpdateRequest request
    ) {
        return ResponseEntity.ok()
            .body(tableService.changeEmpty(orderTableId, request))
            ;
    }

    @PutMapping("/api/tables/{orderTableId}/number-of-guests")
    public ResponseEntity<OrderTable> changeNumberOfGuests(
        @PathVariable final Long orderTableId,
        @RequestBody final OrderTableNumberOfGuestsUpdateRequest request
    ) {
        return ResponseEntity.ok()
            .body(tableService.changeNumberOfGuests(orderTableId, request))
            ;
    }
}
