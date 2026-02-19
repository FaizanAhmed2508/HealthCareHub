package nimblix.in.HealthCareHub.controller;

import nimblix.in.HealthCareHub.model.Medicine;
import nimblix.in.HealthCareHub.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PutMapping("/medicines/{id}/stock")
    public Medicine updateMedicineStock(@PathVariable Long id,
                                        @RequestParam int quantity) {
        return adminService.updateMedicineStock(id, quantity);
    }
}
