package finance.board.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BatchMapper {

    @Insert("""
        INSERT INTO board_post
        (title, content, writer, created_at)
        VALUES
        ('배치 테스트', '젠킨스 자동 등록', 'JENKINS', NOW())
    """)
    void insertMock();
}