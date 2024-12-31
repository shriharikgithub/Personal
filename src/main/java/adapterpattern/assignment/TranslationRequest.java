package adapterpattern.assignment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DO NOT REMOVE THE NO-ARG CONSTRUCTOR ANNOTATION
@NoArgsConstructor
@Getter
@Setter
public class TranslationRequest {
    private String text;
    private String sourceLanguage;
    private String targetLanguage;

    public TranslationRequest(String text, String sourceLanguage, String targetLanguage) {
        this.text = text;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
    }
}