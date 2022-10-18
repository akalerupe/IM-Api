package com.example.InstitutionManagement.controller

import Institution
import com.example.InstitutionManagement.viewmodel.InstitutionViewModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/institution")
@RestController
class InstitutionController(val viewModel: InstitutionViewModel) {
    @GetMapping
    fun getAllInstitutions()=viewModel.getAllInstitutions()

    @GetMapping("/{id}")
    fun getInstitutionById(@PathVariable id: Long) = viewModel.getInstitutionByID(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun savePlayer(@RequestBody institution: Institution): Institution = viewModel.createInstitution(institution)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteinstitution(@PathVariable id: Long) = viewModel.deleteInstitution(id)

    @PutMapping("/{id}")
    fun updatePlayer(@PathVariable id: Long, @RequestBody institution: Institution) = viewModel.editInstitution(id, institution)

}