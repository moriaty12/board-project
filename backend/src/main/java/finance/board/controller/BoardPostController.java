package finance.board.controller;

import finance.board.domain.BoardPost;
import finance.board.service.BoardPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/board-posts")
public class BoardPostController {

    private final BoardPostService boardPostService;

    public BoardPostController(BoardPostService boardPostService) {
        this.boardPostService = boardPostService;
    }

    // 목록 조회
    @GetMapping
    public ResponseEntity<List<BoardPost>> list() {
        List<BoardPost> posts = boardPostService.findAll();
        return ResponseEntity.ok(posts);
    }

    // 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<BoardPost> detail(@PathVariable Long id) {
        BoardPost post = boardPostService.findById(id);
        return ResponseEntity.ok(post);
    }

    // 등록
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody BoardPost post) {
        Long id = boardPostService.create(post);
        return ResponseEntity.created(URI.create("/api/board-posts/" + id)).body(id);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody BoardPost post) {
        post.setId(id);
        boardPostService.update(post);
        return ResponseEntity.noContent().build();
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardPostService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
