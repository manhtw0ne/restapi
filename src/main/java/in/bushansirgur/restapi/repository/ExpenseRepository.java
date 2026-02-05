package in.bushansirgur.restapi.repository;

import in.bushansirgur.restapi.entity.ExpenseEntity;
import in.bushansirgur.restapi.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
    Optional<ExpenseEntity> findByExpenseId(String expenseId);

    List<ExpenseEntity> findByOwner(Long id);

    Optional<ExpenseEntity> findByOwnerAndExpenseId(Long id, String expenseId);
}