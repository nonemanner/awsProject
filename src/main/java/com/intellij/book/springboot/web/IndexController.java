package com.intellij.book.springboot.web;

import com.intellij.book.springboot.config.auth.LoginUser;
import com.intellij.book.springboot.config.auth.dto.SessionUser;
import com.intellij.book.springboot.domain.exts.Exts;
import com.intellij.book.springboot.domain.exts.FlagYN;
import com.intellij.book.springboot.service.exts.ExtsService;
import com.intellij.book.springboot.service.posts.PostsService;
import com.intellij.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final ExtsService extsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return  "posts-update";
    }

    @GetMapping("/exts")
    public String exts(Model model, @LoginUser SessionUser user) {

        model.addAttribute("extsCustom", extsService.findAllByCustomYn(FlagYN.Y));
        model.addAttribute("extsCustomLength", extsService.findAllByCustomYn(FlagYN.Y).size());

        model.addAttribute("extsDefault", extsService.findAllByDefaultYn(FlagYN.Y));

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "exts";
    }
}
