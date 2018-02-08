package execute;

import dao.impl.VocabularyDaoImpl;
import service.factory.ServiceFactory;

/**
 * @author Andrey Volinskiy on 07.02.2018.
 */
public class Main {

    public static void main(String[] args) {

        ServiceFactory.getVocabularyService().add("Україна", "Ukraine");
        System.out.println(ServiceFactory.getVocabularyService().translate("Україна"));
        ServiceFactory.getVocabularyService().delete("Ukraine");
    }
}
