package com.intellij.book.springboot.web.dto;

import com.intellij.book.springboot.domain.exts.Exts;
import com.intellij.book.springboot.domain.exts.FlagYN;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExtsSaveDto {
    private String name;
    private FlagYN defaultYn;
    private FlagYN useYn;
    private FlagYN customYn;

    @Builder
    public ExtsSaveDto(String name, FlagYN defaultYn, FlagYN useYn, FlagYN customYn) {

        this.name = name;
        this.defaultYn = defaultYn;
        this.useYn = useYn;
        this.customYn = customYn;
    }

    public Exts toEntity() {
        return Exts.builder()
                .name(name)
                .defaultYn(defaultYn)
                .useYn(useYn)
                .customYn(customYn)
                .build();
    }
}
