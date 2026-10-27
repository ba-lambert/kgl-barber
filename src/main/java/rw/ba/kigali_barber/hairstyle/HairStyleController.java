package rw.ba.kigali_barber.hairstyle;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import rw.ba.kigali_barber.common.response.ApiResponse;
import rw.ba.kigali_barber.hairstyle.dto.HairStyleRequest;
import rw.ba.kigali_barber.hairstyle.dto.HairStyleResponse;

@RestController
@Tag(name = "Hair Styles")
@RequestMapping("/api/hair-styles")
public class HairStyleController {
    private final HairStyleService hairStyleService;

    public HairStyleController(HairStyleService hairStyleService) {
        this.hairStyleService = hairStyleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<HairStyleResponse> create(@Valid @RequestBody HairStyleRequest request) {
        return new ApiResponse<>(true, "Hair style created successfully", hairStyleService.create(request));
    }

    @GetMapping
    public ApiResponse<List<HairStyleResponse>> getAll() {
        return new ApiResponse<>(true, "Hair styles retrieved successfully", hairStyleService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<HairStyleResponse> getById(@PathVariable UUID id) {
        return new ApiResponse<>(true, "Hair style retrieved successfully", hairStyleService.getById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<HairStyleResponse> update(@PathVariable UUID id,
            @Valid @RequestBody HairStyleRequest request) {
        return new ApiResponse<>(true, "Hair style updated successfully", hairStyleService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable UUID id) {
        hairStyleService.delete(id);
        return new ApiResponse<>(true, "Hair style deleted successfully", null);
    }
}
