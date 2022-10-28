package kitchenpos.table.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import kitchenpos.table.domain.OrderTable;

public interface OrderTableRepository extends Repository<OrderTable, Long> {
    OrderTable save(OrderTable orderTable);

    Optional<OrderTable> findById(Long orderTableId);

    List<OrderTable> findAll();
}
