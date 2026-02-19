package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.model.Medicine;

public interface AdminService {

    Medicine updateMedicineStock(Long id, int quantity);
}
