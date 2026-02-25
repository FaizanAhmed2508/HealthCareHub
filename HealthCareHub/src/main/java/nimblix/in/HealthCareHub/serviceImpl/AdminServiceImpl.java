package nimblix.in.HealthCareHub.serviceImpl;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.model.Medicine;
import nimblix.in.HealthCareHub.repository.MedicineRepository;
import nimblix.in.HealthCareHub.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final MedicineRepository medicineRepository;

    @Override
    public Medicine createMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    @Override
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

    @Override
    public Medicine updateMedicine(Long id, Medicine updatedMedicine) {

        return medicineRepository.findById(id)
                .map(medicine -> {
                    medicine.setName(updatedMedicine.getName());
                    medicine.setPrice(updatedMedicine.getPrice());
                    medicine.setStock(updatedMedicine.getStock());
                    return medicineRepository.save(medicine);
                })
                .orElse(null);
    }

    @Override
    public boolean deleteMedicine(Long id) {

        if (medicineRepository.existsById(id)) {
            medicineRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Medicine updateMedicineStock(Long id, int quantity) {

        return medicineRepository.findById(id)
                .map(medicine -> {
                    medicine.setStock(medicine.getStock() + quantity);
                    return medicineRepository.save(medicine);
                })
                .orElse(null);
    }
}