package com.example.InstitutionManagement.controller

import com.example.InstitutionManagement.model.Institution
import com.example.InstitutionManagement.services.InstitutionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/institution")
@RestController
class InstitutionController(val service: InstitutionService) {
    @GetMapping
    fun getAllInstitutions()=service.getAllInstitutions()

    @GetMapping("/{id}")
    fun getInstitutionById(@PathVariable id: Long) = service.getInstitutionByID(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createInstitution(@RequestBody institution: Institution): Institution = service.createInstitution(institution)


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CONFLICT)
    fun deleteinstitution(@PathVariable id: Long) = service.deleteInstitution(id)

    @PutMapping("/{id}")
    fun updatePlayer(@PathVariable id: Long, @RequestBody institution: Institution) = service.editInstitution(id, institution)

}