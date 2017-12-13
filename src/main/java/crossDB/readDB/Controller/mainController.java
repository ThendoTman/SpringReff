package crossDB.readDB.Controller;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author thendo
 */
@Controller
public class mainController {

    @RequestMapping("/hello")
    public String helloWorld() throws SQLException, IOException {

        try {
            Database db = DatabaseBuilder.open(new File("/home/thendo/loc171mdb/2017-1_UNLOCODE_CodeList.mdb"));

            Set<String> tables = db.getTableNames();
            for (String row : tables) {
                System.out.println("Look ma, a row: " + row);
            }

            Table codes = db.getTable("CountryCodes");
            int count = 0;
            for (Row row : codes) {
                count++;

                    System.out.println(count + ".: " + row);
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Hellow Thendo";
    }
}
