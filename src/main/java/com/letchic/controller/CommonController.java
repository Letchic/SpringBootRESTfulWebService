package com.letchic.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.letchic.exception.NoFoundException;
import com.letchic.model.Common;
import com.letchic.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CommonController<E extends Common, S extends CommonService<E>> {

    @Autowired
    S service;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/find/all")
    public List<E> findAllBooks() {
        return service.findAll();
    }

    @GetMapping("/find")
    public ResponseEntity<E> findById(@RequestParam int id) {
        try {
            E entity = service.findById(id);
            return ResponseEntity.ok(entity);
        } catch (NoFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody E entity) {
        service.create(entity);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable int id)  {
        try {
            service.deleteById(id);
            return HttpStatus.OK;
        } catch (EmptyResultDataAccessException e) {
            return HttpStatus.NOT_FOUND;
        }
    }

    @PatchMapping(path = "/patch/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<E> patch(@PathVariable int id, @RequestBody JsonPatch patch) {
        try {
            E entityPatched = service.patch(id, patch);
            return ResponseEntity.ok(entityPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (NoFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<E> update(@PathVariable int id, @RequestBody E entity) {
        E updated = service.updateById(id, entity);
        return ResponseEntity.ok(updated);
    }


}