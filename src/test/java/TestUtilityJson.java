import org.junit.jupiter.api.Test;
import ru.vtb.internship.entity.Member;
import ru.vtb.internship.entity.Tag;
import ru.vtb.internship.entity.Task;
import ru.vtb.internship.utility.UtilityJason;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtilityJson {
    private static final UtilityJason UTILITY_JASON = new UtilityJason();
    private static final String JSON = "{\"id\":9,\"name\":\"Misha\",\"tasks\":[{\"id\":1,\"name\":\"SomeName\",\"tags\":[{\"id\":3,\"name\":\"Git\"}]}]}";
    private static final Member MEMBER;

    static {
        List<Tag> tags = Arrays.asList(new Tag(3, "Git"));
        List<Task> tasks = Arrays.asList(new Task("SomeName", 1, tags));
        MEMBER = new Member(9, "Misha", tasks);
    }

    @Test
    public void testGetJsonFromObject() throws Exception {
        String testJson = UTILITY_JASON.getJsonFromObject(MEMBER);
        assertEquals(testJson, JSON);
    }

    @Test
    public void testGetObjectFromJson() throws Exception {
        Member testMember = UTILITY_JASON.getObjectFromJson(JSON, Member.class);
        assertEquals(testMember, MEMBER);
    }
}
