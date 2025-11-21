package finance.board.controller;

import finance.board.domain.BoardPost;
import finance.board.dto.BoardPostForm;
import finance.board.mapper.BoardPostMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:5173") // React 개발 서버 허용 (CORS)
public class BoardApiController {

    private final BoardPostMapper boardPostMapper;

    public BoardApiController(BoardPostMapper boardPostMapper) {
        this.boardPostMapper = boardPostMapper;
    }

    // 목록
    @GetMapping
    public List<BoardPost> list() {
        return boardPostMapper.findAll();
    }

    // 상세
    @GetMapping("/{id}")
    public BoardPost detail(@PathVariable Long id) {
        return boardPostMapper.findById(id);
    }

    // 글 생성
    @PostMapping
    public void create(@RequestBody BoardPostForm form) {
        BoardPost post = new BoardPost();
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setWriter(form.getWriter());

        boardPostMapper.insert(post);
    }
}