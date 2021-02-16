package com.intellij.book.springboot.domain.exts;

import com.intellij.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Exts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique=true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private FlagYN defaultYn;

    @Enumerated(EnumType.STRING)
    @Column
    private FlagYN useYn;

    @Enumerated(EnumType.STRING)
    @Column
    private FlagYN customYn;

    @Builder
    public Exts(String name, FlagYN defaultYn, FlagYN useYn, FlagYN customYn) {
        this.name = name;
        this.defaultYn = defaultYn;
        this.useYn = useYn;
        this.customYn = customYn;
    }

    public void update(FlagYN useYn) {
        this.useYn = useYn;
    }
}

