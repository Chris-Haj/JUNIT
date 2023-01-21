package MessageTesterPkg;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MessageTesterPkg.MessageUtil;

class MessageTesterClass {

    private static String message;
    private static MessageUtil messageUtil = null;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        message = "Hello World";
        messageUtil = new MessageUtil(message);
    }

    @Test
    void test() {
        assertEquals(message,messageUtil.printMessage());
    }

}
