package service.factory;

import service.VocabularyService;
import service.impl.VocabularyServiceImpl;

/**
 * @author Andrey Volinskiy on 08.02.2018.
 */
public class ServiceFactory {

    public static VocabularyService getVocabularyService() {
        return new VocabularyServiceImpl();
    }
}
