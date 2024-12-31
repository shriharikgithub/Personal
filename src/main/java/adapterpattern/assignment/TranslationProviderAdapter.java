package adapterpattern.assignment;

import java.util.List;

public interface TranslationProviderAdapter {
    
    List<String> getSupportedLanguages();
    
   String translate(TranslationRequest translationRequest);
}