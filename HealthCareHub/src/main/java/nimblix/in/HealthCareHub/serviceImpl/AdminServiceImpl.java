package nimblix.in.HealthCareHub.serviceImpl;

import nimblix.in.HealthCareHub.model.Medicine;
import nimblix.in.HealthCareHub.repository.MedicineRepository;
import nimblix.in.HealthCareHub.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final MedicineRepository medicineRepository;

    public AdminServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public Medicine updateMedicineStock(Long id, int quantity) {

        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));

        medicine.setStock(medicine.getStock() + quantity);

        return medicineRepository.save(medicine);
    }
}
