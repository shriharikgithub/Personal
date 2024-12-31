package adapterpattern.assignment;

import java.util.List;

import adapterpattern.assignment.external.GoogleTranslateApi;
import adapterpattern.assignment.external.GoogleTranslationRequest;

public class GoogleTranslationProviderAdapter implements TranslationProviderAdapter {

    GoogleTranslateApi googleTranslateApi;

    GoogleTranslationRequest googleTranslationRequest;

    public GoogleTranslationProviderAdapter(GoogleTranslationRequest googleTranslationRequest) {
        googleTranslateApi = new GoogleTranslateApi();
        this.googleTranslationRequest = googleTranslationRequest;
    }

    @Override
    public List<String> getSupportedLanguages() {
        return googleTranslateApi.getLanguages();
    }

    @Override
    public String translate(TranslationRequest translationRequest) {
        return null;
    }
    
}
