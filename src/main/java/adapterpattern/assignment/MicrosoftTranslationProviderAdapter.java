package adapterpattern.assignment;

import java.util.List;

import adapterpattern.assignment.external.MicrosoftTranslateApi;
//import com.assignment.question.external.MicrosoftTranslateApi;

public class MicrosoftTranslationProviderAdapter implements TranslationProviderAdapter {

    MicrosoftTranslateApi microsoftTranslateApi;

    public MicrosoftTranslationProviderAdapter() {
        this.microsoftTranslateApi = new MicrosoftTranslateApi();
    }

    @Override
    public List<String> getSupportedLanguages() {
        return microsoftTranslateApi.getSupportedLanguages();
    }

    @Override
    public String translate(TranslationRequest translationRequest) {
        return "";
    }


}
