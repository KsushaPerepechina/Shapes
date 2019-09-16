package by.epam.cone.creator;

@FunctionalInterface
public interface GenericFigureFactory<T> {
    T create();
}

   /* private static DeveloperFactory createDeveloperFactory(ProgramLanguage language) {
        if(language == ProgramLanguage.JAVA) {
            return new JavaDeveloperFactory();
        } else if(language == ProgramLanguage.CPP) {
            return new CppDeveloperFactory();
        } else {
            throw new RuntimeException("Program language " + language + " is unsupported.");
        }
    }*/
