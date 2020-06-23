import org.junit.jupiter.api.Test;
import ru.vtb.internship.jackson.entity.Member;
import ru.vtb.internship.jackson.entity.Tag;
import ru.vtb.internship.jackson.entity.Task;
import ru.vtb.internship.jackson.utility.FileHelper;
import ru.vtb.internship.jackson.utility.UtilityJason;
import ru.vtb.internship.jackson.utility.UtilityXml;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtilityJson {
    private static final String json = "{\n" +
            "  \"id\": 9,\n" +
            "  \"name\": \"Misha\",\n" +
            "  \"tasks\": [\n" +
            "    {\n" +
            "      \"id\": 1,\n" +
            "      \"name\": \"SomeName\",\n" +
            "      \"tags\": [\n" +
            "        {\n" +
            "          \"id\": 3,\n" +
            "          \"name\": \"Git\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";

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
