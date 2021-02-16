package com.intellij.book.springboot.web.dto;

import com.intellij.book.springboot.domain.exts.FlagYN;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExtsUpdateDto {
    private FlagYN useYn;

    @Builder
    public ExtsUpdateDto(FlagYN useYn) {
        this.useYn = useYn;
    }
}
