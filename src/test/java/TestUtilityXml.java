import org.junit.jupiter.api.Test;
import ru.vtb.internship.jackson.entity.Member;
import ru.vtb.internship.jackson.entity.Tag;
import ru.vtb.internship.jackson.entity.Task;
import ru.vtb.internship.jackson.utility.FileHelper;
import ru.vtb.internship.jackson.utility.UtilityXml;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtilityXml {
    private static final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<member>\n" +
            "    <id>9</id>\n" +
            "    <name>Misha</name>\n" +
            "    <tasks>\n" +
            "        <task>\n" +
            "            <id>1</id>\n" +
            "            <name>SomeName</name>\n" +
            "            <tags>\n" +
            "                <tag>\n" +
            "                    <id>3</id>\n" +
            "                    <name>Git</name>\n" +
            "                </tag>\n" +
            "            </tags>\n" +
            "        </task>\n" +
            "    </tasks>\n" +
            "</member>\n";

    private static final Member member;

    static {
        List<Tag> tags = Arrays.asList(new Tag(3, "Git"));
        List<Task> tasks = Arrays.asList(new Task("SomeName", 1, tags));
        member = new Member(9, "Misha", tasks);
    }

    @Test
    public void testGetXmlFromObject() throws Exception {
        String testXml = UtilityXml.getXmlFromObject(member, Member.class);
        assertEquals(testXml, xml);
    }

    @Test
    public void testGetObjectFromXml() throws Exception {
        Member testMember = UtilityXml.getObjectFromXml(xml, Member.class);
        assertEquals(testMember, member);
    }
}
