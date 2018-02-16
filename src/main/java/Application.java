import com.aquent.service.FileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.aquent")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        // In order to pass arguemnts from command line
        if (args.length == 2) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

            FileService service = context.getBean(FileService.class);
            service.fileSorter(args[0], args[1]);

            context.close();
        }
    }
}
