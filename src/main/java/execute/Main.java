package execute;

import service.factory.ServiceFactory;

/**
 * @author Andrey Volinskiy on 07.02.2018.
 */
public class Main {

    public static void main(String[] args) {

//        ServiceFactory.getVocabularyService().add("Молоко", "milk");
        System.out.println(ServiceFactory.getVocabularyService().translate("butter"));
//        ServiceFactory.getVocabularyService().delete("Стілець");
    }
}
