package nimblix.in.HealthCareHub.repository;

import nimblix.in.HealthCareHub.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}

