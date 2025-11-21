package finance.board.mapper;

import finance.board.domain.BoardPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface  BoardPostMapper {
    List<BoardPost> findAll();

    BoardPost findById(Long id);

    void insert(BoardPost post);
}
