package ru.svyat.telda.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.svyat.telda.batismapper.RegionMapper;
import ru.svyat.telda.model.Region;

import java.util.List;

@RestController
@RequestMapping("/api/v1/region")
public class RegionRestController {

    @Autowired
    public RegionMapper regionMapper;

    @GetMapping
    public ResponseEntity<List<Region>> getAll() {
        List<Region> res = regionMapper.findAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable Integer id) {
        if (id == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Region reg = regionMapper.getById(id);
        if (reg == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reg, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Region> insertRegion(@RequestBody Region region) {
        if (region == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        regionMapper.insert(region);
        return new ResponseEntity<>(region, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Region> deleteRegionById(@RequestBody Region region,
                                                   @PathVariable Integer id) {
        if (region == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (id == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Region reg = regionMapper.getById(id);
        if (reg == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        regionMapper.update(region, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Region> deleteRegionById(@PathVariable Integer id) {
        if (id == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Region reg = regionMapper.getById(id);
        if (reg == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        regionMapper.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
