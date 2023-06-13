package com.schoolmanagement.controller;

import com.schoolmanagement.entity.concretes.AdminTEKRAR;
import com.schoolmanagement.payload.request.AdminRequest;
import com.schoolmanagement.payload.request.AdminRequestTEKRAR;
import com.schoolmanagement.service.AdminServiceTEKRAR;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController//konctroller klasi
@RequestMapping("admin")//END POINT
@RequiredArgsConstructor////FINAL FIELDLARDAN CONSRTRUCTION INJECTION YAPAR.
public class AdminControllerTEKRAR {

    private AdminServiceTEKRAR adminServiceTEKRAR;//denpndensi injection

   //  Not: save()  *******************************************************
//admin i kaydediyoruz

    @PostMapping("/save")//jason dosya donecek @RequestBody
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> save(@RequestBody @Valid AdminRequestTEKRAR adminRequestTEKRAR){

        return ResponseEntity.ok(adminServiceTEKRAR.save(adminRequestTEKRAR));

    }
    // Not: getALL()********************************************************
@GetMapping("/getAll")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public ResponseEntity<Page<AdminTEKRAR>>getAll(
        @RequestParam(value = "page",defaultValue = "0")int page,
        @RequestParam(value = "size",defaultValue = "10")int size,
        @RequestParam(value = "sort",defaultValue = "name") String sort,
        @RequestParam(value = "type",defaultValue = "desc") String type
){
    // pageable obje olusturulmasi servis katinda yapilabilir
    Pageable pageable= PageRequest.of(page, size, Sort.by(sort).ascending());

    if(Objects.equals(type,"desc")){
        pageable=PageRequest.of(page, size,Sort.by(sort).descending());
    }
Page <AdminTEKRAR>author= adminServiceTEKRAR.getAllAdminTEKRAR(pageable);
return new ResponseEntity<>(author, HttpStatus.OK);
    }

    // Not: delete() *******************************************************
@GetMapping("/delete/{id}")
//@PreAuthorize("hasAnyAuthority('ADMIN')")
public ResponseEntity<String>delete(@PathVariable Long id){
        return ResponseEntity.ok(adminServiceTEKRAR.deleteAdmin(id));
}







}
