import com.api.bicicletario.BicicletarioApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BicicletarioApplication.class)
class BicicletarioApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void mainTest() {
        BicicletarioApplication.main(new String[]{});
    }
}
