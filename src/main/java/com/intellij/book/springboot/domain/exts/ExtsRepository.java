package com.intellij.book.springboot.domain.exts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ExtsRepository extends JpaRepository<Exts, Long> {
    @Query("SELECT e FROM Exts e ORDER BY e.id DESC")
    List<Exts> findAllDesc();

    List<Exts> findAllByDefaultYn(FlagYN defaultYn);

    List<Exts> findAllByUseYn(FlagYN useYn);

    List<Exts> findAllByCustomYn(FlagYN customYn);

    boolean existsByName(String name);
}
