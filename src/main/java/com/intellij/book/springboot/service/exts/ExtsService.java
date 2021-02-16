package com.intellij.book.springboot.service.exts;

import com.intellij.book.springboot.domain.exts.Exts;
import com.intellij.book.springboot.domain.exts.ExtsRepository;
import com.intellij.book.springboot.domain.exts.FlagYN;
import com.intellij.book.springboot.domain.posts.Posts;
import com.intellij.book.springboot.web.dto.ExtsDto;
import com.intellij.book.springboot.web.dto.ExtsResponseDto;
import com.intellij.book.springboot.web.dto.ExtsUpdateDto;
import com.intellij.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ExtsService {
    private final ExtsRepository extsRepository;

    @Transactional
    public Long save(ExtsDto extsDto) {

        validateName(extsDto.getName());

        return extsRepository.save(extsDto.toEntity()).getId();

    }

    private void validateName(String name) {
        boolean exists = extsRepository.existsByName(name);
        if(exists){
            throw new IllegalArgumentException(name + "은 이미 존재하는 확장자입니다.");
        }
    }

    @Transactional
    public List<ExtsResponseDto> findAllDesc() {
        return extsRepository.findAllDesc().stream()
                .map(ExtsResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ExtsResponseDto> findAllByDefaultYn(FlagYN defaultYn) {

        return extsRepository.findAllByDefaultYn(defaultYn).stream()
                .map(ExtsResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ExtsResponseDto> findAllByUseYn(FlagYN useYn) {
        return extsRepository.findAllByUseYn(useYn).stream()
                .map(ExtsResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ExtsResponseDto> findAllByCustomYn(FlagYN customYn) {
        return extsRepository.findAllByCustomYn(customYn).stream()
                .map(ExtsResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {

        Exts exts = extsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 확장자가 없습니다. id="+id));

        extsRepository.delete(exts);
    }

    @Transactional
    public Long update(Long id, ExtsUpdateDto extsUpdateDto) {

        Exts exts = extsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 확장자가 없습니다. id="+ id));

        exts.update(extsUpdateDto.getUseYn());

        return id;
    }

}
