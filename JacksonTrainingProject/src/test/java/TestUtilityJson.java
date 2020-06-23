import org.junit.jupiter.api.Test;
import ru.vtb.internship.jackson.entity.Member;
import ru.vtb.internship.jackson.entity.Tag;
import ru.vtb.internship.jackson.entity.Task;
import ru.vtb.internship.jackson.utility.UtilityJason;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtilityJson {
    private static final String json = "{\"id\":9,\"name\":\"Misha\",\"tasks\":[{\"id\":1,\"name\":\"SomeName\",\"tags\":[{\"id\":3,\"name\":\"Git\"}]}]}";

    private static final Member member;

    static {
        List<Tag> tags = Arrays.asList(new Tag(3, "Git"));
        List<Task> tasks = Arrays.asList(new Task("SomeName", 1, tags));
        member = new Member(9, "Misha", tasks);
    }

    @Test
    public void testGetJsonFromObject() throws Exception {
        String testJson = UtilityJason.getJsonFromObject(member);
        assertEquals(testJson, json);
    }

    @Test
    public void testGetObjectFromJson() throws Exception {
        Member testMember = UtilityJason.getObjectFromJson(json, Member.class);
        assertEquals(testMember, member);
    }
}
