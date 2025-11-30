package finance.board.service;

import finance.board.domain.BoardPost;
import finance.board.mapper.BoardPostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class BoardPostService {

    private final BoardPostMapper boardPostMapper;

    public BoardPostService(BoardPostMapper boardPostMapper) {
        this.boardPostMapper = boardPostMapper;
    }

    @Transactional(readOnly = true)
    public List<BoardPost> findAll() {
        return boardPostMapper.findAll();
    }

    @Transactional(readOnly = true)
    public BoardPost findById(Long id) {
        BoardPost post = boardPostMapper.findById(id);
        if (post == null) {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다. id=" + id);
        }
        return post;
    }

    public Long create(BoardPost post) {
        boardPostMapper.insert(post);
        return post.getId();
    }

    public void update(BoardPost post) {
        boardPostMapper.update(post);
    }

    public void delete(Long id) {
        boardPostMapper.delete(id);
    }
}
