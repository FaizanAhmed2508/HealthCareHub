package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.model.Medicine;
import nimblix.in.HealthCareHub.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/medicines")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<?> createMedicine(@RequestBody Medicine medicine) {

        if (medicine.getName() == null || medicine.getName().isBlank()) {
            return ResponseEntity.badRequest().body("Medicine name is required");
        }

        if (medicine.getStock() < 0) {
            return ResponseEntity.badRequest().body("Stock cannot be negative");
        }

        if (medicine.getPrice() < 0) {
            return ResponseEntity.badRequest().body("Price cannot be negative");
        }

        return ResponseEntity.ok(adminService.createMedicine(medicine));
    }

    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        return ResponseEntity.ok(adminService.getAllMedicines());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicineById(@PathVariable Long id) {

        Medicine medicine = adminService.getMedicineById(id);

        if (medicine == null) {
            return ResponseEntity.status(404)
                    .body("Medicine not found with id: " + id);
        }

        return ResponseEntity.ok(medicine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMedicine(@PathVariable Long id,
                                            @RequestBody Medicine medicine) {

        if (medicine.getName() == null || medicine.getName().isBlank()) {
            return ResponseEntity.badRequest().body("Medicine name is required");
        }

        if (medicine.getStock() < 0) {
            return ResponseEntity.badRequest().body("Stock cannot be negative");
        }

        if (medicine.getPrice() < 0) {
            return ResponseEntity.badRequest().body("Price cannot be negative");
        }

        Medicine updated = adminService.updateMedicine(id, medicine);

        if (updated == null) {
            return ResponseEntity.status(404)
                    .body("Medicine not found with id: " + id);
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedicine(@PathVariable Long id) {

        boolean deleted = adminService.deleteMedicine(id);

        if (!deleted) {
            return ResponseEntity.status(404)
                    .body("Medicine not found with id: " + id);
        }

        return ResponseEntity.ok("Medicine deleted successfully");
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<?> updateMedicineStock(@PathVariable Long id,
                                                 @RequestParam int quantity) {

        if (quantity <= 0) {
            return ResponseEntity.badRequest()
                    .body("Quantity must be greater than 0");
        }

        Medicine updatedMedicine = adminService.updateMedicineStock(id, quantity);

        if (updatedMedicine == null) {
            return ResponseEntity.status(404)
                    .body("Medicine not found with id: " + id);
        }

        return ResponseEntity.ok(updatedMedicine);
    }
}