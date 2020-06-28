import org.junit.jupiter.api.Test;
import ru.vtb.internship.entity.Member;
import ru.vtb.internship.entity.Tag;
import ru.vtb.internship.entity.Task;
import ru.vtb.internship.utility.UtilityXml;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtilityXml {
    private static final UtilityXml UTILITY_XML = new UtilityXml();
    private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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
    private static final Member MEMBER;

    static {
        List<Tag> tags = Arrays.asList(new Tag(3, "Git"));
        List<Task> tasks = Arrays.asList(new Task("SomeName", 1, tags));
        MEMBER = new Member(9, "Misha", tasks);
    }

    @Test
    public void testGetXmlFromObject() throws Exception {
        String testXml = UTILITY_XML.getXmlFromObject(MEMBER, Member.class);
        assertEquals(testXml, XML);
    }

    @Test
    public void testGetObjectFromXml() throws Exception {
        Member testMember = UTILITY_XML.getObjectFromXml(XML, Member.class);
        assertEquals(testMember, MEMBER);
    }
}
