package com.intellij.book.springboot.web;

import com.intellij.book.springboot.service.exts.ExtsService;
import com.intellij.book.springboot.web.dto.ExtsDto;
import com.intellij.book.springboot.web.dto.ExtsUpdateDto;
import com.intellij.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ExtsController {

    private final ExtsService extsService;

    @PostMapping("/api/v1/exts")
    public Long save(@RequestBody ExtsDto extsDto){

        return extsService.save(extsDto);
    }

    @DeleteMapping("/api/v1/exts/{id}")
    public Long delete(@PathVariable Long id){
        extsService.delete(id);
        return id;
    }

    @PutMapping("/api/v1/exts/{id}")
    public Long update(@PathVariable Long id, @RequestBody ExtsUpdateDto extsUpdateDto) {

        return extsService.update(id, extsUpdateDto);
    }
}
