package finance.board.controller;

import finance.board.domain.BoardPost;
import finance.board.mapper.dto.BoardPostForm;
import finance.board.mapper.BoardPostMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class BoardController {

    private final BoardPostMapper boardPostMapper;

    public BoardController(BoardPostMapper boardPostMapper) {
        this.boardPostMapper = boardPostMapper;
    }

    // 목록
    @GetMapping
    public String list(Model model) {
        List<BoardPost> posts = boardPostMapper.findAll();
        model.addAttribute("posts", posts);
        return "posts/list";   // templates/posts/list.html
    }

    // 글쓰기 폼
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("postForm", new BoardPostForm());
        return "posts/new";
    }

    // 글 저장
    @PostMapping
    public String create(@ModelAttribute("postForm") BoardPostForm form) {
        BoardPost post = new BoardPost();
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setWriter(form.getWriter());

        boardPostMapper.insert(post);

        return "redirect:/posts";
    }

    // 상세
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        BoardPost post = boardPostMapper.findById(id);
        if (post == null) {
            throw new IllegalArgumentException("게시글이 없습니다. id=" + id);
        }
        model.addAttribute("post", post);
        return "posts/detail";
    }
}
