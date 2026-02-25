package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.model.Medicine;

import java.util.List;

public interface AdminService {

    Medicine createMedicine(Medicine medicine);

    List<Medicine> getAllMedicines();

    Medicine getMedicineById(Long id);

    Medicine updateMedicine(Long id, Medicine medicine);

    boolean deleteMedicine(Long id);

    Medicine updateMedicineStock(Long id, int quantity);
}