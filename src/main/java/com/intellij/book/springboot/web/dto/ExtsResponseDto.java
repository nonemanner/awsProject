package com.intellij.book.springboot.web.dto;

import com.intellij.book.springboot.domain.exts.Exts;
import com.intellij.book.springboot.domain.exts.FlagYN;
import lombok.Getter;

@Getter
public class ExtsResponseDto {
    private Long id;
    private String name;
    private FlagYN defaultYn;
    private FlagYN useYn;
    private FlagYN customYn;

    public ExtsResponseDto(Exts exts){
        this.id = exts.getId();
        this.name = exts.getName();
        this.defaultYn = exts.getDefaultYn();
        this.useYn = exts.getUseYn();
        this.customYn = exts.getCustomYn();
    }
}
